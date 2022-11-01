package org.geogebra.common.gui.dialog.options.model;

import org.geogebra.common.main.App;

public abstract class BooleanOptionModel extends OptionsModel {

	public BooleanOptionModel(App app) {
		super(app);
	}

	public abstract boolean getValueAt(int index);

	public abstract void apply(int index, boolean value);

	public boolean isEditable() {
		return true;
	}

	/** Update properties */
	public boolean getValue() {
		boolean value0 = getValueAt(0);
		boolean isEqual = true;

		for (int i = 0; i < getGeosLength(); i++) {
			if (value0 != getValueAt(i)) {
				isEqual = false;
			}
		}
		return isEqual && value0;
	}

	public void applyChanges(boolean value) {
		for (int i = 0; i < getGeosLength(); i++) {
			apply(i, value);
		}
		storeUndoInfo();
	}

	public abstract String getTitle();
}
