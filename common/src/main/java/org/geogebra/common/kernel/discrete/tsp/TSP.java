package org.geogebra.common.kernel.discrete.tsp;

import org.geogebra.common.kernel.PathPoint;

public interface TSP {
	double solve(PathPoint[] points);
}
