package shapes.square;

import shapes.Command;
import shapes.point.Point;
import util.Logger;

public class UpdateSquare implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8316444157253972937L;
	private Square original;
	private Square newState;
	private Square oldState = new Square(new Point(), 0);
	private int shapeId;

	public UpdateSquare(Square original, Square newState, int shapeId) {
		this.original = original;
		this.newState = newState;
		this.shapeId = shapeId;
	}

	@Override
	public void execute() {
		oldState.getUpperLeft().setX(original.getUpperLeft().getX());
		oldState.getUpperLeft().setY(original.getUpperLeft().getY());
		oldState.setSideLength(original.getSideLength());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());

		original.getUpperLeft().setX(newState.getUpperLeft().getX());
		original.getUpperLeft().setY(newState.getUpperLeft().getY());
		original.setSideLength(newState.getSideLength());
		original.setColor(newState.getColor());
		original.setInnerColor(newState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shapeId, newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.getUpperLeft().setX(oldState.getUpperLeft().getX());
		original.getUpperLeft().setY(oldState.getUpperLeft().getY());
		original.setSideLength(oldState.getSideLength());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shapeId, original.toString(), true);
	}

}
