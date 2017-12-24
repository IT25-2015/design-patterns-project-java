package shapes.point;

import model.ShapeModel;
import shapes.Command;

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
	}

	@Override
	public void unexecute() {
		model.add(point);
	}
}
