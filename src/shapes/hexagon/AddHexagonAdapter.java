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
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", hexAdapter.toString(), true);
	}

	@Override
	public void unexecute() {
		model.remove(hexAdapter);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", hexAdapter.toString(), true);
	}

}
