package shapes.circle;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemoveCircle implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6198495156898877804L;
	private ShapeModel model;
	private Circle circle;

	public RemoveCircle(ShapeModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(circle),
				circle.toString(), true);
		model.remove(circle);
	}

	@Override
	public void unexecute() {
		model.add(circle);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(circle),
				circle.toString(), true);
	}

}
