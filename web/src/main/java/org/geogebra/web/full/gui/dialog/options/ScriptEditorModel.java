package org.geogebra.web.full.gui.dialog.options;

import org.geogebra.common.gui.dialog.options.model.OptionsModel;
import org.geogebra.common.main.App;

public class ScriptEditorModel extends OptionsModel {

	/**
	 * @param app
	 *            application
	 */
	public ScriptEditorModel(App app) {
		super(app);
	}

	@Override
	protected boolean isValidAt(int index) {
		return true;
	}

}
