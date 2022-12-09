package org.geogebra.common.kernel.cas;

import java.util.ArrayList;

import org.geogebra.common.kernel.Construction;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.algos.AlgoElement;
import org.geogebra.common.kernel.algos.Algos;
import org.geogebra.common.kernel.algos.GetCommand;
import org.geogebra.common.kernel.arithmetic.ArbitraryConstant;
import org.geogebra.common.kernel.arithmetic.Equation;
import org.geogebra.common.kernel.arithmetic.ExpressionNode;
import org.geogebra.common.kernel.arithmetic.Function;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoSymbolic;

/**
 * Algo for updating GeoSymbolic when dependencies change
 * 
 * @author Zbynek
 *
 */
public class AlgoDependentSymbolic extends AlgoElement implements UsesCAS {

	private GeoSymbolic symbolic;
	private ArrayList<GeoElement> vars;

	/**
	 * @param c
	 *            construction
	 * @param def
	 *            symbolic variable definition
	 * @param vars
	 *            parent variables
	 */
	public AlgoDependentSymbolic(
			Construction c,
			ExpressionNode def,
			ArrayList<GeoElement> vars,
			ArbitraryConstant constant,
			boolean addToConstructionList) {
		super(c, addToConstructionList);
		this.symbolic = new GeoSymbolic(cons);
		symbolic.setArbitraryConstant(constant);
		symbolic.setDefinition(def);
		this.vars = vars;
		setInputOutput();
		compute();
	}

	@Override
	protected void setInputOutput() {
		input = vars.toArray(new GeoElement[1]);
		setOnlyOutput(symbolic);
		setDependencies();
	}

	@Override
	public void compute() {
		symbolic.computeOutput();
	}

	@Override
	public GetCommand getClassName() {
		return Algos.Expression;
	}

	@Override
	public String toString(StringTemplate tpl) {
		return symbolic.getDefinition().toString(tpl);
	}

	@Override
	protected String toExpString(StringTemplate tpl) {
		ExpressionNode definition = symbolic.getDefinition();
		String rhs = definition.toString(tpl);
		if (isFunction(definition)) {
			String lhs = symbolic.getLabel(tpl) + "(" + symbolic.getVarString(tpl) + ") = ";
			return lhs + rhs;
		} else if (isEquation(definition) && rhs.contains("=")) {
			return symbolic.getLabel(tpl) + ": " + rhs;
		}
		return rhs;
	}

	private boolean isFunction(ExpressionNode definition) {
		return definition.isLeaf() && (definition.getLeft() instanceof Function);
	}

	private boolean isEquation(ExpressionNode definition) {
		return definition.isLeaf() && (definition.getLeft() instanceof Equation);
	}
}
