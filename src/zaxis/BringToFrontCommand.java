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
		//TODO Fix REDO getting null pointer exception here (2nd execution, with more than 3 shapes)
		ZAxisHelper.doBringToFront(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.get(selectedIndex).toString(), true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.moveShapeToIndex(selectedIndex, shape, model);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.get(selectedIndex).toString(), true);
	}

}
