package zaxis;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import util.Logger;
import util.ZAxisHelper;

public class ToBackCommand implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7699736277398433843L;
	private int selectedIndex = -1;
	private ShapeModel model;
	private MainFrame frame;

	public ToBackCommand(int selectedIndex, ShapeModel model, MainFrame frame) {
		this.selectedIndex = selectedIndex;
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void execute() {
		ZAxisHelper.doToBack(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.get(selectedIndex).toString(), true);
	}

	@Override
	public void unexecute() {
		ZAxisHelper.doToFront(selectedIndex, model, frame);

		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.get(selectedIndex).toString(), true);
	}

}
