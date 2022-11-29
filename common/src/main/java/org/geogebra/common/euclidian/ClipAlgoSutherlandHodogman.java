package org.geogebra.common.euclidian;

import java.util.ArrayList;
import java.util.List;

import org.geogebra.common.kernel.Kernel;
import org.geogebra.common.kernel.PathPoint;
import org.geogebra.common.util.DoubleUtil;

public class ClipAlgoSutherlandHodogman {

	public static final int EDGE_COUNT = 4;
	public static final double Y_LIMIT = 1E6;

	private double maxValue = Float.MAX_VALUE;

	static class Edge {
		private final PathPoint start;
		private final PathPoint end;

		public Edge(PathPoint start, PathPoint end) {
			this.start = start;
			this.end = end;
		}
	}

	/**
	 * Max value used when calculations produce Infinity or NaN values.
	 * @param maxValue value
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @param input input points
	 * @param clipPoints vertices of clipping polygon
	 * @return clipped points
	 */
	public List<PathPoint> process(List<PathPoint> input, double[][] clipPoints) {
		List<PathPoint> output = input;
		limitYValues(output);
		for (int i = 0; i < EDGE_COUNT; i++) {
			output = clipWithEdge(createEdge(clipPoints, i), output);
		}

		return output;
	}

	private void limitYValues(List<PathPoint> input) {
		input.stream().filter(pt -> pt.y > Y_LIMIT)
				.forEach(pt -> pt.y = Math.signum(pt.y) * Y_LIMIT);
	}

	private Edge createEdge(double[][] clipPoints, int i) {
		return new Edge(createPoint(clipPoints[(i + 3) % EDGE_COUNT]),
				createPoint(clipPoints[i]));
	}

	private PathPoint createPoint(double[] value) {
		return new PathPoint(value[0], value[1]);
	}

	private List<PathPoint> clipWithEdge(Edge edge, List<PathPoint> input) {

		List<PathPoint> output = new ArrayList<>();

		for (int i = 0; i < input.size(); i++) {
			PathPoint prev = input.get((i > 0 ? i : input.size()) - 1);
			PathPoint current = input.get(i);
			addClippedOutput(edge, prev, current, output);
		}
		return output;
	}

	private void addClippedOutput(Edge edge,
			PathPoint prev, PathPoint current, List<PathPoint> output) {
		if (isInside(edge, current)) {
			if (!isInside(edge, prev)) {
				handleIntersectionPoint(edge, prev, current, output);
			}

			output.add(current);

		} else if (isInside(edge, prev)) {
			handleIntersectionPoint(edge, prev, current, output);
		}
	}

	private void handleIntersectionPoint(Edge edge, PathPoint prev,
			PathPoint current, List<PathPoint> output) {
		PathPoint intersection = intersection(edge, prev, current);
		if (intersection == null) {
			current.setLineTo(false);
		} else {
			output.add(intersection);
		}
	}

	private static boolean isInside(Edge edge, PathPoint c) {
		return (edge.start.x - c.x) * (edge.end.y - c.y)
				< (edge.start.y - c.y) * (edge.end.x - c.x);
	}

	private PathPoint intersection(Edge edge, PathPoint p,
			PathPoint q) {
		double a1 = edge.end.y - edge.start.y;
		double b1 = edge.start.x - edge.end.x;
		double c1 = a1 * edge.start.x + b1 * edge.start.y;

		double a2 = q.y - p.y;
		double b2 = p.x - q.x;
		double c2 = getSafeNumber(a2 * p.x + b2 * p.y);

		double det = a1 * b2 - a2 * b1;

		double n1 = b2 * c1 - b1 * c2;
		double x = getSafeNumber(n1 / det);

		double n2 = a1 * c2 - a2 * c1;

		double y = getSafeNumber(n2 / det);

		if (Double.isNaN(x) || Double.isNaN(y))  {
			return null;
		}

		// add 0.0 to avoid -0.0 problem.
		return new PathPoint(x + 0.0, y + 0.0, q.getSegmentType());
	}

	private double getSafeNumber(double value) {
		if (DoubleUtil.isEqual(value, 0)) {
			return Kernel.STANDARD_PRECISION;
		}

		if (DoubleUtil.isEqual(value, Double.POSITIVE_INFINITY)) {
			return maxValue;
		}

		if (DoubleUtil.isEqual(value, Double.NEGATIVE_INFINITY)) {
			return -maxValue;
		}

		return value;

	}
}