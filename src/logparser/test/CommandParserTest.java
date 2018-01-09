package logparser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import logparser.CommandParser;
import model.ShapeModel;
import shapes.circle.AddCircle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.line.AddLine;
import shapes.point.AddPoint;
import shapes.rectangle.AddRectangle;
import shapes.square.AddSquare;

public class CommandParserTest {

	private ShapeModel fakeModel = new ShapeModel();

	@Before
	public void wipeFakeModel() {
		fakeModel.getShapesList().clear();
	}

	@Test
	public void testIfSingletonInstanceIsReturned() {
		assertTrue(CommandParser.getInstance() instanceof CommandParser);
	}

	@Test
	public void testIfAddPointCommandIsDetected() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		assertEquals("addpoint", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testIfAddLineCommandIsDetected() {
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		assertEquals("addline", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testIfAddCircleCommandIsDetected() {
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertEquals("addcircle", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testIfAddSquareCommandIsDetected() {
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertEquals("addsquare", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testIfAddRectangleCommandIsDetected() {
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertEquals("addrectangle", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testIfAddHexagonCommandIsDetected() {
		String s = "ADDHEXAGONADAPTER_EXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertEquals("addhexagonadapter", CommandParser.getInstance().parseCommandType(s));
	}

	@Test
	public void testifCommandExecuteIsCorrect() {
		String s = "ADDHEXAGONADAPTER_EXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertTrue(CommandParser.getInstance().isExecuted(s));
	}

	@Test
	public void testifCommandUnExecuteIsCorrect() {
		String s = "ADDHEXAGONADAPTER_UNEXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		assertFalse(CommandParser.getInstance().isExecuted(s));
	}

	@Test
	public void testIfAddPointIsReturnedProperly() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		AddPoint command = (AddPoint) CommandParser.getInstance().buildAddCommandFromString(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddLineIsReturnedProperly() {
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		AddLine command = (AddLine) CommandParser.getInstance().buildAddCommandFromString(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddCircleIsReturnedProperly() {
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddCircle command = (AddCircle) CommandParser.getInstance().buildAddCommandFromString(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddSquareIsReturnedProperly() {
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddSquare command = (AddSquare) CommandParser.getInstance().buildAddCommandFromString(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddRectangleIsReturnedProperly() {
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddRectangle command = (AddRectangle) CommandParser.getInstance().buildAddCommandFromString(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddHexagonAdapterIsReturnedProperly() {
		String s = "ADDHEXAGONADAPTER_UNEXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddHexagonAdapter command = (AddHexagonAdapter) CommandParser.getInstance().buildAddCommandFromString(s,
				fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddPointIsParsed() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		AddPoint command = (AddPoint) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddLineIsIsParsed() {
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		AddLine command = (AddLine) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddCircleIsParsed() {
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddCircle command = (AddCircle) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddSquareIsParsed() {
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddSquare command = (AddSquare) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddRectangleIsParsed() {
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddRectangle command = (AddRectangle) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfAddHexagonAdapterIsParsed() {
		String s = "ADDHEXAGONADAPTER_UNEXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddHexagonAdapter command = (AddHexagonAdapter) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();
		assertEquals(1, fakeModel.getShapesList().size());
	}
}
