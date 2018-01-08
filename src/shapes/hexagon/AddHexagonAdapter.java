package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class AddHexagonAdapter implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4030309798812230073L;
	private ShapeModel model;
	private HexagonAdapter hexAdapter;

	public AddHexagonAdapter(ShapeModel model, HexagonAdapter hexAdapter) {
		this.model = model;
		this.hexAdapter = hexAdapter;
	}

	@Override
	public void execute() {
		model.add(hexAdapter);
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(hexAdapter),
				hexAdapter.toString(), true);
	}

	@Override
	public void unexecute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(hexAdapter),
				hexAdapter.toString(), true);
		model.remove(hexAdapter);
	}

}
