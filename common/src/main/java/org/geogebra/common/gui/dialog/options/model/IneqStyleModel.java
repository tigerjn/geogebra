package org.geogebra.common.gui.dialog.options.model;

import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.kernel.geos.GeoFunction;
import org.geogebra.common.kernel.geos.InequalityProperties;
import org.geogebra.common.main.App;

public class IneqStyleModel extends BooleanOptionModel {

	public IneqStyleModel(App app) {
		super(app);
	}

	private InequalityProperties getInequalityPropertiesAt(int index) {
		return (InequalityProperties) getObjectAt(index);
	}

	@Override
	public String getTitle() {
		return "ShowOnXAxis";
	}

	@Override
	public boolean isValidAt(int index) {
		GeoElement geo = getGeoAt(index).getGeoElementForPropertiesDialog();
		if (!(geo instanceof GeoFunction)) {
			return false;
		}

		GeoFunction gfun = (GeoFunction) geo;
		return gfun.isBooleanFunction() && !gfun
				.getVarString(StringTemplate.defaultTemplate).equals("y");
	}

	@Override
	public boolean getValueAt(int index) {
		return getInequalityPropertiesAt(index).showOnAxis();
	}

	@Override
	public void apply(int index, boolean value) {
		InequalityProperties geo = (InequalityProperties) getObjectAt(index);
		geo.setShowOnAxis(value);
		geo.updateRepaint();

	}

}
