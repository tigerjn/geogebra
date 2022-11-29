package org.geogebra.common.kernel.geos;

import org.geogebra.common.kernel.PathPoint;

/**
 * Locus interface to avoid typecast warnings
 *
 */
public interface GeoLocusNDInterface extends GeoLocusable {
	/**
	 * @return this locus
	 */
	GeoLocusND<? extends PathPoint> getLocus();
}
