package org.geogebra.common.cas.giac;

public class CASMacro {
	static String when(String condition, String whenTrue, String whenFalse) {
		return "when(" + condition + "," + whenTrue + "," + whenFalse + ")";
	}


	static String L(String... elements) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String FS = "";
		for (String elem : elements) {
			sb.append(FS);
			sb.append(elem);
			FS = ",";
		}
		sb.append("]");
		return sb.toString();
	}

	static String isListType(String arg) {
		return "type(" + arg + ") == DOM_LIST";
	}

	static String first(String arg) {
		return arg + "[0]";
	}

	static String last(String arg) {
		return arg + "[-1]";
	}
}
