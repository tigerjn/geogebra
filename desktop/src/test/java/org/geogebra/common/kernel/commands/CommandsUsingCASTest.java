package org.geogebra.common.kernel.commands;

import static com.himamis.retex.editor.share.util.Unicode.INFINITY;
import static org.geogebra.test.TestStringUtil.unicode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import org.geogebra.common.cas.CASparser;
import org.geogebra.common.euclidian.EuclidianView;
import org.geogebra.common.factories.CASFactory;
import org.geogebra.common.gui.view.algebra.AlgebraItem;
import org.geogebra.common.kernel.CASGenericInterface;
import org.geogebra.common.kernel.Kernel;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoImage;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.main.App;
import org.geogebra.desktop.util.GuiResourcesD;
import org.geogebra.desktop.util.ImageManagerD;
import org.geogebra.test.TestErrorHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.himamis.retex.editor.share.util.Unicode;

public class CommandsUsingCASTest extends AlgebraTest {

	private void add(String string) {
		ap.processAlgebraCommand(string, false);
	}

	private void runSolveTests() {
		t("ss=Solve[ x^2=3 ]", "{x = (-sqrt(3)), x = sqrt(3)}");
		Assert.assertTrue(AlgebraItem.isSymbolicDiffers(get("ss")));
		t("sm=Solve[ {x+y=1,x-y=0} ]", "{{x = 1 / 2, y = 1 / 2}}");
		Assert.assertTrue(AlgebraItem.isSymbolicDiffers(get("sm")));
		t("Solve[ x^2=-1 ]", "{}");
		t("Solve[ x=x ]", "{x = x}");
		t("Solve[ erf(x)=0.5 ]", "?");
		tdeg("r=Solve[ sin(x)=0 ]", "{x = 0*deg}");
		tdeg("r2=Solve[ {sin(x)=0, x=y} ]", "{{x = 0*deg, y = 0*deg}}");
		tdeg("r=Solve[ cos(x)=1/sqrt(2) ]", "{x = (-45*deg), x = 45*deg}");
		tdeg("r2=Solve[ {cos(x)=1/2, x=y} ]",
				"{{x = 60*deg, y = 60*deg}, {x = (-60*deg), y = (-60*deg)}}");
	}

	private void deg(String def, String expect) {
		EvalInfo evalInfo = new EvalInfo(true, true).addDegree(true);
		checkWithEvalInfo(def, expect, evalInfo);
	}

	private void checkWithEvalInfo(String def, String expect,
			EvalInfo evalInfo) {
		GeoElementND[] geo = ap.processAlgebraCommandNoExceptionHandling(def,
				false, TestErrorHandler.INSTANCE,
				evalInfo, null);
		String res = geo[0].toValueString(StringTemplate.editTemplate);
		Assert.assertEquals(expect, res);
	}

	private void tdeg(String string, String string2) {
		t(string, string2.replace("deg", Unicode.DEGREE_STRING));
	}

	private GeoElement get(String label) {
		return app.getKernel().lookupLabel(label);
	}

	@Before
	public void resetSyntaxes() {
		CommandsTest.resetSyntaxCounter();
		app.getKernel().clearConstruction(true);
		app.getKernel().setPrintDecimals(2);
		app.setActiveView(App.VIEW_EUCLIDIAN);
		app.getKernel().setPrintDecimals(2);
	}

	@After
	public void checkSyntaxes() {
		CommandsTest.checkSyntaxesStatic();
	}

	@Test
	public void conditionalDerivativeTest() {
		t("f(x)=If[x>0,x^2]", "If[x > 0, x^(2)]");
		t("f'(x)=Derivative[f]", "If[x > 0, (2 * x)]");
		t("f'(3)", "6");
		t("g(x,y)=If[x+y>0,x^2+x*y]", "If[x + y > 0, x^(2) + (x * y)]");
		t("h(x,y)=Derivative[g, x]", "If[x + y > 0, (2 * x) + y]");
		t("h(1,3)", "5");
	}

	@Test
	public void cmdSimplify() {
		t("Simplify[ sin^2(x)+cos^2(x) ]", "1");
		t("Simplify[ 2/sqrt(2) ]", "sqrt(2)");
		t("Simplify[\"x+-x--x\"]", "x " + Unicode.MINUS + " x + x");
		t("sa=1", "1");
		t("sb=2", "2");
		t("sc=sa+sb", "3");
		t("Simplify(sc*x^2)", "(3 * x^(2))");
	}

