package org.geogebra.desktop.gui.inputfield;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;

import javax.swing.JFormattedTextField;

import org.geogebra.common.gui.VirtualKeyboardListener;
import org.geogebra.desktop.gui.GuiManagerD;
import org.geogebra.desktop.gui.virtualkeyboard.VirtualKeyboardD;

public class DateInputTextField extends JFormattedTextField
		implements FocusListener, VirtualKeyboardListener {

	private static final long serialVersionUID = 1L;

	GuiManagerD guiManager;

	/**
	 * @param guiManager gui manager
	 * @param format date format
	 */
	public DateInputTextField(GuiManagerD guiManager, DateFormat format) {
		super(format);
		this.guiManager = guiManager;
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		guiManager.setCurrentTextfield(this, false);
	}

	@Override
	public void focusLost(FocusEvent e) {
		guiManager.setCurrentTextfield(null,
				!(e.getOppositeComponent() instanceof VirtualKeyboardD));

	}

	@Override
	public void insertString(String text) {

		int start = getSelectionStart();
		int end = getSelectionEnd();
		// clear selection if there is one
		if (start != end) {
			int pos = getCaretPosition();
			String oldText = getText();
			StringBuilder sb = new StringBuilder();
			sb.append(oldText.substring(0, start));
			sb.append(oldText.substring(end));
			setText(sb.toString());
			if (pos < sb.length()) {
				setCaretPosition(pos);
			}
		}

		int pos = getCaretPosition();
		String oldText = getText();
		StringBuilder sb = new StringBuilder();
		sb.append(oldText.substring(0, pos));
		sb.append(text);
		sb.append(oldText.substring(pos));
		setText(sb.toString());

		setCaretPosition(pos + text.length());

	}

}
