package logparser.test;

import org.junit.*;

import logparser.ShapeParser;

import static org.junit.Assert.*;

public class ShapeParserTest {

	@Test
	public void testGetShapeTypePoint() {
		String expected = "point";
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=60,y=64,color=java.awt.Color[r=0,g=0,b=0])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeLine() {
		String expected = "line";
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=96,startY=101,endX=161,endY=67,color=java.awt.Color[r=0,g=0,b=0])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeCircle() {
		String expected = "circle";
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=208,Y=113,r=45,outercolor=java.awt.Color[r=0,g=0,b=0],innercolor=java.awt.Color[r=255,g=255,b=255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeSquare() {
		String expected = "square";
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=302,UpperY=178,a=62,outercolor=java.awt.Color[r=0,g=0,b=0],innercolor=java.awt.Color[r=255,g=255,b=255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeRectangle() {
		String expected = "rectangle";
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=125,UpperY=206,height=69,width=64,outercolor=java.awt.Color[r=0,g=0,b=0],innercolor=java.awt.Color[r=255,g=255,b=255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetShapeTypeHexagon() {
		String expected = "hexagon";
		String s = "ADDHEXAGONADAPTER_EXECUTE_sid=5_Hexagon(X=40,Y=152,r=45,outercolor=java.awt.Color[r=0,g=0,b=0],innercolor=java.awt.Color[r=255,g=255,b=255])";
		String actual = ShapeParser.getInstance().parseType(s);
		assertEquals(expected, actual);
	}
}