	@Test
	public void cmdIntegral() {
		t("Integral[ sin(x) ]", "(-cos(x))");
		t("Integral[ x^2, x ]", "(1 / 3 * x^(3))");
		t("Integral[ sin(x),0,pi ]", "2");
		t("Integral[ abs(x),-2,2 ]", "4");
		t("Integral[ sin(x), 0, 100, false ]", "NaN");

		// https://help.geogebra.org/topic/integralbetween-yields-undefined-result
		t("intFunf:=x - floor(2x) / 2", "x - floor((2 * x)) / 2");
		t("intFunq:=2floor(2x - 2floor(x)) - 1",
				"(2 * floor((2 * x) - (2 * floor(x)))) - 1");
		t("intFung:=sqrt(-x^2 + 1)", "sqrt((-x^(2)) + 1)");
		t("intFung1:=3 / 2 floor(2x - 2floor(x)) - 1",
				"(3 / 2 * floor((2 * x) - (2 * floor(x)))) - 1");
		t("intFunr:=-sqrt(3) floor(x + 1 / 2)",
				"((-sqrt(3)) * floor(x + 1 / 2))");
		t("intFunh:=intFunf(x) + intFung1(x)",
				"x - floor((2 * x)) / 2 + (3 / 2 * floor((2 * x) - (2 * floor(x)))) - 1");
		t("intFunp:=intFunq(x) intFung(intFunh(x)) + intFunr(x) + sqrt(3)",
				"(((2 * floor((2 * x) - (2 * floor(x)))) - 1) * sqrt((-(x - "
						+ "floor((2 * x)) / 2 + (3 / 2 * floor((2 * x) - (2 * floor(x)))) - "
						+ "1)^(2)) + 1)) + ((-sqrt(3)) * floor(x + 1 / 2)) + sqrt(3)");
		// can work if native Giac is forced in AlgoIntegralDefinite
		// but causes problems for other cases
		// t("NIntegral(intFunp, 1 / 2, 2)", "-0.5589329791322");
		// t("Integral(intFunp, 1 / 2, 2)", "-0.5589329791322");
		t("Integral(1/(x^2+1),-inf,inf)", "3.14159265359");
		t("Integral(1/(x^2+1),0,inf)", "1.570796326795");
		t("Integral(1/(x^2+1),-inf,0)", "1.570796326795");
	}

	@Test
	public void cmdIntegralInfinite() {
		t("f=Normal(50,3,x,false)",
				"exp(((-(x - 50)^(2))) / ((3^(2) * 2))) / ((abs(3) * sqrt((2 * pi))))");
		tRound("norm:=Integral[f,-inf,50 ]", "0.5");
		tRound("nnorm:=Integral[f,50,inf ]", "0.5");
	}

	@Test
	public void cmdNSolve() {
		tRound("NSolve[ x^2=3 ]", "{x = -1.73205, x = 1.73205}");
		t("NSolve[ x^2=-1 ]", "{}");
		tRound("NSolve[ erf(x)=0.5 ]", "{x = 0.47694}");
		tRound("NSolve[ sin(x)=0 ]", "{x = 0" + Unicode.DEGREE_CHAR
				+ ", x = 180" + Unicode.DEGREE_CHAR + "}");
		t("NSolve[ {sin(x)=0, x=y} ]", "{{x = 0*" + Unicode.DEGREE_CHAR
				+ ", y = 0*" + Unicode.DEGREE_CHAR + "}}");

		tRound("NSolve( -0.083333333333333x^2 + 1.333333333333333x - 1.25=3.5)",
				"{x = 5.35425, x = 10.64575}");
	}

	@Test
	public void cmdSolveODECas() {
		t("SolveODE(-x/y)", "sqrt((-2 * 1) - x^(2))");
	}

	@Test
	public void cmdSolveODETidyCas() {
		t("SolveODE(2 x sqrt(y),(0,1))", "(1 / 4 * x^(4)) + x^(2) + 1");
	}

	@Test
	public void cmdSolveODEUpdate() {
		t("t=SolveODE(2x)", "x^(2)");
		t("v=t(2)", "4");
		t("SetValue(c_1,1)");
		t("v", "5");
	}

