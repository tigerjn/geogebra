package org.geogebra.common.kernel.geos;

import static java.lang.Math.PI;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.geogebra.common.BaseUnitTest;
import org.geogebra.common.kernel.Kernel;
import org.geogebra.common.kernel.PathPoint;
import org.geogebra.common.kernel.arithmetic.MyDouble;
import org.geogebra.common.kernel.matrix.Coords;
import org.geogebra.test.UndoRedoTester;
import org.junit.Assert;
import org.junit.Test;

public class GeoLocusStrokeTest extends BaseUnitTest {

	private static final double r2 = sqrt(2);
	private static final double r5 = sqrt(5);
	private static final double r8 = sqrt(8);

	@Test
	public void rotateLocusStrokeTest() {
		GeoLocusStroke stroke = getInitialStroke();

		stroke.rotate(new MyDouble(getKernel(), PI / 3));

		double arg1 = -3 * PI / 4 + PI / 3;
		double arg2 = -PI / 4 + PI / 3;
		double arg3 = atan(0.5) + PI / 3;
		double arg4 = PI / 2 + PI / 3;

		PathPoint[] rotatedPoints = new PathPoint[] {
				new PathPoint(r2 * cos(arg1), r2 * sin(arg1)),
				new PathPoint(r2 * cos(arg2), r2 * sin(arg2)),
				new PathPoint(r5 * cos(arg3), r5 * sin(arg3)),
				new PathPoint(cos(arg4), sin(arg4)),
				new PathPoint(0, 0)
		};

		assertPointsEqual(rotatedPoints, stroke.getPoints());
	}

	@Test
	public void rotateLocusStrokeAroundPointTest() {
		GeoLocusStroke stroke = getInitialStroke();

		stroke.rotate(new MyDouble(getKernel(), PI / 6),
				new GeoPoint(getConstruction(), 1.0, 1.0, 1.0));

		double arg1 = -3 * PI / 4 + PI / 6;
		double arg2 = -PI / 2 + PI / 6;
		double arg3 = PI / 6;
		double arg4 = PI + PI / 6;
		double arg5 = -3 * PI / 4 + PI / 6;

		PathPoint[] rotatedPoints = new PathPoint[] {
				new PathPoint(r8 * cos(arg1) + 1, r8 * sin(arg1) + 1),
				new PathPoint(2 * cos(arg2) + 1, 2 * sin(arg2) + 1),
				new PathPoint(cos(arg3) + 1, sin(arg3) + 1),
				new PathPoint(cos(arg4) + 1, sin(arg4) + 1),
				new PathPoint(r2 * cos(arg5) + 1, r2 * sin(arg5) + 1)
		};

		assertPointsEqual(rotatedPoints, stroke.getPoints());
	}

	@Test
	public void mirrorLocusStrokeOnPointTest() {
		GeoLocusStroke stroke = getInitialStroke();

		stroke.mirror(new Coords(3, 2));

		PathPoint[] mirroredPoints = new PathPoint[] {
				new PathPoint(7, 5),
				new PathPoint(5, 5),
				new PathPoint(4, 3),
				new PathPoint(6, 3),
				new PathPoint(6, 4)
		};

		assertPointsEqual(mirroredPoints, stroke.getPoints());
	}

	@Test
	public void mirrorLocusStrokeOnLineTest() {
		GeoLocusStroke stroke = getInitialStroke();

		GeoLine line = new GeoLine(getConstruction());
		GeoVec3D.lineThroughPointVector(
				new GeoPoint(getConstruction(), 2, 0, 1.0),
				new GeoVector(getConstruction(), null, 1, 1, 1),
				line);

		stroke.mirror(line);

		PathPoint[] mirroredPoints = new PathPoint[] {
				new PathPoint(1, -3),
				new PathPoint(1, -1),
				new PathPoint(3, 0),
				new PathPoint(3, -2),
				new PathPoint(2, -2)
		};

		assertPointsEqual(mirroredPoints, stroke.getPoints());
	}

	@Test
	public void dilateLocusStrokeTest() {
		GeoLocusStroke stroke = getInitialStroke();

		stroke.dilate(new MyDouble(getKernel(), 2.0), new Coords(1, 0));

		PathPoint[] dilatedPoints = new PathPoint[] {
				new PathPoint(-3, -2),
				new PathPoint(1, -2),
				new PathPoint(3, 2),
				new PathPoint(-1, 2),
				new PathPoint(-1, 0)
		};

		assertPointsEqual(dilatedPoints, stroke.getPoints());
	}

	@Test
	public void undoRedoTest() {
		getApp().setGraphingConfig();
		UndoRedoTester undoRedoTester = new UndoRedoTester(getApp());
		undoRedoTester.setupUndoRedo();

		addAvInput("stroke = Polyline((1, 3), (4, 3), true)");
		undoRedoTester.undo();
		GeoLocusStroke stroke = undoRedoTester.getAfterRedo("stroke");
		assertThat(stroke, is(notNullValue()));
	}

	@Test
	public void locusBasedOnStrokeShouldHaveEnoughPoints() {
		addAvInput("stroke = Polyline((1, 3), (4, 3), (2,5), true)");
		add("A=Point(stroke)");
		add("B=A-(1,1)");
		add("loc=Locus(B,A)");
		GeoElement perimeter = add("Perimeter(loc)");
		assertThat(perimeter, hasValue("8.22"));
	}

	private GeoLocusStroke getInitialStroke() {
		ArrayList<PathPoint> initialPoints = new ArrayList<>(Arrays.asList(
				new PathPoint(-1, -1),
				new PathPoint(1, -1),
				new PathPoint(2, 1),
				new PathPoint(0, 1),
				new PathPoint(0, 0)
		));

		GeoLocusStroke stroke = new GeoLocusStroke(getConstruction());
		stroke.setPoints(initialPoints);

		return stroke;
	}

	private void assertPointsEqual(PathPoint[] expected, ArrayList<PathPoint> actual) {
		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals("differ at element " + i + ".x", expected[i].x,
					actual.get(i).x, Kernel.MAX_PRECISION);
			Assert.assertEquals("differ at element " + i + ".x", expected[i].y,
					actual.get(i).y, Kernel.MAX_PRECISION);
		}
	}
}
