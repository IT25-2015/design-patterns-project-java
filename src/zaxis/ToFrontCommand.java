package zaxis;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import util.Logger;
import util.ZAxisHelper;

public class ToFrontCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7066997025909178409L;

	private int selectedIndex = -1;
	private ShapeModel model;
	private MainFrame frame;

	public ToFrontCommand(int selectedIndex, ShapeModel model, MainFrame frame) {
		this.selectedIndex = selectedIndex;
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void execute() {
		ZAxisHelper.doToFront(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.get(selectedIndex).toString(), true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.doToBack(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.get(selectedIndex).toString(), true);
	}

}