	@Test
	public void cmdDerivative() {
		t("Derivative[ Curve[sin(t),cos(t),t,0,1] ]",
				"(cos(t), (sin(t) * (-1)))");
		t("Derivative[ Curve[sin(t),cos(t),t,0,1],2 ]",
				"((sin(t) * (-1)), (-cos(t)))");
		t("Derivative[ sin(x) ]", "cos(x)");
		t("Derivative[ cos(x), 3 ]", "sin(x)");
		t("Derivative[ cos(x), x ]", "(-sin(x))");
		t("Derivative[ cos(x), x, 3 ]", "sin(x)");
		t("Derivative[ x^4/3 ]", "(4 / 3 * x^(3))");
		t("Derivative[exp(x)]", "\u212F^(x)");
		t("Derivative[(x+1)exp(-x)]", "((-x) * \u212F^((-x)))");
		t("fderiv:y=exp(x)", "exp(x)");
		t("fderiv'(x)", "\u212F^(x)");
		t("fderiv2:y=(x+1)exp(-x)", "((x + 1) * exp((-x)))");
		t("fderiv2'(x)", "((-x) * \u212F^((-x)))");
	}

	@Test
	public void cmdDerivativeDegenerate() {
		t("Derivative(x^3-3x, 0)", "x^(3) - (3 * x)");
		t("Derivative(x^3-3x, -1)", "?");
		t("Derivative(sin(x), 0)", "sin(x)");
		t("Derivative(sin(x), -1)", "?");
	}

	@Test
	public void randomDerivatives() {
		add("f(x)=1/(x+RandomBetween(1,100))");
		add("g=Derivative(2*f)");
		add("h=Derivative(2*f)");
		add("f1(x)=RandomElement({x^2})");
		add("g1=Derivative(f1)");

		String xml = "<expression label=\"f2\" exp=\"f2(x) = x\" />"
				+ "<element type=\"function\" label=\"f2\">" + "<casMap>"
				+ "<entry key=\"Derivative[((Random[-5, 5] x^Random[3, 4]) + Random[1, 4]) "
				+ "/ ((Random[1, 3] x) + Random[1, 5]),x,1]\" "
				+ "val=\"((8 * x^(3)) + (6 * x^(2)) - 4) / ((4 * x^(2)) + (4 * x) + 1)\"/>"
				+ "</casMap></element>";
		app.getGgbApi().evalXML(xml);
		Assert.assertFalse(app.getXML().contains("<entry"));
		add("UpdateConstruction()");
		t("g(7)-h(7)", "0");
	}

