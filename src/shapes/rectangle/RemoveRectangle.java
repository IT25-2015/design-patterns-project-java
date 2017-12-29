package shapes.rectangle;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemoveRectangle implements Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7085566820551696079L;
	
	private ShapeModel model;
	private Rectangle rectangle;

	public RemoveRectangle(ShapeModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.remove(rectangle);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", rectangle.toString(), true);
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", rectangle.toString(), true);
	}
}
