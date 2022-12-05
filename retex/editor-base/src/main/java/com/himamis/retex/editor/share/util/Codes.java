package com.himamis.retex.editor.share.util;

@SuppressWarnings("javadoc")
public enum Codes {

	N("KeyN"),

	U("KeyU"),

	I("KeyI"),

	E("KeyE"),

	UNKNOWN("unknown");
	private String code;

	Codes(String code) {
		this.code = code;
	}

	/**
	 * @param gwtKeyCode
	 *            native key code
	 * @return KeyCodes wrapper
	 */
	public static Codes translateGWTcode(String code) {
		for (Codes l : Codes.values()) {
			if (l.code == code) {
				return l;
			}
		}

		// Log.warn("GWT keycode not found:" + gwtKeyCode);
		return UNKNOWN;

	}
}