	@Test
	public void cmdAsymptote() {
		t("Asymptote[ x*y=1 ]", "x = 0", "y = 0");
		t("Asymptote[ 1/x ]", "{y = 0, x = 0}");
		t("Asymptote[ 1/x^3 ]", "{y = 0, x = 0}");
		t("Asymptote[ 1/x^4 ]", "{y = 0, x = 0}");
		t("Asymptote[ x^2*y^2=1 ]", "{x = 0, y = 0}");
		t("Asymptote[ 2^x/(3^x-2^x) ]", "{y = 0, y = -1, x = 0}");
		t("Asymptote[ (x-1)/(x-1) ]", "{y = 1}");
		t("Asymptote[ (x-1)^3/(x-1) ]", "{}");
		t("Asymptote[ x+sin(x) ]", "{}");
		t("Asymptote[ (9 - 3^x) / (4 + 6^x) ]", "{y = 0, y = 2.25}");
		t("Asymptote[ 2x^2/(x^1-16)+1/(1+x^2)+1/(2+x^2) ]",
				"{y = 2x + 32, x = 16}");
		t("Asymptote[ 3 (x - 1) (x + 1) (x - 4) (x + 4) / (4 (x + 4) (2 + x) (4 - x) (x + 1)) ]",
				"{y = -0.75, x = -2}");
		t("Asymptote[ (2 - x) / ((x - 2) (x - 4)) ]", "{y = 0, x = 4}");

		t("Asymptote[ 5+exp(-x^2) ]", "{y = 5}");
		t("Asymptote[ (x^3-9+4)/(2x^3+6x+7) ]", "{y = 0.5}");
		tRound("Asymptote[ 3 atan(2x) ]", "{y = 4.71239, y = -4.71239}");
		tRound("Asymptote[ (9-4x^2)/(1+5x+5x^2)]",
				"{y = -0.8, x = -0.72361, x = -0.27639}");
		t("Asymptote[ exp(-3x)+4exp(-x) ]", "{y = 0}");
		t("Asymptote[ (7+x)/(x^2-9) ]", "{y = 0, x = -3, x = 3}");
		t("Asymptote[ sin(1/x)^2 ]", "{y = 0}");
		t("Asymptote[ atan(1/(8x)) ]", "{y = 0}");
		tRound("Asymptote[ -atan(8x) ]", "{y = -1.5708, y = 1.5708}");
		t("Asymptote[ 4exp(2/x) ]", "{y = 4}");
		t("Asymptote[ 1/ln(2x+4)]", "{y = 0, x = -1.5}");
		tRound("Asymptote[ sqrt(2x^2+1)/(3x-5)]",
				"{y = 0.4714, y = -0.4714, x = 1.66667}");
		t("Asymptote[ sqrt(x^2+6x) - x ]", "{y = 3, y = -2x - 3}");

		tRound("Asymptote[ x(x-3)(x-8)(x-3)(x+4)/(7(x+1)(1+x)(3-x)(x-8)) ]",
				"{y = -0.14286x + 0.14286, x = -1}");
		tRound("Asymptote[ x+atan(x) ]", "{y = x + 1.5708, y = x - 1.5708}");
		tRound("Asymptote[ (3x - 2) / sqrt(2x^2 + 1) ]",
				"{y = 2.12132, y = -2.12132}");
		// for this one we don't get the right vertical asymptote, at least
		// ignore the fake one
		t("IndexOf(x=7,Asymptote[ (-1+(x-7)*2^x/(3^x-2^x)+1)/(x-7) ])", "NaN");
		t("Asymptote[ ln(x^2) ]", "{x = 0}");
		t("Asymptote[ ln(abs(x^2-4)) ]", "{x = -2, x = 2}");
		t("Asymptote[ log(3,x-2) ]", "{x = 2}");
		t("Asymptote[ log(3,x-2)/(x-4) ]", "{y = 0, x = 2, x = 4}");
		t("Asymptote[ log(3,x-2)/(x-2) ]", "{y = 0, x = 2}");
		// OK
		tRound("Asymptote[ sqrt((2x - 3) / (2x^2 - 3)) ]",
				"{y = 0, x = -1.22474, x = 1.22474}");

		// these ones are tricky (problems with domain)
		// https://help.geogebra.org/topic/asymptotes-incorrectly-computed
		// tRound("Asymptote[ sqrt(2x - 3) / sqrt(2x^2 - 3) ]",
		// "{y = 0}");
		// tRound("Asymptote[ sqrt(3x^2 - 2) / sqrt(2x + 1) ]", "{}");
		// tRound("Asymptote[ sqrt((3x^2 - 2) / (2x + 1)) ]", "{x = -0.5}");

	}

	/** Test for MOB-1667 */
	@Test
	public void cmdSolveSystem() {
		t("a:abs(x)/9+abs(y)/4=1", "abs(x) / 9 + abs(y) / 4 = 1");
		t("f:y=2x", "y = 2x");
		t("Solve[ {a,f} ]",
				"{{x = 18 / 11, y = 36 / 11}, {x = -18 / 11, y = -36 / 11}}");
	}

	@Test
	public void cmdExpand() {
		t("Expand[ (x+1)(x-1) ]", "x^(2) - 1");
		t("f(x)=(x+i)*(x-i)",
				"((x + " + Unicode.IMAGINARY + ") * (x - " + Unicode.IMAGINARY + "))");
		t("Expand[ f ]", "x^(2) + 1");
		t("Expand[ (x+i)(x-i) ]", "x^(2) + 1");
	}

	@Test
	public void expandShouldNotChangeWithRounding() {
		t("Expand[ 0.5 (x+1)^2 ]", "(1 / 2 * x^(2)) + x + 1 / 2");
		app.getKernel().setPrintDecimals(10);
		t("Expand[ 0.5 (x+1)^2 ]", "(1 / 2 * x^(2)) + x + 1 / 2");
	}

	@Test
	public void cmdSolutions() {
		tRound("Solutions[ x^2=3 ]", "{-1.73205, 1.73205}");
		t("Solutions[ 5x=4 ]", "{4 / 5}");
		tRound("Solutions[ sin(x)=1/2 ]", "{30" + Unicode.DEGREE_CHAR + ", 150"
				+ Unicode.DEGREE_CHAR + "}");
	}

