package zaxis;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import util.Logger;
import util.ZAxisHelper;

public class BringToFrontCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4453193099314868550L;
	private int selectedIndex = -1;
	private Shape shape;
	private ShapeModel model;
	private MainFrame frame;

	public BringToFrontCommand(int selectedIndex, ShapeModel model, MainFrame frame) {
		this.selectedIndex = selectedIndex;
		this.model = model;
		this.frame = frame;
		shape = model.getShapesList().get(selectedIndex);
	}

	@Override
	public void execute() {
		ZAxisHelper.doBringToFront(shape, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", shape.toString(), true, true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.moveShapeToIndex(selectedIndex, shape, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", shape.toString(), true, true);
	}

}
