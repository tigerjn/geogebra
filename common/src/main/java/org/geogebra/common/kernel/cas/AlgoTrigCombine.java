package org.geogebra.common.kernel.cas;

import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.algos.AlgoCasBase;
import org.geogebra.common.kernel.arithmetic.ArbitraryConstant;
import org.geogebra.common.kernel.commands.Commands;
import org.geogebra.common.kernel.commands.EvalInfo;
import org.geogebra.common.kernel.geos.CasEvaluableFunction;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoFunction;

/**
 * Algorithm for TrigCombine
 */
public class AlgoTrigCombine extends AlgoCasBase {
	private GeoFunction target;
	private ArbitraryConstant arbconst = new ArbitraryConstant(this);

	/**
	 * @param cons
	 *            construction
	 * @param label
	 *            label for output
	 * @param f
	 *            function
	 * @param target
	 *            target function (ie sin or cos)
	 * @param info
	 *            evaluation flags
	 */
	public AlgoTrigCombine(Construction cons, String label,
			CasEvaluableFunction f, GeoFunction target, EvalInfo info) {
		super(cons, f, Commands.TrigCombine, info);
		this.target = target;
		setInputOutput();
		compute();
		g.setLabel(label);
	}

	@Override
	public void setInputOutput() {
		if (target != null) {
			input = new GeoElement[] { f.toGeoElement(), target };

		} else {
			input = new GeoElement[] { f.toGeoElement() };
		}
		setOnlyOutput(g);
		setDependencies();
	}

	@Override
	protected void applyCasCommand(StringTemplate tpl) {
		StringBuilder sb = new StringBuilder();
		sb.append("TrigCombine[%");
		if (target != null) {
			sb.append(',');
			sb.append(target.toValueString(tpl));
		}
		sb.append(']');
		g.setUsingCasCommand(sb.toString(), f, true, arbconst);
	}
}
