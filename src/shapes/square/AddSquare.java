package shapes.square;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class AddSquare implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1425698804268370814L;
	private ShapeModel model;
	private Square square;

	public AddSquare(ShapeModel model, Square square) {
		this.model = model;
		this.square = square;
	}

	@Override
	public void execute() {
		model.add(square);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", square.toString(), true);
	}

	@Override
	public void unexecute() {
		model.remove(square);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", square.toString(), true);
	}

}