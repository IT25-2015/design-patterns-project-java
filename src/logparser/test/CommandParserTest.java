package logparser.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import logparser.CommandParser;
import model.ShapeModel;
import shapes.circle.AddCircle;
import shapes.circle.RemoveCircle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.RemoveHexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.line.RemoveLine;
import shapes.line.UpdateLine;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.point.RemovePoint;
import shapes.point.UpdatePoint;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.RemoveRectangle;
import shapes.square.AddSquare;
import shapes.square.RemoveSquare;

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

	@Test
	public void testIfRemovePointIsParsed() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		AddPoint command = (AddPoint) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVEPOINT_EXECUTE_sid=0_Point(x=66,y=62,color=[0-0-0])";
		RemovePoint commandRem = (RemovePoint) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfRemoveLineIsIsParsed() {
		String s = "ADDLINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		AddLine command = (AddLine) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVELINE_EXECUTE_sid=1_Line(startX=60,startY=110,endX=141,endY=80,color=[0-0-0])";
		RemoveLine commandRem = (RemoveLine) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfRemoveCircleIsParsed() {
		String s = "ADDCIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddCircle command = (AddCircle) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVECIRCLE_EXECUTE_sid=2_Circle(X=227,Y=122,r=44,outercolor=[0-0-0],innercolor=[255-255-255])";
		RemoveCircle commandRem = (RemoveCircle) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfRemoveSquareIsParsed() {
		String s = "ADDSQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddSquare command = (AddSquare) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVESQUARE_EXECUTE_sid=3_Square(UpperX=51,UpperY=208,a=56,outercolor=[0-0-0],innercolor=[255-255-255])";
		RemoveSquare commandRem = (RemoveSquare) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfRemoveRectangleIsParsed() {
		String s = "ADDRECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddRectangle command = (AddRectangle) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVERECTANGLE_EXECUTE_sid=4_Rectangle(UpperX=189,UpperY=233,height=36,width=132,outercolor=[0-0-0],innercolor=[255-255-255])";
		RemoveRectangle commandRem = (RemoveRectangle) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfRemoveHexagonAdapterIsParsed() {
		String s = "ADDHEXAGONADAPTER_UNEXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		AddHexagonAdapter command = (AddHexagonAdapter) CommandParser.getInstance().parse(s, fakeModel);
		String sr = "REMOVEHEXAGONADAPTER_UNEXECUTE_sid=5_Hexagon(X=373,Y=108,r=62,outercolor=[0-0-0],innercolor=[255-255-255])";
		RemoveHexagonAdapter commandRem = (RemoveHexagonAdapter) CommandParser.getInstance().parse(sr, fakeModel);
		command.execute();
		commandRem.execute();
		assertEquals(0, fakeModel.getShapesList().size());
	}

	@Test
	public void testIfProperShapeIndexIsParsed() {
		String s = "UPDATELINE_EXECUTE_sid=1337_Line(startX=150,startY=162,endX=223,endY=180,color=[255-51-51])";
		int actual = CommandParser.getInstance().parseShapeId(s);

		assertEquals(1337, actual);
	}

	@Test
	public void testIfUpdatePointIsParsedSimple() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=137,y=86,color=[0-0-0])";
		AddPoint command = (AddPoint) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();

		String sUpdate = "UPDATEPOINT_EXECUTE_sid=0_Point(x=137,y=86,color=[255-0-51])";
		UpdatePoint commandUpdate = (UpdatePoint) CommandParser.getInstance().parse(sUpdate, fakeModel);
		commandUpdate.execute();

		Color actual = fakeModel.getShapesList().get(0).getColor();
		Color expected = new Color(255, 0, 51);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testIfUpdatePointIsParsedAdvanced() {
		String s = "ADDPOINT_EXECUTE_sid=0_Point(x=137,y=86,color=[0-0-0])";
		AddPoint command = (AddPoint) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();

		String sUpdate = "UPDATEPOINT_EXECUTE_sid=0_Point(x=137,y=86,color=[255-0-51])";
		UpdatePoint commandUpdate = (UpdatePoint) CommandParser.getInstance().parse(sUpdate, fakeModel);
		commandUpdate.execute();

		String sUpdateX = "UPDATEPOINT_EXECUTE_sid=0_Point(x=250,y=86,color=[255-0-51])";
		UpdatePoint commandUpdateX = (UpdatePoint) CommandParser.getInstance().parse(sUpdateX, fakeModel);
		commandUpdateX.execute();

		String sUpdateY = "UPDATEPOINT_EXECUTE_sid=0_Point(x=250,y=456,color=[255-0-51])";
		UpdatePoint commandUpdateY = (UpdatePoint) CommandParser.getInstance().parse(sUpdateY, fakeModel);
		commandUpdateY.execute();

		Color actualColor = fakeModel.getShapesList().get(0).getColor();
		Color expectedColor = new Color(255, 0, 51);
		int actualX = ((Point) fakeModel.getShapesList().get(0)).getX();
		int expectedX = 250;
		int actualY = ((Point) fakeModel.getShapesList().get(0)).getY();
		int expectedY = 456;
		assertTrue(actualColor.equals(expectedColor) && actualX == expectedX && actualY == expectedY);
	}

	@Test
	public void testIfUpdateLineIsParsedSimple() {
		String s = "ADDLINE_EXECUTE_sid=0_Line(startX=93,startY=162,endX=223,endY=93,color=[0-0-0])";
		AddLine command = (AddLine) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();

		String sUpdate = "UPDATELINE_EXECUTE_sid=0_Line(startX=93,startY=162,endX=223,endY=93,color=[255-51-51])";
		UpdateLine commandUpdate = (UpdateLine) CommandParser.getInstance().parse(sUpdate, fakeModel);
		commandUpdate.execute();

		Color actual = fakeModel.getShapesList().get(0).getColor();
		Color expected = new Color(255, 51, 51);
		assertTrue(actual.equals(expected));
	}

	@Test
	public void testIfUpdateLineIsParsedAdvanced() {
		String s = "ADDLINE_EXECUTE_sid=0_Line(startX=93,startY=162,endX=223,endY=93,color=[0-0-0])";
		AddLine command = (AddLine) CommandParser.getInstance().parse(s, fakeModel);
		command.execute();

		String sUpdate = "UPDATELINE_EXECUTE_sid=0_Line(startX=93,startY=162,endX=223,endY=93,color=[255-51-51])";
		UpdateLine commandUpdate = (UpdateLine) CommandParser.getInstance().parse(sUpdate, fakeModel);
		commandUpdate.execute();

		String sUpdateX = "UPDATELINE_EXECUTE_sid=0_Line(startX=150,startY=162,endX=223,endY=93,color=[255-51-51])";
		UpdateLine commandUpdateX = (UpdateLine) CommandParser.getInstance().parse(sUpdateX, fakeModel);
		commandUpdateX.execute();

		String sUpdateY = "UPDATELINE_EXECUTE_sid=0_Line(startX=150,startY=162,endX=223,endY=180,color=[255-51-51])";
		UpdateLine commandUpdateY = (UpdateLine) CommandParser.getInstance().parse(sUpdateY, fakeModel);
		commandUpdateY.execute();

		Color actualColor = fakeModel.getShapesList().get(0).getColor();
		Color expectedColor = new Color(255, 51, 51);
		int actualX = ((Line) fakeModel.getShapesList().get(0)).getPtStart().getX();
		int expectedX = 150;
		int actualY = ((Line) fakeModel.getShapesList().get(0)).getPtEnd().getY();
		int expectedY = 180;
		assertTrue(actualColor.equals(expectedColor) && actualX == expectedX && actualY == expectedY);
	}
}
