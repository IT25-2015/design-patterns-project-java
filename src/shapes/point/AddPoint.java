package shapes.point;

import util.Logger;

import model.ShapeModel;
import shapes.Command;

public class AddPoint implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7780529610976885676L;
	private ShapeModel model;
	private Point point;

	public AddPoint(ShapeModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.add(point);
		Logger.getInstance().log("AddPoint_execute",point.toString(), true);
	}

	@Override
	public void unexecute() {
		model.remove(point);
		Logger.getInstance().log("AddPoint_unexecute",point.toString(), true);
	}
}
