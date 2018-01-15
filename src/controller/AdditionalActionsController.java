package controller;

import java.io.Serializable;

import app.MainFrame;
import model.ShapeModel;
import util.ZAxisHelper;
import zaxis.BringToBackCommand;
import zaxis.BringToFrontCommand;
import zaxis.ToBackCommand;
import zaxis.ToFrontCommand;

@SuppressWarnings("serial")
public class AdditionalActionsController implements Serializable {
	private ShapeModel model;
	private MainFrame frame;

	public AdditionalActionsController(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	/**
	 * Will execute Bring To Front command if it can be done
	 */
	public void doBringToFront() {
		if (!frame.getAdditionalActionsView().getBtnBringToFront().isEnabled())
			return;

		int selectedIndex = ZAxisHelper.getSelectedShapeIndex(model);
		BringToFrontCommand btfCommand = new BringToFrontCommand(selectedIndex, model, frame);
		btfCommand.execute();
		model.getUndoStack().offerLast(btfCommand);
	}

	/**
	 * Will execute Bring To Back command if it can be done
	 */
	public void doBringToBack() {
		if (!frame.getAdditionalActionsView().getBtnBringToBack().isEnabled())
			return;

		int selectedIndex = ZAxisHelper.getSelectedShapeIndex(model);
		BringToBackCommand btbCommand = new BringToBackCommand(selectedIndex, model, frame);
		btbCommand.execute();
		model.getUndoStack().offerLast(btbCommand);
	}

	/**
	 * Will execute To Front command if it can be done
	 */
	public void doToFront() {
		if (!frame.getAdditionalActionsView().getBtnToFront().isEnabled())
			return;

		ToFrontCommand tfCommand = new ToFrontCommand(model, frame);
		tfCommand.execute();
		model.getUndoStack().offerLast(tfCommand);
	}

	/**
	 * Will execute To Back command if it can be done
	 */
	public void doToBack() {
		if (!frame.getAdditionalActionsView().getBtnToBack().isEnabled())
			return;

		ToBackCommand tbCommand = new ToBackCommand(model, frame);
		tbCommand.execute();
		model.getUndoStack().offerLast(tbCommand);
	}

}