	@Test
	public void cmdNSolutions() {
		tRound("NSolutions[ x^2=3 ]", "{-1.73205, 1.73205}");
		t("NSolutions[ 5x=4 ]", "{0.8}");
		tRound("NSolutions[ sin(x)=1/2 ]", "{30" + Unicode.DEGREE_CHAR + ", 150"
				+ Unicode.DEGREE_CHAR + "}");
		tRound("NSolutions(4 sin(x)^3 cos(x) - 6 cos(x)^2 sin(x))",
				"{-90" + Unicode.DEGREE_CHAR + ", -60" + Unicode.DEGREE_CHAR
						+ ", 0" + Unicode.DEGREE_CHAR + ", 60"
						+ Unicode.DEGREE_CHAR + ", 90" + Unicode.DEGREE_CHAR
						+ ", 180" + Unicode.DEGREE_CHAR + "}");
	}

	@Test
	public void cmdImplicitDerivative() {
		t("ImplicitDerivative[x^2+y^2]", "((-x)) / y");
	}

	@Test
	public void testIntersectCurves() {
		t("Intersect[Curve[t, t^3 - t, t, -2, 2], Curve[t, t, t, -4, 4]]",
				new String[]{"(0, 0)",
						"(1.4142135623730951, 1.4142135623730951)",
						"(-1.4142135623730951, -1.4142135623730951)"});
		t("Intersect[Curve[t, t^3 - t, t, -2, 2], Curve[t, t, t, -4, 4], 1, 1]",
				"(1.4142135623730951, 1.4142135623730956)");
		tRound("Intersect[sin(x), cos(x), 0, 2pi]",
				new String[]{"(0.7854, 0.70711)", "(3.92699, -0.70711)"});
	}

	@Test
	public void cmdSolve() {
		runSolveTests();
		app.getKernel().clearConstruction(true);
		app.setActiveView(App.VIEW_EUCLIDIAN3D);
		app.getEuclidianView3D();
		t("eq: x^2=6", unicode("x^2 + 0z^2 = 6"));
		t("Solve[ eq ]", "{x = (-sqrt(6)), x = sqrt(6)}");
		t("Solve({84.36=x*y^3,126.56=x*y^4})",
				"{{x = 19783645390161 / 791861873600, y = 3164 / 2109}}");
		runSolveTests();
	}

	@Test
	public void cmdCASLoaded() {
		t("CASLoaded[]", "true");
	}

	@Test
	public void imgCorner() {
		// TODO not really CAS
		GeoImage img = new GeoImage(app.getKernel().getConstruction());
		String fn = ((ImageManagerD) app.getImageManager())
				.createImage(GuiResourcesD.BAR_GRAPH, app);
		img.setImageFileName(fn);
		app.getImageManager().setCornersFromSelection(img, app);
		img.setLabel("picT");
		img.getStartPoint(0).setCoords(0, 0, 1);
		img.getStartPoint(1).setCoords(10, 0, 1);
		img.getStartPoint(1).updateCascade();
		tRound("Corner(picT,1)", "(0, 0)");
		tRound("Corner(picT,2)", "(10, 0)");
		tRound("Corner(picT,3)", "(10, 10)");
		tRound("Corner(picT,4)", "(0, 10)");
		EuclidianView view = app.getActiveEuclidianView();
		view.setCoordSystem(view.getXZero(), view.getYZero(), view.getXscale(),
				view.getYscale() * 2);
		tRound("Corner(picT,1)", "(0, 0)");
		tRound("Corner(picT,2)", "(10, 0)");
		tRound("Corner(picT,3)", "(10, 10)");
		tRound("Corner(picT,4)", "(0, 10)");
	}

	@Test
	public void testDerivativeDegrees() {
		deg("Derivative(sin(30)*x+sin(x))", "1 / 2 (2cos(x) + 1)");
	}

	@Test
	public void symbolicFractionsCAS() {
		frac("a=2/3-1/3", "1 / 3");
		frac("Simplify(x/3/a)", "x");
		frac("Simplify(x^a)", "cbrt(x)");
		frac("Simplify(a!)", "gamma(1 / 3) / 3");
	}

	@Test
	public void cmdIntegralSymbolic() {
		// Tested in giacTests.js
	}

