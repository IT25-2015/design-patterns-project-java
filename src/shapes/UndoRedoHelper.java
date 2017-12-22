package shapes;

import java.util.Deque;

import model.ShapeModel;

public class UndoRedoHelper {
	private static Deque<Command> undoStack = ShapeModel.getUndoStack();
	private static Deque<Command> redoStack = ShapeModel.getRedoStack();

	/**
	 * Undo last action
	 */
	public static void undoAction() {
		if (!undoStack.isEmpty()) {
			Command previousAction = undoStack.pollLast();
			redoStack.offerLast(previousAction);
			System.out.println("Undo done");
			previousAction.unexecute();
		}
	}

	/**
	 * Redo last action
	 */
	public static void redoAction() {
		if (!redoStack.isEmpty()) {
			Command previousAction = redoStack.pollLast();
			undoStack.offerLast(previousAction);
			System.out.println("Redo done");
			previousAction.execute();
		}
	}
}
