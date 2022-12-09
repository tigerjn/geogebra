/* 
GeoGebra - Dynamic Mathematics for Everyone
http://www.geogebra.org

This file is part of GeoGebra.

This program is free software; you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by 
the Free Software Foundation.

 */

/*
 * GeoVec2D.java
 *
 * Created on 31. August 2001, 11:34
 */

package org.geogebra.common.kernel.arithmetic;

import org.geogebra.common.kernel.Kernel;
import org.geogebra.common.kernel.StringTemplate;

/**
 * 
 * @author Michael
 */
public class NumberPair extends MyVecNode {
	/**
	 * Creates new number pair
	 * 
	 * @param kernel
	 *            kernel
	 * @param en
	 *            first number
	 * @param en2
	 *            second number
	 */
	public NumberPair(Kernel kernel, ExpressionValue en,
			ExpressionValue en2) {
		super(kernel, en, en2);
	}

	/**
	 * @param kernel
	 *            kernel
	 */
	public NumberPair(Kernel kernel) {
		super(kernel, new MyDouble(kernel), new MyDouble(kernel));
	}

	@Override
	public NumberPair deepCopy(Kernel kernel1) {
		return new NumberPair(kernel1, x.deepCopy(kernel1),
				y.deepCopy(kernel1));
	}

	@Override
	final public String toString(StringTemplate tpl) {
		StringBuilder sb = new StringBuilder();
		sb.append(x.toString(tpl));
		sb.append(", ");
		sb.append(y.toString(tpl));

		return sb.toString();
	}

	@Override
	final public String toValueString(StringTemplate tpl) {
		StringBuilder sb = new StringBuilder();
		sb.append(x.toValueString(tpl));
		sb.append(", ");
		sb.append(y.toValueString(tpl));

		return sb.toString();
	}

	@Override
	final public ExpressionValue traverse(Traversing t) {
		ExpressionValue v = t.process(this);
		if (v != this) {
			return v;
		}
		x = x.traverse(t);
		y = y.traverse(t);
		return this;
	}

	/**
	 * @param x
	 *            x coordinate
	 */
	public void setX(ExpressionValue x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            y cordinate
	 */
	public void setY(ExpressionValue y) {
		this.y = y;
	}

	@Override
	final public String toLaTeXString(boolean symbolic, StringTemplate tpl) {
		return symbolic ? toString(tpl) : toValueString(tpl);
	}

}
