package org.geogebra.web.full.gui.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.geogebra.common.euclidian.event.PointerEventType;
import org.geogebra.common.gui.SetLabels;
import org.geogebra.common.properties.EnumerableProperty;
import org.geogebra.common.properties.Property;
import org.geogebra.web.full.css.MaterialDesignResources;
import org.geogebra.web.full.gui.menubar.MainMenu;
import org.geogebra.web.full.gui.view.algebra.InputPanelW;
import org.geogebra.web.html5.gui.inputfield.AutoCompleteTextFieldW;
import org.geogebra.web.html5.gui.util.AriaMenuItem;
import org.geogebra.web.html5.gui.util.ClickStartHandler;
import org.geogebra.web.html5.gui.util.FormLabel;
import org.geogebra.web.html5.main.AppW;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ComponentCombobox extends FlowPanel implements SetLabels {
	private final AppW appW;
	private FlowPanel contentPanel;
	private AutoCompleteTextFieldW inputTextField;
	private FormLabel labelText;
	private String labelTextKey;
	private ComponentDropDownPopup dropDown;
	private List<AriaMenuItem> dropDownElementsList;

	public ComponentCombobox(AppW app, String label, Property property) {
		appW = app;
		labelTextKey = label;

		addStyleName("combobox");
		buildGUI();
		addFocusBlurHandlers();
		addHoverHandlers();
		//TODO
		createDropDownMenu(appW);
		setElements(Arrays.asList(((EnumerableProperty) property).getValues()));
		setSelectedOption(0);
	}

	private void buildGUI() {
		contentPanel = new FlowPanel();
		contentPanel.setStyleName("inputTextField");

		inputTextField = new AutoCompleteTextFieldW(-1, appW, false, null, false);
		inputTextField.addStyleName("textField");

		if (labelTextKey != null) {
			labelText = new FormLabel().setFor(inputTextField);
			labelText.setStyleName("inputLabel");
			contentPanel.add(labelText);
		}

		contentPanel.add(inputTextField);
		add(contentPanel);

		SimplePanel arrowIcon = new SimplePanel();
		arrowIcon.addStyleName("arrow");
		arrowIcon.getElement().setInnerHTML(MaterialDesignResources.INSTANCE
				.arrow_drop_down().getSVG());
		add(arrowIcon);

		setLabels();
	}

	private void addFocusBlurHandlers() {
		inputTextField.getTextBox()
				.addFocusHandler(event -> contentPanel.addStyleName("focusState"));
		inputTextField.getTextBox()
				.addBlurHandler(event -> contentPanel.removeStyleName("focusState"));
	}

	/**
	 * Add mouse over/ out handlers
	 */
	private void addHoverHandlers() {
		inputTextField.getTextBox()
				.addMouseOverHandler(event -> contentPanel.addStyleName("hoverState"));
		inputTextField.getTextBox()
				.addMouseOutHandler(event -> contentPanel.removeStyleName("hoverState"));
	}

	private void createDropDownMenu(final AppW app) {
		dropDown = new ComponentDropDownPopup(app, 24, inputTextField);
		dropDown.addAutoHidePartner(getElement());

		ClickStartHandler.init(this, new ClickStartHandler(true, true) {

			@Override
			public void onClickStart(int x, int y, PointerEventType type) {
				//if (!isDisabled) {
					toggleExpanded();
				//}
			}
		});
	}

	/**
	 * Expand/collapse the dropdown.
	 */
	protected void toggleExpanded() {
		if (dropDown.isOpened()) {
			dropDown.close();
		} else {
			dropDown.show();
		}
	}

	private void setSelectedOption(int idx) {
		dropDown.setSelectedIndex(idx);
		inputTextField.setText(dropDownElementsList.get(idx).getElement().getInnerText());
	}

	/**
	 * Set the elements of the dropdown list
	 *
	 * @param dropDownList
	 *            List of strings which will be shown in the dropdown list
	 */
	public void setElements(final List<String> dropDownList) {
		dropDownElementsList = new ArrayList<>();

		for (int i = 0; i < dropDownList.size(); ++i) {
			final int currentIndex = i;
			AriaMenuItem item = new AriaMenuItem(
					MainMenu.getMenuBarHtmlEmptyIcon(dropDownList.get(i)), true,
					() -> {
						setSelectedOption(currentIndex);
					});

			item.setStyleName("dropDownElement");
			dropDownElementsList.add(item);
		}
		setupDropDownMenu(dropDownElementsList);
	}

	private void setupDropDownMenu(List<AriaMenuItem> menuItems) {
		dropDown.clear();
		for (AriaMenuItem menuItem : menuItems) {
			dropDown.addItem(menuItem);
		}
	}


	@Override
	public void setLabels() {
		if (labelText != null) {
			labelText.setText(appW.getLocalization().getMenu(labelTextKey));
		}
	}
}
