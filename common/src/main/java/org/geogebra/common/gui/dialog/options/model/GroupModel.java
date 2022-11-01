package org.geogebra.common.gui.dialog.options.model;

import java.util.ArrayList;
import java.util.List;

import org.geogebra.common.main.App;

public class GroupModel extends OptionsModel {
	private List<OptionsModel> models = new ArrayList<>();

	public GroupModel(App app) {
		super(app);
	}

	@Override
	protected boolean isValidAt(int index) {
		for (OptionsModel model : models) {
			if (model.isValidAt(index)) {
				return true;
			}
		}
		return false;
	}

	public void add(OptionsModel model) {
		models.add(model);
	}


}
