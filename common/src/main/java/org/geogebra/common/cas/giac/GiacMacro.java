package org.geogebra.common.cas.giac;

public class GiacMacro {
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

	static String normal(String arg) {
		return "normal(" + arg + ")";
	}

	static String isListType(String arg) {
		return "type(" + arg + ") == DOM_LIST";
	}

	static String nth(String arg, int index) {
		return arg + "[" + index + "]";
	}

	static String first(String arg) {
		return nth(arg, 0);
	}

	static String last(String arg) {
		return nth(arg, -1);
	}

	public static String desolve(String l, String x, String y, String w) {
		return "desolve(" + l + "," + x + "," + y + "," +w+" )";
	}

	public static String desolve(String l, String x, String y) {
		return "desolve(" + l + "," + x + "," + y + ")";
	}

	public static String define(String variable, String value) {
		return variable + ":=" + value;
	}

	public static String sizeEquals(String variable, int size) {
		return "size(" + variable + ")=="+size;
	}
}
