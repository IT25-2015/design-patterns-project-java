package logparser;

import java.util.HashMap;

import logparser.util.LogParserUtils;
import shapes.Shape;
import shapes.point.Point;

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
		String shapeType = parseType(s);
		switch (shapeType) {
		case "point": {
			HashMap<String, String> properties = parsePointProperties(s); // Get all Point properties
			// Return new point that is created from properties above
			return new Point(Integer.parseInt(properties.get("x")), Integer.parseInt(properties.get("y")),
					LogParserUtils.createColorFromString(properties.get("color")));
		}
		}
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
	 * Will return HashMap with Shape properties from given string
	 * 
	 * @param s
	 * @return
	 */
	public HashMap<String, String> parsePointProperties(String s) {
		String propertiesString = s.split("\\(")[1]; // Gets shape properties within parentheses
		propertiesString = propertiesString.substring(0, propertiesString.length() - 1); // Remove closing ) from
																							// original string
		HashMap<String, String> properties = new HashMap<String, String>();
		// Split string to get each property
		for (String property : propertiesString.split(",")) {

			String[] keyValue = property.split("="); // Split key value pair
			properties.put(keyValue[0], keyValue[1]);

		}
		return properties;
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
