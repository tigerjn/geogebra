package org.geogebra.common.gui.dialog.options.model;

import org.geogebra.common.kernel.geos.GProperty;
import org.geogebra.common.kernel.geos.GeoElement;
import org.geogebra.common.main.App;

public class ShowObjectModel extends BooleanOptionModel {

	public ShowObjectModel(App app) {
		super(app);
	}

	@Override
	public boolean isEditable() {
		// check if properties have same values
		GeoElement temp;

		for (int i = 0; i < getGeosLength(); i++) {
			temp = getGeoAt(i);
			if (temp.getShowObjectCondition() != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getTitle() {
		return "ShowObject";
	}

	@Override
	public boolean isValidAt(int index) {
		// TODO Auto-generated method stub
		boolean isValid = true;
		GeoElement geo = getGeoAt(index);
		if (!geo.isDrawable()
				// can't allow a free fixed number to become visible (as a
				// slider)
				|| (geo.isGeoNumeric() && geo.isLocked())) {
			isValid = false;

		}

		return isValid;
	}

	@Override
	public boolean getValueAt(int index) {
		return getGeoAt(0).isSetEuclidianVisible();
	}

	@Override
	public void apply(int index, boolean value) {
		GeoElement geo = getGeoAt(index);
		geo.setEuclidianVisible(value);
		geo.updateVisualStyleRepaint(GProperty.VISIBLE);
		storeUndoInfo();
	}

}