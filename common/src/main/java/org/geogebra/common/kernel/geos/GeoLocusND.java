/* 
GeoGebra - Dynamic Mathematics for Everyone
http://www.geogebra.org

This file is part of GeoGebra.

This program is free software; you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation.

 */

package org.geogebra.common.kernel.geos;

import java.util.ArrayList;

import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.FixedPathRegionAlgo;
import org.geogebra.common.kernel.Path;
import org.geogebra.common.kernel.PathMover;
import org.geogebra.common.kernel.PathMoverLocus;
import org.geogebra.common.kernel.PathParameter;
import org.geogebra.common.kernel.PathPoint;
import org.geogebra.common.kernel.SegmentType;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.algos.AlgoElement;
import org.geogebra.common.kernel.algos.AlgoLocusSliderInterface;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.kernel.kernelND.GeoPointND;
import org.geogebra.common.kernel.kernelND.GeoSegmentND;
import org.geogebra.common.kernel.matrix.Coords;
import org.geogebra.common.plugin.GeoClass;
import org.geogebra.common.util.ExtendedBoolean;

/**
 * Locus of points
 * 
 * @author Markus
 * @param <T>
 *            2D or 3D point type
 */
public abstract class GeoLocusND<T extends PathPoint> extends GeoElement
		implements Path, Traceable, GeoLocusNDInterface {

	/** maximal number of runs through the path when computing */
	public static final int MAX_PATH_RUNS = 10;

	private boolean defined;

	/** coords of points on locus */
	protected ArrayList<T> myPointList;
	private double closestPointDist;
	/**
	 * index of point closest to changingPoint
	 */
	protected int closestPointIndex;
	/**
	 * parameter of point closest to changingPoint
	 */
	protected double closestPointParameter;

	private boolean trace;

	/**
	 * Creates new locus
	 * 
	 * @param c
	 *            construction
	 */
	public GeoLocusND(Construction c) {
		super(c);

		// moved from GeoElement's constructor
		// must be called from the subclass, see
		// http://benpryor.com/blog/2008/01/02/dont-call-subclass-methods-from-a-superclass-constructor/
		setConstructionDefaults(); // init visual settings
		myPointList = new ArrayList<>(500);
	}

	@Override
	public GeoElement copy() {
		GeoLocusND<T> ret = newGeoLocus();
		ret.set(this);
		return ret;
	}

	/**
	 * 
	 * @return new GeoLocus of same type
	 */
	abstract protected GeoLocusND<T> newGeoLocus();

	@SuppressWarnings("unchecked")
	@Override
	public void set(GeoElementND geo) {
		if (geo instanceof GeoLocusND) {
			GeoLocusND<T> locus = (GeoLocusND<T>) geo;
			defined = locus.defined;

			myPointList.clear();
			for (PathPoint pt : locus.myPointList) {
				myPointList.add((T) pt.copy());
			}
		}
	}

	/**
	 * Number of valid points in x and y arrays.
	 * 
	 * @return number of valid points in x and y arrays.
	 */
	@Override
	final public int getPointLength() {
		return myPointList.size();
	}

	/**
	 * Clears list of points defining this locus
	 */
	public void clearPoints() {
		myPointList.clear();
	}

	/**
	 * @return list of points that define this locus
	 */
	@Override
	public ArrayList<T> getPoints() {
		return myPointList;
	}

	@Override
	public String toString(StringTemplate tpl) {
		return label + " = " + getDefinition(tpl);
	}

	@Override
	public GeoClass getGeoClassType() {
		return GeoClass.LOCUS;
	}

	/**
	 * returns all class-specific xml tags for getXML
	 */
	@Override
	protected void getStyleXML(StringBuilder sb) {
		super.getStyleXML(sb);
		getLineStyleXML(sb);
	}

	@Override
	public boolean isDefined() {
		return defined;
	}

	/**
	 * @param flag
	 *            true to make this locus defined
	 */
	public void setDefined(boolean flag) {
		defined = flag;
	}

	@Override
	public void setUndefined() {
		defined = false;
	}

	@Override
	public String toValueString(StringTemplate tpl) {
		return getDefinition(tpl);
	}

	@Override
	protected boolean showInEuclidianView() {
		return isDefined();
	}

	@Override
	public boolean isGeoLocus() {
		return true;
	}

	@Override
	public double getMaxParameter() {
		return myPointList.size() - 1;
	}

	@Override
	public double getMinParameter() {
		return 0;
	}

	@Override
	public boolean isClosedPath() {
		if (myPointList.size() > 0) {
			PathPoint first = myPointList.get(0);
			PathPoint last = myPointList.get(myPointList.size() - 1);
			return first.isEqual(last);
		}
		return false;
	}

	@Override
	public boolean isOnPath(GeoPointND P, double eps) {

		setChangingPoint(P);
		PathPoint closestPoint = getClosestPoint();
		if (closestPoint != null) {
			return closestPointDist < eps;
		}
		return false;
	}

	/**
	 * set infos for current changing point
	 * 
	 * @param P
	 *            point
	 */
	abstract protected void setChangingPoint(GeoPointND P);

	/**
	 * 
	 * @param segment
	 *            segment
	 * @return closest parameter on the segment from the changing point
	 */
	abstract protected double getChangingPointParameter(GeoSegmentND segment);

	/**
	 * @return closest point to changing point
	 */
	protected PathPoint getClosestPoint() {
		getClosestLine();

		GeoSegmentND closestSegment = newGeoSegment();

		if (closestPointIndex == -1) {
			return null;
		}

		PathPoint locusPoint = myPointList.get(closestPointIndex);
		PathPoint locusPoint2 = myPointList.get(closestPointIndex + 1);

		closestSegment.setCoords(locusPoint, locusPoint2);

		closestPointParameter = getChangingPointParameter(closestSegment);

		if (closestPointParameter < 0) {
			closestPointParameter = 0;
		} else if (closestPointParameter > 1) {
			closestPointParameter = 1;
		}

		return locusPoint.barycenter(closestPointParameter, locusPoint2);
	}

	/**
	 * 
	 * @return new GeoSegment
	 */
	abstract protected GeoSegmentND newGeoSegment();

	/**
	 * 
	 * @param segment
	 *            segment
	 * @return distance from current point infos to segment
	 */
	abstract protected double changingPointDistance(GeoSegmentND segment);

	/**
	 * Adds a new point (x,y,z) to the end of the point list of this locus.
	 * @param x x-coord
	 * @param y y-coord
	 * @param z z-coord, ignored for 2D loci
	 * @param lineTo true for lineTo, false for moveTo
	 */
	public abstract void insertPoint(double x, double y, double z, boolean lineTo);

	/**
	 * Returns the point of this locus that is closest to current point infos.
	 */
	private void getClosestLine() {
		int size = myPointList.size();
		if (size == 0) {
			return;
		}

		// search for closest point on path
		// MyPoint closestPoint = null;
		closestPointDist = Double.MAX_VALUE;
		closestPointIndex = -1;

		// make a segment and points to reuse
		GeoSegmentND segment = newGeoSegment();

		// search for closest point
		for (int i = 0; i < size - 1; i++) {
			PathPoint locusPoint = myPointList.get(i);
			PathPoint locusPoint2 = myPointList.get(i + 1);

			// not a line, just a move (eg Voronoi Diagram)
			if (locusPoint2.getSegmentType() == SegmentType.MOVE_TO) {
				continue;
			}

			// line thro' 2 points
			segment.setCoords(locusPoint, locusPoint2);

			double dist = changingPointDistance(segment);
			if (dist < closestPointDist) {
				closestPointDist = dist;
				closestPointIndex = i;
			}
		}
	}

	@Override
	public void pathChanged(GeoPointND P) {

		// if kernel doesn't use path/region parameters, do as if point changed
		// its coords
		// TRAC-4261 if segment number changed during file loading (EV viewport)
		// and parameter is not set by parent (APPS-3931) also don't use the new path update method
		if (!getKernel().usePathAndRegionParameters(P)
				|| (cons.isFileLoading() && isChangeableParam(P))) {
			pointChanged(P);
			return;
		}

		// find closest point on changed path to P
		if (getParentAlgorithm() instanceof AlgoLocusSliderInterface) {
			pointChanged(P);
			return;
		}

		// new method
		// keep point on same segment, the same proportion along it
		// better for loci with very few segments eg from ShortestDistance[ ]
		PathParameter pp = P.getPathParameter();

		int n = (int) Math.floor(pp.t);

		double t = pp.t - n; // between 0 and 1

		// check n and n+1 are in a sensible range
		// might occur if locus has changed no of segments/points
		if (myPointList.size() == 0) {
			P.setUndefined();
			return;
		} else if (myPointList.size() == 1) {
			PathPoint p0 = myPointList.get(0);
			P.set(1, 0, p0, p0);
			return;
		} else if (n >= myPointList.size() || n < 0) {
			n = (n < 0) ? 0 : myPointList.size() - 1;
		}
		PathPoint locusPoint = myPointList.get(n);
		PathPoint locusPoint2 = myPointList.get((n + 1) % myPointList.size());
		P.set(t, 1 - t, locusPoint, locusPoint2);
	}

	protected boolean isChangeableParam(GeoPointND p) {
		AlgoElement parentAlgorithm = p.getParentAlgorithm();
		return !(parentAlgorithm instanceof FixedPathRegionAlgo)
				|| ((FixedPathRegionAlgo) parentAlgorithm).isChangeable(p);
	}

	/**
	 * @param P
	 *            point
	 * @param pp
	 *            path parameter
	 */
	public void pathChanged(Coords P, PathParameter pp) {
		int n = (int) Math.floor(pp.t);

		double t = pp.t - n; // between 0 and 1

		// check n and n+1 are in a sensible range
		// might occur if locus has changed no of segments/points
		if (n >= myPointList.size() || n < 0) {
			n = (n < 0) ? 0 : myPointList.size() - 1;
		}

		PathPoint locusPoint = myPointList.get(n);
		PathPoint locusPoint2 = myPointList.get((n + 1) % myPointList.size());

		P.set(t, 1 - t, locusPoint, locusPoint2);
	}

	@Override
	public boolean isPath() {
		return true;
	}

	@Override
	final public ExtendedBoolean isEqualExtended(GeoElementND geo) {
		// return false if it's a different type, otherwise use equals() method
		return ExtendedBoolean.newExtendedBoolean(this == geo); // TODO?
	}

	/**
	 * Returns whether the value (e.g. equation) should be shown as part of the
	 * label description
	 */
	@Override
	final public boolean isLabelValueShowable() {
		return true;
	}

	@Override
	final public boolean isLabelShowable() {
		return true;
	}

	/**
	 * @param al
	 *            list of points that definr this locus
	 */
	public void setPoints(ArrayList<T> al) {
		myPointList = al;
	}

	@Override
	final public boolean isAuxiliaryObjectByDefault() {
		return true;
	}

	@Override
	public void setTrace(boolean trace) {
		this.trace = trace;
	}

	@Override
	public boolean getTrace() {
		return trace;
	}

	@Override
	public boolean isTraceable() {
		return true;
	}

	@Override
	public boolean isFillable() {
		return true;
	}

	@Override
	public boolean isInverseFillable() {
		return true;
	}

	@Override
	final public PathMover createPathMover() {
		return new PathMoverLocus<>(this);
	}

	@Override
	public boolean hasDrawable3D() {
		return true;
	}

	@Override
	public GeoLocusND<? extends PathPoint> getLocus() {
		return this;
	}
}
