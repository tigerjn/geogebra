package org.geogebra.common.cas.giac;

import static org.geogebra.common.cas.giac.GiacMacro.L;
import static org.geogebra.common.cas.giac.GiacMacro.first;
import static org.geogebra.common.cas.giac.GiacMacro.isListType;
import static org.geogebra.common.cas.giac.GiacMacro.last;
import static org.geogebra.common.cas.giac.GiacMacro.when;

public class SolveODEGiac {
	private static final String DESOLVE_STRIP_Y =
			"desolve(when((%0)[0]==equal,%0,y'=%0),x,y,%1)";
	private static final String DESOLVE_WITH_DIFF =
			"["
					+ "[diff0:=evalf(subst(odeans,{x=xcoord(%1),y=ycoord(%1)}))],"
					// compare 2 solutions, pick one closest to point
					// note: both could go through, pick just one
					+ "when(abs(diff0[0]-ycoord(%1))<abs(diff0[1]-ycoord(%1)),"
					+ "normal(odeans[0]),"
					+ "normal(odeans[1])"
					+ ")"
					+ "]";

	static String get() {
		return first("normal("
				+ "y="
				+ when(isListType("%1"), // list of 2 points
				getDesolveTwoPoints(),
				// one point
				L(
						last(L(
								L("odeans:=desolve(y'=%0,x,y,%1)"),
								when("size(odeans)==0", first(desolveStripY()),
										when("size(odeans) == 1",
												"normal(y=odeans[0])",
												last(DESOLVE_WITH_DIFF)
										)
								)
								,last(desolveStripY())))
				)
		));

	}

	private static String desolveStripY() {
		return DESOLVE_STRIP_Y;
	}

	private static String getDesolveTwoPoints() {
		return "desolve(" + L("%0,"
				+ "y(xcoord(%1[0]))=ycoord(%1[0]), y(xcoord(%1[1]))=ycoord(%1[1])")
				+ ",x,y)";
	}

}
