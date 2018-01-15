package logparser;

import java.io.Serializable;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.circle.RemoveCircle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.hexagon.RemoveHexagonAdapter;
import shapes.hexagon.UpdateHexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.line.RemoveLine;
import shapes.line.UpdateLine;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.point.RemovePoint;
import shapes.point.UpdatePoint;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.Rectangle;
import shapes.rectangle.RemoveRectangle;
import shapes.rectangle.UpdateRectangle;
import shapes.square.AddSquare;
import shapes.square.RemoveSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;

public class CommandParser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5446880322409643478L;
	private static CommandParser instance;

	private CommandParser() {
	}

	/**
	 * Will detect exact command, shape it refers to, build it and return it
	 * 
	 * @param s
	 * @param model
	 * @return Command - command that is parsed from given string
	 */
	public Command parse(String s, ShapeModel model) {
		if (parseCommandType(s).contains("add")) {
			return buildAddCommandFromString(s, model);
		} else if (parseCommandType(s).contains("remove")) {
			return buildRemoveCommandFromString(s, model);
		} else if (parseCommandType(s).contains("update")) {
			return buildUpdateCommandFromString(s, model);
		}
		return null;
	}

	/**
	 * Will detect exact command, shape it refers to, build it(with observer in it)
	 * and return it
	 * 
	 * @param s
	 * @param model
	 * @param frame
	 * @return
	 */
	public Command parse(String s, ShapeModel model, MainFrame frame) {
		if (parseCommandType(s).contains("add")) {
			return buildAddCommandFromString(s, frame, model);
		} else if (parseCommandType(s).contains("remove")) {
			return buildRemoveCommandFromString(s, frame, model);
		} else if (parseCommandType(s).contains("update")) {
			return buildUpdateCommandFromString(s, frame, model);
		}
		return null;
	}

	/**
	 * Will return Command from given string
	 * 
	 * @param s
	 * @return Command in string format
	 */
	public String parseCommandType(String s) {

		return s.split("_")[0].toLowerCase();
	}

	/**
	 * Will return index of shape based on given string
	 * 
	 * @param s
	 * @return
	 */
	public int parseShapeId(String s) {

		// Will split and get sid=? , where ? is actual index
		s = s.split("_")[2];
		// Will get right side of equation, actual index
		s = s.split("=")[1];

		return Integer.parseInt(s);
	}

	/**
	 * Will return true if given command is executed, false if unexecute is done
	 * 
	 * @param s
	 * @return Boolean - true if execute, false if unexecute
	 */
	public Boolean isExecuted(String s) {
		return s.split("_")[1].toLowerCase().equals("execute");
	}

	/**
	 * Will return Add Command object that is built from given String
	 * 
	 * @param s
	 * @return Command
	 */
	public Command buildAddCommandFromString(String s, ShapeModel model) {
		String commandClass = parseCommandType(s);
		switch (commandClass) {
		case "addpoint":
			return new AddPoint(model, ((Point) ShapeParser.getInstance().parse(s)));
		case "addline":
			return new AddLine(model, ((Line) ShapeParser.getInstance().parse(s)));
		case "addcircle":
			return new AddCircle(model, ((Circle) ShapeParser.getInstance().parse(s)));
		case "addsquare":
			return new AddSquare(model, ((Square) ShapeParser.getInstance().parse(s)));
		case "addrectangle":
			return new AddRectangle(model, ((Rectangle) ShapeParser.getInstance().parse(s)));
		case "addhexagonadapter":
			return new AddHexagonAdapter(model, ((HexagonAdapter) ShapeParser.getInstance().parse(s)));
		}
		return null;
	}

	/**
	 * Will return Add Command object(with observer in it) that is built from given
	 * String
	 * 
	 * @param s
	 * @param frame
	 * @param model
	 * @return
	 */
	public Command buildAddCommandFromString(String s, MainFrame frame, ShapeModel model) {
		String commandClass = parseCommandType(s);
		switch (commandClass) {
		case "addpoint":
			return new AddPoint(model, ((Point) ShapeParser.getInstance().parse(s, model, frame)));
		case "addline":
			return new AddLine(model, ((Line) ShapeParser.getInstance().parse(s, model, frame)));
		case "addcircle":
			return new AddCircle(model, ((Circle) ShapeParser.getInstance().parse(s, model, frame)));
		case "addsquare":
			return new AddSquare(model, ((Square) ShapeParser.getInstance().parse(s, model, frame)));
		case "addrectangle":
			return new AddRectangle(model, ((Rectangle) ShapeParser.getInstance().parse(s, model, frame)));
		case "addhexagonadapter":
			return new AddHexagonAdapter(model, ((HexagonAdapter) ShapeParser.getInstance().parse(s, model, frame)));
		}
		return null;
	}

	/**
	 * Will return Remove Command object that is built from given String
	 * 
	 * @param s
	 * @param model
	 * @return Command
	 */
	public Command buildRemoveCommandFromString(String s, ShapeModel model) {
		String commandClass = parseCommandType(s);
		switch (commandClass) {
		case "removepoint":
			return new RemovePoint(model, ((Point) ShapeParser.getInstance().parse(s)));
		case "removeline":
			return new RemoveLine(model, ((Line) ShapeParser.getInstance().parse(s)));
		case "removecircle":
			return new RemoveCircle(model, ((Circle) ShapeParser.getInstance().parse(s)));
		case "removesquare":
			return new RemoveSquare(model, ((Square) ShapeParser.getInstance().parse(s)));
		case "removerectangle":
			return new RemoveRectangle(model, ((Rectangle) ShapeParser.getInstance().parse(s)));
		case "removehexagonadapter":
			return new RemoveHexagonAdapter(model, ((HexagonAdapter) ShapeParser.getInstance().parse(s)));
		}
		return null;
	}

	/**
	 * Will return Remove Command object(with observer in it) that is built from
	 * given String
	 * 
	 * @param s
	 * @param frame
	 * @param model
	 * @return
	 */
	public Command buildRemoveCommandFromString(String s, MainFrame frame, ShapeModel model) {
		String commandClass = parseCommandType(s);
		switch (commandClass) {
		case "removepoint":
			return new RemovePoint(model, ((Point) ShapeParser.getInstance().parse(s, model, frame)));
		case "removeline":
			return new RemoveLine(model, ((Line) ShapeParser.getInstance().parse(s, model, frame)));
		case "removecircle":
			return new RemoveCircle(model, ((Circle) ShapeParser.getInstance().parse(s, model, frame)));
		case "removesquare":
			return new RemoveSquare(model, ((Square) ShapeParser.getInstance().parse(s, model, frame)));
		case "removerectangle":
			return new RemoveRectangle(model, ((Rectangle) ShapeParser.getInstance().parse(s, model, frame)));
		case "removehexagonadapter":
			return new RemoveHexagonAdapter(model, ((HexagonAdapter) ShapeParser.getInstance().parse(s, model, frame)));
		}
		return null;
	}

	/**
	 * Will return Update Command object that is built from given String
	 * 
	 * @param s
	 * @param model
	 * @return Command
	 */
	public Command buildUpdateCommandFromString(String s, ShapeModel model) {
		String commandClass = parseCommandType(s);
		Shape originalShape = model.getShapesList().get(parseShapeId(s));
		Shape modifiedShape = ShapeParser.getInstance().parse(s);
		int shapeId = parseShapeId(s);

		switch (commandClass) {
		case "updatepoint":
			return new UpdatePoint((Point) originalShape, (Point) modifiedShape, shapeId);
		case "updateline":
			return new UpdateLine((Line) originalShape, (Line) modifiedShape, shapeId);
		case "updatecircle":
			return new UpdateCircle((Circle) originalShape, (Circle) modifiedShape, shapeId);
		case "updatesquare":
			return new UpdateSquare((Square) originalShape, (Square) modifiedShape, shapeId);
		case "updaterectangle":
			return new UpdateRectangle((Rectangle) originalShape, (Rectangle) modifiedShape, shapeId);
		case "updatehexagonadapter":
			return new UpdateHexagonAdapter((HexagonAdapter) originalShape, (HexagonAdapter) modifiedShape, shapeId);

		}
		return null;
	}

	/**
	 * Will return Update Command object(with observer in it) that is built from
	 * given String
	 * 
	 * @param s
	 * @param frame
	 * @param model
	 * @return
	 */
	public Command buildUpdateCommandFromString(String s, MainFrame frame, ShapeModel model) {
		String commandClass = parseCommandType(s);
		Shape originalShape = model.getShapesList().get(parseShapeId(s));
		Shape modifiedShape = ShapeParser.getInstance().parse(s, model, frame);
		int shapeId = parseShapeId(s);

		switch (commandClass) {
		case "updatepoint":
			return new UpdatePoint((Point) originalShape, (Point) modifiedShape, shapeId);
		case "updateline":
			return new UpdateLine((Line) originalShape, (Line) modifiedShape, shapeId);
		case "updatecircle":
			return new UpdateCircle((Circle) originalShape, (Circle) modifiedShape, shapeId);
		case "updatesquare":
			return new UpdateSquare((Square) originalShape, (Square) modifiedShape, shapeId);
		case "updaterectangle":
			return new UpdateRectangle((Rectangle) originalShape, (Rectangle) modifiedShape, shapeId);
		case "updatehexagonadapter":
			return new UpdateHexagonAdapter((HexagonAdapter) originalShape, (HexagonAdapter) modifiedShape, shapeId);

		}
		return null;
	}

	/**
	 * Return Thread safe singleton object also using Lazy Loading
	 * 
	 * @return
	 */
	public static CommandParser getInstance() {
		if (instance == null) {
			synchronized (CommandParser.class) {
				if (instance == null) {
					instance = new CommandParser();
				}
			}
		}
		return instance;
	}
}
