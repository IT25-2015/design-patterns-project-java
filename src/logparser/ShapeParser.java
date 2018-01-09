package logparser;

import java.util.HashMap;

import hexagon.Hexagon;
import logparser.util.LogParserUtils;
import shapes.Shape;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

public class ShapeParser {
	private static ShapeParser instance;

	private ShapeParser() {
	}

	/**
	 * Will parse given string, build shape based on it and return shape with
	 * properties parsed from string
	 * 
	 * @param s
	 *            - String from LOG file
	 * 
	 * @return Shape - shape that is parsed from given string
	 */
	public Shape parse(String s) {
		String shapeType = parseType(s);
		HashMap<String, String> properties = parseShapeProperties(s); // Get all Shape properties
		switch (shapeType) {
		case "point": {
			// Return new point that is created from properties above
			return new Point(Integer.parseInt(properties.get("x")), Integer.parseInt(properties.get("y")),
					LogParserUtils.createColorFromString(properties.get("color")));
		}
		case "line": {
			Point startPt = new Point(Integer.parseInt(properties.get("startX")),
					Integer.parseInt(properties.get("startY")));
			Point endPt = new Point(Integer.parseInt(properties.get("endX")), Integer.parseInt(properties.get("endY")));
			return new Line(startPt, endPt, LogParserUtils.createColorFromString(properties.get("color")));
		}
		case "circle": {
			Point centerPt = new Point(Integer.parseInt(properties.get("X")), Integer.parseInt(properties.get("Y")));
			return new Circle(centerPt, Integer.parseInt(properties.get("r")),
					LogParserUtils.createColorFromString(properties.get("outercolor")),
					LogParserUtils.createColorFromString(properties.get("innercolor")));
		}
		case "square": {
			Point upperLeftPt = new Point(Integer.parseInt(properties.get("UpperX")),
					Integer.parseInt(properties.get("UpperY")));
			return new Square(upperLeftPt, Integer.parseInt(properties.get("a")),
					LogParserUtils.createColorFromString(properties.get("outercolor")),
					LogParserUtils.createColorFromString(properties.get("innercolor")));
		}
		case "rectangle": {
			Point upperLeftPt = new Point(Integer.parseInt(properties.get("UpperX")),
					Integer.parseInt(properties.get("UpperY")));
			return new Rectangle(upperLeftPt, Integer.parseInt(properties.get("height")),
					Integer.parseInt(properties.get("width")),
					LogParserUtils.createColorFromString(properties.get("outercolor")),
					LogParserUtils.createColorFromString(properties.get("innercolor")));
		}
		case "hexagon": {
			Hexagon hexa = new Hexagon(Integer.parseInt(properties.get("X")), Integer.parseInt(properties.get("Y")),
					Integer.parseInt(properties.get("r")));
			return new HexagonAdapter(hexa, LogParserUtils.createColorFromString(properties.get("outercolor")),
					LogParserUtils.createColorFromString(properties.get("innercolor")));
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
		String prefix = s.split("\\(")[0]; // Will get everything before Shape properties
		String[] prefixArray = prefix.split("_");
		String type = prefixArray[prefixArray.length - 1].toLowerCase(); // Get Shape type
		return type;
	}

	/**
	 * Will return HashMap with Shape properties from given string
	 * 
	 * @param s
	 * @return
	 */
	public HashMap<String, String> parseShapeProperties(String s) {
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
