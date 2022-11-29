package org.geogebra.common.kernel.arithmetic.vector;

import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.geos.GeoSymbolic;
import org.geogebra.common.kernel.printing.printable.vector.PrintableVector;
import org.geogebra.common.kernel.printing.printer.Printer;
import org.geogebra.common.kernel.printing.printer.expression.ExpressionPrinter;

class VectorPrinter implements Printer {

    private Printer defaultPrinter;
    private Printer editPrinter;
    private Printer latexPrinter;

    VectorPrinter() {
        defaultPrinter = new DefaultVectorPrinter();
        editPrinter = new EditVectorPrinter();
        latexPrinter = new LatexVectorPrinter();
    }

    @Override
    public String print(StringTemplate tpl, ExpressionPrinter expressionPrinter,
			PrintableVector vector) {
        return getPrinterFor(tpl, vector).print(tpl, expressionPrinter, vector);
    }

    private Printer getPrinterFor(StringTemplate tpl, PrintableVector vector) {
        // if the vector is actually a pair of lists
        // then on the definition panel it should be printed simply as (x, y)
        if (GeoSymbolic.isWrappedList(vector.getX()) && GeoSymbolic.isWrappedList(vector.getY())) {
            return defaultPrinter;
        } else if (tpl.isForEditorParser()) {
            return editPrinter;
        } else if (tpl.isLatex()) {
            return latexPrinter;
        } else {
            return defaultPrinter;
        }
    }
}
