package logparser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import hexagon.Hexagon;
import logparser.ShapeParser;
import shapes.circle.Circle;
import shapes.hexagon.HexagonAdapter;
import shapes.line.Line;
import shapes.point.Point;
import shapes.rectangle.Rectangle;
import shapes.square.Square;

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
		Map<String, String> actual = ShapeParser.getInstance().parseShapeProperties(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testCreatePointFromString() {
		Point expected = new Point(128, 256, new Color(255, 255, 0));
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=128,y=256,color=[255-255-0])";
		Point actual = (Point) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor()));
	}

	@Test
	public void testCreateLineFromString() {
		Line expected = new Line(new Point(60, 110), new Point(141, 80), new Color(0, 0, 0));
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		Line actual = (Line) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor()));
	}

	@Test
	public void testCreateCircleFromString() {
		Circle expected = new Circle(new Point(227, 122), 44, new Color(0, 0, 0), new Color(255, 255, 255));
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		Circle actual = (Circle) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor())
				&& expected.getInnerColor().equals(actual.getInnerColor()));
	}

	@Test
	public void testCreateSquareFromString() {
		Square expected = new Square(new Point(51, 208), 56, new Color(0, 0, 0), new Color(255, 255, 255));
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		Square actual = (Square) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor())
				&& expected.getInnerColor().equals(actual.getInnerColor()));

	}

	@Test
	public void testCreateRectangleFromString() {
		Square expected = new Rectangle(new Point(189, 233), 36, 132, new Color(0, 0, 0), new Color(255, 255, 255));
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		Square actual = (Rectangle) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor())
				&& expected.getInnerColor().equals(actual.getInnerColor()));

	}

	@Test
	public void testCreateHexagonFromString() {
		Hexagon hexa = new Hexagon(373, 108, 62);
		HexagonAdapter expected = new HexagonAdapter(hexa, new Color(0, 0, 0), new Color(255, 255, 255));
		String s = "ADDHEXAGONADAPTER_EXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		HexagonAdapter actual = (HexagonAdapter) ShapeParser.getInstance().parse(s);
		assertTrue(expected.equals(actual) && expected.getColor().equals(actual.getColor())
				&& expected.getInnerColor().equals(actual.getInnerColor()));
	}

}
