package shapes.hexagon;

import model.ShapeModel;
import shapes.Command;
import util.Logger;

public class RemoveHexagonAdapter implements Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7679710274668716816L;
	private ShapeModel model;
	private HexagonAdapter hexAdapter;

	public RemoveHexagonAdapter(ShapeModel model, HexagonAdapter hexAdapter) {
		this.model = model;
		this.hexAdapter = hexAdapter;
	}

	@Override
	public void execute() {
		Logger.getInstance().log(getClass().getSimpleName() + "_execute", model.getShapeIndex(hexAdapter),
				hexAdapter.toString(), true);
		model.remove(hexAdapter);
	}

	@Override
	public void unexecute() {
		model.add(hexAdapter);
		Logger.getInstance().log(getClass().getSimpleName() + "_unexecute", model.getShapeIndex(hexAdapter),
				hexAdapter.toString(), true);
	}

}
