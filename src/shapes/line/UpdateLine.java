package shapes.line;

import shapes.Command;
import shapes.point.Point;
import util.Logger;

public class UpdateLine implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5049702815541951423L;
	private Line original;
	private Line newState;
	private Line oldState = new Line(new Point(), new Point());
	private int shapeId;

	public UpdateLine(Line original, Line newState, int shapeId) {
		this.original = original;
		this.newState = newState;
		this.shapeId = shapeId;
	}

	@Override
	public void execute() {
		oldState.getPtStart().setX(original.getPtStart().getX());
		oldState.getPtStart().setY(original.getPtStart().getY());
		oldState.getPtEnd().setX(original.getPtEnd().getX());
		oldState.getPtEnd().setY(original.getPtEnd().getY());
		oldState.setColor(original.getColor());

		original.getPtStart().setX(newState.getPtStart().getX());
		original.getPtStart().setY(newState.getPtStart().getY());
		original.getPtEnd().setX(newState.getPtEnd().getX());
		original.getPtEnd().setY(newState.getPtEnd().getY());
		original.setColor(newState.getColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shapeId, newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.getPtStart().setX(oldState.getPtStart().getX());
		original.getPtStart().setY(oldState.getPtStart().getY());
		original.getPtEnd().setX(oldState.getPtEnd().getX());
		original.getPtEnd().setY(oldState.getPtEnd().getY());
		original.setColor(oldState.getColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shapeId, original.toString(), true);
	}
}
