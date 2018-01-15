package util;

import java.util.Deque;

import shapes.Command;

public class UndoRedoHelper {

	/**
	 * Undo last action
	 */
	public static void undoAction(Deque<Command> undoStack, Deque<Command> redoStack) {
		if (!undoStack.isEmpty()) {
			Command previousAction = undoStack.pollLast();
			redoStack.offerLast(previousAction);
			previousAction.unexecute();

		} else {
			DialogsHelper.showErrorMessage("Undo stack is empty, nothing to undo.");
		}
	}

	/**
	 * Redo last action
	 */
	public static void redoAction(Deque<Command> undoStack, Deque<Command> redoStack) {
		if (!redoStack.isEmpty()) {
			Command previousAction = redoStack.pollLast();
			undoStack.offerLast(previousAction);
			previousAction.execute();
		} else {
			DialogsHelper.showErrorMessage("Redo stack is empty, nothing to redo.");
		}
	}
}
