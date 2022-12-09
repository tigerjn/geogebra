package org.geogebra.web.full.gui.menubar;

import java.util.function.Consumer;

import org.geogebra.common.main.Localization;
import org.geogebra.web.full.gui.components.radiobutton.ComponentRadioButton;
import org.geogebra.web.full.gui.components.radiobutton.RadioButtonData;
import org.geogebra.web.html5.gui.util.AriaMenuBar;
import org.geogebra.web.html5.gui.util.AriaMenuItem;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;

/**
 * An implementation of a radio button menu bar.
 */
public class RadioButtonMenuBarW extends AriaMenuBar {
	private String[] texts;
	/** item commands */
	Double[] commands;
	/** listener */
	Consumer<Double> listener;
	private final Localization loc;
	/** action side effect */
	Scheduler.ScheduledCommand itemSideEffect = null;

	/**
	 * Creates a RadioButtonMenuBarW instance
	 * @param loc - localization
	 */
	public RadioButtonMenuBarW(Localization loc) {
		super();
		this.loc = loc;
	}

	private void addItem(String text, Command com, boolean selected, int pos) {
		RadioButtonData<String> data = new RadioButtonData<>(text, text);
		ComponentRadioButton<String> radioButton = new ComponentRadioButton<>(loc, data,
				pos, texts.length);
		radioButton.setSelected(selected);
		radioButton.addStyleName("RadioButtonMenuItem");
		super.addItem(radioButton.toString(), true, com);
	}

	/**
	 * @param al listener
	 * @param items items
	 * @param actionCommands commands
	 * @param selectedPos initial selected position
	 */
	public void addRadioButtonMenuItems(Consumer<Double> al,
			String[] items, final Double[] actionCommands, int selectedPos) {
		texts = items;
		commands = actionCommands;
		listener = al;
		setSelected(selectedPos);
	}

	private void setSelected(int selectedPos) {
		clearItems();
		for (int i = 0; i < texts.length; i++) {
			if ("---".equals(texts[i])) {
				addSeparator();
			} else {
				final int j = i;
				addItem(texts[i], () -> {
					setSelected(j);
					listener.accept(commands[j]);
					if (itemSideEffect != null) {
						itemSideEffect.execute();
					}
				}, i == selectedPos, i);
			}
		}
	}

	/**
	 * @param sc - side effect
	 */
	public void registerItemSideEffect(Scheduler.ScheduledCommand sc) {
		itemSideEffect = sc;
	}

	/**
	 * Wondering why they make protected methods if we can get them this way
	 * 
	 * @return MenuItem the selected item
	 */
	public AriaMenuItem getSelectedItemPublic() {
		return getSelectedItem();
	}
}
