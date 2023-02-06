package org.geogebra.common.cas.giac;

import static org.geogebra.common.cas.giac.GiacMacro.L;
import static org.geogebra.common.cas.giac.GiacMacro.define;
import static org.geogebra.common.cas.giac.GiacMacro.desolve;
import static org.geogebra.common.cas.giac.GiacMacro.first;
import static org.geogebra.common.cas.giac.GiacMacro.isListType;
import static org.geogebra.common.cas.giac.GiacMacro.last;
import static org.geogebra.common.cas.giac.GiacMacro.normal;
import static org.geogebra.common.cas.giac.GiacMacro.nth;
import static org.geogebra.common.cas.giac.GiacMacro.sizeEquals;
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
						when(sizeEquals(ODE_ANSWER, 0), first(desolveStripY()),
								when(sizeEquals(ODE_ANSWER, 1),
										normal("y=" + first(ODE_ANSWER)),
										last(pickClosestToPoint())
								)
						)
						, last(desolveStripY())))
		);
	}

	// compare 2 solutions, pick one closest to point
	// note: both could go through, pick just one
	private static String pickClosestToPoint() {
		return L(
				L(define("diff0",
						"evalf(subst(odeans,{x=xcoord(%1),y=ycoord(%1)}))")),
				when("abs(diff0[0]-ycoord(%1))<abs(diff0[1]-ycoord(%1))",
	 				normal(first(ODE_ANSWER)), normal(nth(ODE_ANSWER, 1))
				)
		);
	}

	private static String desolveStripY() {
		return desolve(when("(%0)[0]==equal","%0","y'=%0"),
				X, Y, "%1");
	}

	private static String desolveTwoPoints() {
		return desolve(L("%0,y(xcoord(%1[0]))=ycoord(%1[0]), y(xcoord(%1[1]))=ycoord(%1[1])")
				, X, Y);
	}
}
