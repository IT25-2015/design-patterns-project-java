package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class AddRectangle implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6620674312949569486L;

	private ShapeModel model;
	private Rectangle rectangle;

	public AddRectangle(ShapeModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.add(rectangle);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", rectangle.toString(), true);
	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", rectangle.toString(), true);
	}
}
