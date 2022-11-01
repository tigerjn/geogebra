package org.geogebra.web.full.gui.properties;

import org.geogebra.common.gui.SetLabels;
import org.geogebra.common.gui.dialog.options.model.OptionsModel;
import org.geogebra.common.gui.dialog.options.model.PropertyListener;

import com.google.gwt.user.client.ui.Widget;

public interface IOptionPanel extends SetLabels, PropertyListener {

	Widget getWidget(); 

	OptionsModel getModel();
}
