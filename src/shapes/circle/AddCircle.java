package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class AddCircle implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4151123039349026795L;
	private ShapeModel model;
	private Circle circle;

	public AddCircle(ShapeModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.add(circle);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(circle),
				circle.toString(), true);
	}

	@Override
	public void unexecute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(circle),
				circle.toString(), true);
		model.remove(circle);
	}

}
