package logparser.test;

import org.junit.*;

import logparser.ShapeParser;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class ShapeParserTest {

	@Test
	public void testGetShapeTypePoint() {
		String expected = "point";
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeLine() {
		String expected = "line";
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeCircle() {
		String expected = "circle";
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeSquare() {
		String expected = "square";
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeRectangle() {
		String expected = "rectangle";
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeHexagon() {
		String expected = "hexagon";
		String s = "ADDHEXAGONADAPTER_EXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParsePropertiesFromStringIntoHashMap() {
		Map<String, String> expected = new HashMap<String, String>();
		expected.put("x", "66");
		expected.put("y", "62");
		expected.put("color", "[0-0-0]");
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		Map<String, String> actual = ShapeParser.getInstance().parsePointProperties(s);
		assertEquals(expected, actual);
	}
}
