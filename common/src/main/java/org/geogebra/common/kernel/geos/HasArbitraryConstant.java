package org.geogebra.common.kernel.geos;

import org.geogebra.common.kernel.arithmetic.ArbitraryConstant;

/**
 * These elements use arbitrary constants.
 */
public interface HasArbitraryConstant {

	ArbitraryConstant getArbitraryConstant();

	void setArbitraryConstant(ArbitraryConstant constant);
}
