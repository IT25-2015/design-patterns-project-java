package shapes.line;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class AddLine implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 453513436433583837L;
	private ShapeModel model;
	private Line line;

	public AddLine(ShapeModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.add(line);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", line.toString(), true);
	}

	@Override
	public void unexecute() {
		model.remove(line);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", line.toString(), true);
	}
}
