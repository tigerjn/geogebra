/* 
GeoGebra - Dynamic Mathematics for Everyone
http://www.geogebra.org

This file is part of GeoGebra.

This program is free software; you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation.

 */

package org.geogebra.common.kernel;

import java.util.LinkedHashMap;

import org.geogebra.common.io.ConstructionXmlHandler;
import org.geogebra.common.kernel.algos.AlgoDispatcher;
import org.geogebra.common.kernel.arithmetic.ExpressionNodeEvaluator;
import org.geogebra.common.kernel.commands.AlgebraProcessor;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.kernelND.GeoDirectionND;
import org.geogebra.common.kernel.kernelND.GeoPlaneND;
import org.geogebra.common.main.MyError;
import org.geogebra.common.util.MaxSizeHashMap;

/**
 * Kernel with its own construction for macros.
 */
public class MacroKernel extends Kernel {

	private Kernel parentKernel;
	private MacroConstruction macroCons;

	/**
	 * Creates new kernel for macro
	 * 
	 * @param parentKernel
	 *            kernel of construction in which we want to use this macro
	 */
	public MacroKernel(Kernel parentKernel) {
		super(parentKernel.getGeoFactory());
		this.parentKernel = parentKernel;

		app = parentKernel.getApplication();
		setUndoActive(false);
		setAllowVisibilitySideEffects(false);

		macroCons = new MacroConstruction(this);
		cons = macroCons;

		// does 3D as parentKernel
		setManager3D(getSuperParentKernel().newManager3D(this));
	}

	@Override
	public final boolean isMacroKernel() {
		return true;
	}

	/**
	 * @return kernel for construction using this macro (might return
	 *         MacroKernel)
	 */
	public Kernel getParentKernel() {
		return parentKernel;
	}

	/**
	 * @return root kernel for construction using this macro will return either
	 *         a "Kernel" or "Kernel3D" object
	 */
	public Kernel getSuperParentKernel() {

		Kernel k = parentKernel;

		while (k instanceof MacroKernel) {
			k = ((MacroKernel) k).getParentKernel();
		}

		return k;
	}

	// public boolean isUseTempVariablePrefix() {
	// return super.isUseTempVariablePrefix();
	// }
	//
	// public void setUseTempVariablePrefix(boolean flag) {
	// useTempVariablePrefix = flag;
	// super.setUseTempVariablePrefix(flag);
	// }
	/**
	 * @param label
	 *            reserved label
	 */
	public void addReservedLabel(String label) {
		macroCons.addReservedLabel(label);
	}

	/**
	 * @param flag
	 *            when true, variables are looked up in parent construction as
	 *            well
	 */
	public void setGlobalVariableLookup(boolean flag) {
		macroCons.setGlobalVariableLookup(flag);
	}

	/**
	 * Sets macro construction of this kernel via XML string.
	 * 
	 * @param xmlString
	 *            XML representation of the construction
	 * @throws Exception
	 *             if reading XML fails
	 */
	public void loadXML(String xmlString) throws Exception {
		macroCons.loadXML(xmlString);
	}

	@Override
	public final double getXmax() {
		return parentKernel.getXmax();
	}

	@Override
	public final double getXmin() {
		return parentKernel.getXmin();
	}

	@Override
	public final double getXscale() {
		return parentKernel.getXscale();
	}

	@Override
	public final double getYmax() {
		return parentKernel.getYmax();
	}

	@Override
	public final double getYmin() {
		return parentKernel.getYmin();
	}

	@Override
	public final double getYscale() {
		return parentKernel.getYscale();
	}

	/**
	 * Adds a new macro to the parent kernel.
	 */
	@Override
	public void addMacro(Macro macro) {
		parentKernel.addMacro(macro);
	}

	/**
	 * Returns the macro object for the given macro name. Note: null may be
	 * returned.
	 */
	@Override
	public Macro getMacro(String name) {
		return parentKernel.getMacro(name);
	}

	// //////////////////////////////////////
	// METHODS USING KERNEL3D
	// //////////////////////////////////////

	@Override
	public ConstructionXmlHandler newMyXMLHandler(Construction cons1) {
		return parentKernel.newMyXMLHandler(this, cons1);
	}

	@Override
	public AlgebraProcessor newAlgebraProcessor(Kernel kernel) {
		return parentKernel.newAlgebraProcessor(kernel);
	}

	@Override
	public ExpressionNodeEvaluator newExpressionNodeEvaluator(Kernel kernel) {
		return parentKernel.newExpressionNodeEvaluator(kernel);
	}

	@Override
	public GeoElement createGeoElement(Construction cons1, String type)
			throws MyError {
		return parentKernel.createGeoElement(cons1, type);
	}

	@Override
	public boolean handleCoords(GeoElement geo,
			LinkedHashMap<String, String> attrs) {
		return parentKernel.handleCoords(geo, attrs);
	}

	/**
	 * Returns the parent kernel's GeoGebraCAS object.
	 */
	@Override
	public synchronized GeoGebraCasInterface getGeoGebraCAS() {
		return parentKernel.getGeoGebraCAS();
	}

	/**
	 * @return Whether the GeoGebraCAS of the parent kernel has been initialized
	 *         before
	 */
	@Override
	public synchronized boolean isGeoGebraCASready() {
		return parentKernel.isGeoGebraCASready();
	}

	/**
	 * @return Hash map for caching CAS results from parent kernel.
	 */
	@Override
	public MaxSizeHashMap<String, String> getCasCache() {
		return parentKernel.getCasCache();
	}

	/**
	 * @return Whether parent kernel is already using CAS caching.
	 */
	@Override
	public boolean hasCasCache() {
		return parentKernel.hasCasCache();
	}

	@Override
	protected AlgoDispatcher newAlgoDispatcher(Construction cons1) {
		return this.parentKernel.newAlgoDispatcher(cons1);
	}

	@Override
	public boolean isZvarAllowed() {
		return parentKernel.isZvarAllowed();
	}

	@Override
	public GeoPlaneND getDefaultPlane() {
		return parentKernel.getDefaultPlane();
	}

	@Override
	public GeoDirectionND getSpace() {
		return parentKernel.getSpace();
	}

	@Override
	public ConstructionCompanion createConstructionCompanion(
			Construction cons1) {
		return parentKernel.createConstructionCompanion(cons1);
	}

}
