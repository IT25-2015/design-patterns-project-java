package logparser;

import java.io.Serializable;

import model.ShapeModel;
import shapes.Command;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.hexagon.AddHexagonAdapter;
import shapes.hexagon.HexagonAdapter;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.rectangle.AddRectangle;
import shapes.rectangle.Rectangle;
import shapes.square.AddSquare;
import shapes.square.Square;

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
	 * Will return true if given command is executed, false if unexecute is done
	 * 
	 * @param s
	 * @return Boolean - true if execute, false if unexecute
	 */
	public Boolean isExecuted(String s) {
		return s.split("_")[1].toLowerCase().equals("execute");
	}

	/**
	 * Will return Command object that is built from given String
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