	@Test
	public void cmdRemovableDiscontinuity() {
		t("RemovableDiscontinuity((3-x)/(2x^2-6x))", "(3, -0.16666666666666666)");
		t("RemovableDiscontinuity(x/x)", "(0, 1)");
		t("RemovableDiscontinuity((x^2 - 4)/(x - 2))", "(2, 4)");
		t("RemovableDiscontinuity(x + x/x)", "(0, 1)");
		t("RemovableDiscontinuity(2^(x + x/x))", "(0, 2)");
	}

	@Test
	public void cmdPlotSolve() {
		t("PlotSolve(x^2-2)", "{(-1.4142135623730951, 0), (1.4142135623730951, 0)}");
		GeoElement element = get("l1");
		assertThat(element.isEuclidianVisible(), is(true));
	}

	@Test
	public void functionComparisonShouldConsiderJustFiniteValues() {
		t("f(x)=x^2/x", "x^(2) / x");
		t("g(x)=x", "x");
		t("f==g", "true");
	}

	@Test
	public void functionComparisonShouldWorkForTrig() {
		t("f(x)=sin(x)^2", "(sin(x))^(2)");
		t("g(x)=1-cos(x)^2", "1 - (cos(x))^(2)");
		t("f==g", "true");
	}

	@Test
	public void simpleFunctionComparisonShouldNotNeedCAS() {
		app = createApp();
		ap = app.getKernel().getAlgebraProcessor();
		app.setCASFactory(new CASFactory() {
			@Override
			public CASGenericInterface newGiac(CASparser parser, Kernel kernel) {
				Assert.fail("No need for CAS");
				return null;
			}
		});
		// one or both functions undefined
		t("f(x)=?", "?");
		t("g(x)=?", "?");
		t("f==g", "false");

		// same string
		t("f(x)=sin(x)", "sin(x)");
		t("g(x)=sin(x)", "sin(x)");
		t("f==g", "true");

		// polynomial
		t("f(x)=2x + 1", "(2 * x) + 1");
		t("g(x)=1 + 2x", "1 + (2 * x)");
		t("f==g", "true");
	}

	private void frac(String def, String expect) {
		EvalInfo evalInfo = new EvalInfo(true, true).withSymbolic(true);
		checkWithEvalInfo(def, expect, evalInfo);
	}

	@Test
	public void cmdLimitAbove() {
		t("LimitAbove[ 1/x, 0 ]", "Infinity");
	}

	@Test
	public void cmdLimitBelow() {
		t("LimitBelow[ 1/x, 0 ]", "-Infinity");
	}

	@Test
	public void cmdLimit() {
		t("Limit[ (x^2 + x) / x^2, " + INFINITY + " ]", "1");
	}

	@Test
	public void cmdNextPrime() {
		t("NextPrime[10000]", "10007");
	}

	@Test
	public void cmdPartialFractions() {
		t("PartialFractions[ x^2 / (x^2 - 2x + 1) ]", "1 + 1 / (x - 1)^(2) + 2 / (x - 1)");
	}

	@Test
	public void cmdPreviousPrime() {
		t("PreviousPrime[ 22 ]", "19");
	}

	@Test
	public void cmdTrigCombine() {
		t("TrigCombine[sin(x) cos(3x)]", "(1 / 2 * sin((4 * x))) - (1 / 2 * sin((2 * x)))");
		t("TrigCombine[sin(x) + cos(x), sin(x)]", "(sqrt(2) * sin(x + (1 / 4 * pi)))");
	}

	@Test
	public void cmdTrigExpand() {
		t("TrigExpand[sin(x+y)]", "(sin(x) * cos(y)) + (cos(x) * sin(y))");
		t("TrigExpand[tan(x + y), tan(x)]", "(tan(x) + tan(y)) / (1 - (tan(x) * tan(y)))");
	}

	@Test
	public void cmdTrigSimplify() {
		t("TrigSimplify[1 - sin(x)^2]", "(cos(x))^(2)");
	}

	@Test
	public void speedForInequalitySolve() {
		double time = System.currentTimeMillis();
		t("Solve(0.05>=(1-x)^50)",
				"{(-nroot(1 / 20,50)) + 1 ≤ x ≤ nroot(1 / 20,50) + 1}");
		t("NSolve((x-1)^99<1)", "?");
		assertThat(System.currentTimeMillis() - time, lessThan(1E4));
	}
}
