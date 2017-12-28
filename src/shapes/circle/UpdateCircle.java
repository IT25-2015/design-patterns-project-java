package shapes.circle;

import shapes.Command;
import shapes.point.Point;
import util.Logger;

public class UpdateCircle implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8357314366695335839L;
	private Circle original;
	private Circle newState;
	private Circle oldState = new Circle(new Point(), 0);

	public UpdateCircle(Circle original, Circle newState) {
		this.original = original;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setColor(original.getColor());
		oldState.setInnerColor(original.getInnerColor());

		original.getCenter().setX(newState.getCenter().getX());
		original.getCenter().setY(newState.getCenter().getY());
		original.setColor(newState.getColor());
		original.setInnerColor(newState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.getCenter().setX(oldState.getCenter().getX());
		original.getCenter().setY(oldState.getCenter().getY());
		original.setColor(oldState.getColor());
		original.setInnerColor(oldState.getInnerColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", original.toString(), true);
	}

}
