package shapes.point;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemovePoint implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5691468685793918184L;
	private ShapeModel model;
	private Point point;

	public RemovePoint(ShapeModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.remove(point);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", point.toString(), true);
	}

	@Override
	public void unexecute() {
		model.add(point);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", point.toString(), true);
	}
}
