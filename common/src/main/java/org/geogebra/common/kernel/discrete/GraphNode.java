package org.geogebra.common.kernel.discrete;

import org.geogebra.common.kernel.kernelND.GeoPointND;

public class GraphNode {
	public GeoPointND id;

	public GraphNode(GeoPointND id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Vertex:" + id;
	}
}