package geogebra.common.geogebra3D.kernel3D.commands;

import geogebra.common.kernel.Kernel;
import geogebra.common.kernel.arithmetic.Command;
import geogebra.common.kernel.commands.CmdOrthogonalVector;
import geogebra.common.kernel.geos.GeoElement;
import geogebra.common.kernel.kernelND.GeoCoordSys2D;
import geogebra.common.kernel.kernelND.GeoDirectionND;
import geogebra.common.kernel.kernelND.GeoLineND;
import geogebra.common.main.MyError;

/**
 * OrthogonalVector[ <GeoPlane3D> ] 
 */
public class CmdOrthogonalVector3D extends CmdOrthogonalVector {
	
	
	
	public CmdOrthogonalVector3D(Kernel kernel) {
		super(kernel);
	}
	
	

	public GeoElement[] process(Command c) throws MyError {
	    int n = c.getArgumentNumber();
	    boolean[] ok = new boolean[n];
	    GeoElement[] arg;

	    switch (n) {
	    case 1 :
	    	arg = resArgs(c);
			if (ok[0] = (arg[0] instanceof GeoCoordSys2D)) {
				GeoElement[] ret =
				{
						(GeoElement) kernelA.getManager3D().OrthogonalVector3D(
								c.getLabel(),
								(GeoCoordSys2D) arg[0])};
				return ret;
			} 
			break;
			
	    case 2:
	    	arg = resArgs(c);
	    	if (ok[0] = (arg[0] instanceof GeoLineND) && (ok[1] = (arg[1] instanceof GeoDirectionND))) {
				GeoElement[] ret =
				{
						(GeoElement) kernelA.getManager3D().OrthogonalVector3D(
								c.getLabel(),
								(GeoLineND) arg[0], (GeoDirectionND) arg[1])};
				return ret;
			}
	    	break;
	    	
	    }
	    

	    return super.process(c);
	}
	
}
