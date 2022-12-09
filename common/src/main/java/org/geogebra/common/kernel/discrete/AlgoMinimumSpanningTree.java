package org.geogebra.common.kernel.discrete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.collections15.Transformer;
import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.PathPoint;
import org.geogebra.common.kernel.SegmentType;
import org.geogebra.common.kernel.commands.Commands;
import org.geogebra.common.kernel.geos.GeoList;
import org.geogebra.common.kernel.kernelND.GeoPointND;
import org.geogebra.common.kernel.matrix.Coords;

import edu.uci.ics.jung.algorithms.shortestpath.MinimumSpanningForest2;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Minimum spanning tree algo
 */
public class AlgoMinimumSpanningTree extends AlgoDiscrete {

	/** number of edges */
	protected int edgeCount;

	private static Transformer<GraphEdge, Double> wtTransformer =
			new Transformer<GraphEdge, Double>() {
		@Override
		public Double transform(GraphEdge link) {
			return link.weight;
		}
	};

	/**
	 * @param cons
	 *            construction
	 * @param label
	 *            output label
	 * @param inputList
	 *            points
	 */
	public AlgoMinimumSpanningTree(Construction cons, String label,
			GeoList inputList) {
		super(cons, label, inputList);
	}

	@Override
	public Commands getClassName() {
		return Commands.MinimumSpanningTree;
	}

	@Override
	public final void compute() {

		size = inputList.size();
		if (!inputList.isDefined() || size == 0) {
			locus.setUndefined();
			return;
		}

		edgeCount = 0;

		HashMap<GeoPointND, GraphNode> nodes = new HashMap<>();
		GraphNode node1, node2;
		UndirectedSparseMultigraph<GraphNode, GraphEdge> g = new UndirectedSparseMultigraph<>();

		for (int i = 0; i < size - 1; i++) {
			GeoPointND p1 = (GeoPointND) inputList.get(i);
			for (int j = i + 1; j < size; j++) {
				GeoPointND p2 = (GeoPointND) inputList.get(j);

				node1 = nodes.get(p1);
				node2 = nodes.get(p2);
				if (node1 == null) {
					node1 = new GraphNode(p1);
					nodes.put(p1, node1);
				}
				if (node2 == null) {
					node2 = new GraphNode(p2);
					nodes.put(p2, node2);
				}

				g.addEdge(
						new GraphEdge(p1.distance(p2), node1, node2, edgeCount++),
						node1,
						node2, EdgeType.UNDIRECTED);

			}

			MinimumSpanningForest2<GraphNode, GraphEdge> prim = new MinimumSpanningForest2<>(
					g, new DelegateForest<GraphNode, GraphEdge>(),
					DelegateTree.<GraphNode, GraphEdge> getFactory(), wtTransformer);

			Forest<GraphNode, GraphEdge> tree = prim.getForest();

			Iterator<GraphEdge> it = tree.getEdges().iterator();

			if (al == null) {
				al = new ArrayList<>();
			} else {
				al.clear();
			}

			while (it.hasNext()) {
				GraphEdge edge = it.next();

				Coords coords = edge.n1.id.getInhomCoordsInD2();
				al.add(new PathPoint(coords.get(1), coords.get(2),
						SegmentType.MOVE_TO));
				coords = edge.n2.id.getInhomCoordsInD2();
				al.add(new PathPoint(coords.get(1), coords.get(2),
						SegmentType.LINE_TO));

			}

			locus.setPoints(al);
			locus.setDefined(true);

		}

	}

	/** Graph edge */
	static class GraphEdge {
		/** start point */
		protected GraphNode n1;
		/** end point */
		protected GraphNode n2;
		/** length */
		double weight;
		/** identifier */
		int id;

		/**
		 * @param weight
		 *            length
		 * @param n1
		 *            start point
		 * @param n2
		 *            end point
		 * @param id
		 *            identifier
		 */
		public GraphEdge(double weight, GraphNode n1, GraphNode n2, int id) {
			this.id = id; // This is defined in the outer class.
			this.weight = weight;
			this.n1 = n1;
			this.n2 = n2;
		}

		@Override
		public String toString() { // Always good for debugging
			return "Edge" + id;
		}
	}
}
