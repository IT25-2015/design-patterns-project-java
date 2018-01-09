package logparser.util;

import java.awt.Color;
import java.util.Arrays;

public class LogParserUtils {

	/**
	 * Will create Color object from string in format [r-g-b]
	 * 
	 * @param s
	 * @return Color
	 */
	public static Color createColorFromString(String s) {
		String[] RGBs = s.split("[-\\[\\]]"); // Regex to match values
		RGBs = Arrays.copyOfRange(RGBs, 1, 4); // Remove white space before values

		return new Color(Integer.parseInt(RGBs[0]), Integer.parseInt(RGBs[1]), Integer.parseInt(RGBs[2]));
	}

}
