package org.geogebra.common.kernel.discrete.tsp;

import org.geogebra.common.kernel.PathPoint;
import org.geogebra.common.kernel.discrete.tsp.impl.FLS;

public final class TSPSolver implements TSP {

	@Override
	public double solve(final PathPoint[] points) {
		return FLS.optimise(points);
	}
}
