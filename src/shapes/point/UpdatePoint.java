package shapes.point;

import shapes.Command;
import util.Logger;

public class UpdatePoint implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6507203937849837768L;
	private Point original;
	private Point newState;
	private Point oldState = new Point();

	public UpdatePoint(Point original, Point newState) {
		this.original = original;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setColor(original.getColor());

		original.setX(newState.getX());
		original.setY(newState.getY());
		original.setColor(newState.getColor());

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", newState.toString(), true);
	}

	@Override
	public void unexecute() {
		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setColor(oldState.getColor());
		
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", original.toString(), true);
	}
}
