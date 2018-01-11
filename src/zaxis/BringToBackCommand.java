package zaxis;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import util.Logger;
import util.ZAxisHelper;

public class BringToBackCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1523731526797266070L;
	private int selectedIndex = -1;
	private Shape shape;
	private ShapeModel model;
	private MainFrame frame;

	public BringToBackCommand(int selectedIndex, ShapeModel model, MainFrame frame) {
		this.selectedIndex = selectedIndex;
		this.model = model;
		this.frame = frame;
		this.shape = model.get(selectedIndex);
	}

	@Override
	public void execute() {
		//TODO Fix REDO getting null pointer exception here (2nd execution, with more than 3 shapes)
		ZAxisHelper.doBringToBack(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.get(selectedIndex).toString(), true, true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.moveShapeToIndex(selectedIndex, shape, model);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.get(selectedIndex).toString(), true, true);
	}

}
