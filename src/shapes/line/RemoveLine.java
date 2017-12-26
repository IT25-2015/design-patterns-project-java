package shapes.line;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemoveLine implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2029882472633343785L;
	private ShapeModel model;
	private Line line;

	public RemoveLine(ShapeModel model, Line line) {
		this.model = model;
		this.line = line;
	}

	@Override
	public void execute() {
		model.remove(line);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", line.toString(), true);
	}

	@Override
	public void unexecute() {
		model.add(line);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", line.toString(), true);
	}
}
