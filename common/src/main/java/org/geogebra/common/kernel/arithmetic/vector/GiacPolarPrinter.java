package org.geogebra.common.kernel.arithmetic.vector;

import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.printing.printable.vector.PrintableVector;
import org.geogebra.common.kernel.printing.printer.Printer;
import org.geogebra.common.kernel.printing.printer.expression.ExpressionPrinter;

class GiacPolarPrinter implements Printer {

    @Override
    public String print(StringTemplate tpl, ExpressionPrinter expressionPrinter,
			PrintableVector vector) {
        return "point(("
                + expressionPrinter.print(vector.getX(), tpl)
                + ")*cos("
                + expressionPrinter.print(vector.getY(), tpl)
                + "),("
                + expressionPrinter.print(vector.getX(), tpl)
                + ")*sin("
                + expressionPrinter.print(vector.getY(), tpl)
                + "))";
    }
}
