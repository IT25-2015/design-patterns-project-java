package controller;

import shapes.UndoRedoHelper;

public class ToolboxController {

	/**
	 * Will handle event of clicking undo button
	 */
	public void handleUndoBtn() {
		UndoRedoHelper.undoAction();
	}

	/**
	 * Will handle event of clicking redo button
	 */
	public void handleRedoBtn() {
		UndoRedoHelper.redoAction();
	}
}
