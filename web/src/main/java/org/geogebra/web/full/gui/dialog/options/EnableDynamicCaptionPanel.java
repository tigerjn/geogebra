package org.geogebra.web.full.gui.dialog.options;

import org.geogebra.common.gui.dialog.options.model.EnableDynamicCaptionModel;
import org.geogebra.common.main.App;
import org.geogebra.web.full.gui.properties.OptionPanel;
import org.geogebra.web.html5.gui.inputfield.AutoCompleteTextFieldW;

class EnableDynamicCaptionPanel extends CheckboxPanel {
	private final AutoCompleteTextFieldW textField;

	public EnableDynamicCaptionPanel(App app,
			AutoCompleteTextFieldW textField) {
		super(app.getLocalization(), new EnableDynamicCaptionModel(app));
		this.textField = textField;
	}

	@Override
	public OptionPanel updatePanel(Object[] value) {
		OptionPanel ret = super.updatePanel(value);
		onChecked();
		return ret;
	}

	@Override
	public void onChecked() {
		setCaptionTextFieldEnabled(!getCheckbox().isSelected());
	}

	private void setCaptionTextFieldEnabled(boolean enable) {
		textField.setEnabled(enable);
	}

}
