package org.geogebra.common.gui.dialog.options.model;

import org.geogebra.common.kernel.geos.AngleProperties;
import org.geogebra.common.kernel.geos.GProperty;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.main.App;

public class RightAngleModel extends BooleanOptionModel {

	public RightAngleModel(App app) {
		super(app);
	}

	@Override
	public String getTitle() {
		return "EmphasizeRightAngle";
	}

	@Override
	public boolean isValidAt(int index) {
		GeoElement geo = getGeoAt(index);

		return geo instanceof AngleProperties && !geo.isGeoList()
				|| isAngleList(geo);
	}

	@Override
	public boolean getValueAt(int index) {
		AngleProperties geo0 = (AngleProperties) getGeoAt(0);
		return geo0.isEmphasizeRightAngle();
	}

	@Override
	public void apply(int index, boolean value) {
		AngleProperties geo = (AngleProperties) getObjectAt(index);
		geo.setEmphasizeRightAngle(value);
		geo.updateVisualStyle(GProperty.ANGLE_STYLE);
	}

}
