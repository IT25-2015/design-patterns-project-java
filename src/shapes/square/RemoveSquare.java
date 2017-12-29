package shapes.square;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemoveSquare implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4714585572854547179L;

	private ShapeModel model;
	private Square square;

	public RemoveSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;
	}

	@Override
	public void execute() {
		model.remove(square);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", square.toString(), true);
	}

	@Override
	public void unexecute() {
		model.add(square);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", square.toString(), true);
	}

}
