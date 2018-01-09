package logparser;

import shapes.Shape;

public class ShapeParser {
	private static ShapeParser instance;

	private ShapeParser() {
	}

	/**
	 * Will parse given string, build shape based on it and return shape
	 * 
	 * @param s
	 * @return Shape
	 */
	public Shape parse(String s) {
		// TODO Implement
		return null;
	}

	/**
	 * Will return String with shape type
	 * 
	 * @param s
	 * @return
	 */
	public String parseType(String s) {
		String prefix = s.split("\\(")[0]; // Will get everything before Shape type
		String[] prefixArray = prefix.split("_"); // Split prefix by _
		String type = prefixArray[prefixArray.length - 1].toLowerCase(); // Get Shape type
		return type;
	}

	/**
	 * Return Thread safe singleton object also using Lazy Loading
	 * 
	 * @return
	 */
	public static ShapeParser getInstance() {
		if (instance == null) {
			synchronized (ShapeParser.class) {
				if (instance == null) {
					instance = new ShapeParser();
				}
			}
		}
		return instance;
	}
}
