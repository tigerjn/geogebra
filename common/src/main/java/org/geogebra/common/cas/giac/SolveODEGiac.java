package org.geogebra.common.cas.giac;

import static org.geogebra.common.cas.giac.GiacMacro.L;
import static org.geogebra.common.cas.giac.GiacMacro.define;
import static org.geogebra.common.cas.giac.GiacMacro.desolve;
import static org.geogebra.common.cas.giac.GiacMacro.evalf;
import static org.geogebra.common.cas.giac.GiacMacro.first;
import static org.geogebra.common.cas.giac.GiacMacro.isListType;
import static org.geogebra.common.cas.giac.GiacMacro.last;
import static org.geogebra.common.cas.giac.GiacMacro.normal;
import static org.geogebra.common.cas.giac.GiacMacro.sizeEquals;
import static org.geogebra.common.cas.giac.GiacMacro.subst;
import static org.geogebra.common.cas.giac.GiacMacro.when;

public class SolveODEGiac {

	private static final String X = "x";
	private static final String Y = "y";
	private static final String ODE_ANSWER = "odeans";

	static String get() {
		return first(normal("y="
				+ when(isListType("%1"), desolveTwoPoints(), desolveOnePoint())));

	}

	private static String desolveOnePoint() {
		return L(
				last(L(
						L(define(ODE_ANSWER, desolve("y'=%0", X, Y, "%1")
						)),
						when(sizeEquals(ODE_ANSWER, 0), first(desolve(stripY(), X, Y, "%1")),
								when(sizeEquals(ODE_ANSWER, 1),
										normal("y=" + first(ODE_ANSWER)),
										last(pickClosest())
								)
						)
						, last(desolve(stripY(), X, Y, "%1"))))
		);
	}

	// compare 2 solutions, pick one closest to point
	// note: both could go through, pick just one
	private static String pickClosest() {
		return L(
				L(define("diff0",
						evalf(subst(stripY(), "y=" + ODE_ANSWER)))),
				when("diff0[0] < diff0[1]",
	 				normal(first("diff0")), normal(last("diff0"))
				)
		);
	}

	private static String stripY() {
		return when("(%0)[0]==equal", "%0", "y'=%0");
	}

	private static String desolveTwoPoints() {
		return desolve(L("%0,y(xcoord(%1[0]))=ycoord(%1[0]), y(xcoord(%1[1]))=ycoord(%1[1])")
				, X, Y);
	}
}
