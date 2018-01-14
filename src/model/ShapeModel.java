package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import app.App;
import shapes.Command;
import shapes.Shape;

public class ShapeModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5650547213589215369L;
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	private static Deque<Command> undoStack = new LinkedList<Command>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5938971797350237013L;

		@Override
		public boolean offerLast(Command arg0) {
			boolean result = super.offerLast(arg0);
			App.getFrame().getHeaderWrapperView().getToolboxView().getBtnUndo().setEnabled(!isEmpty());
			App.getFrame().getHeaderWrapperView().getMntmUndo().setEnabled(!isEmpty());
			return result;
		}

		@Override
		public Command pollLast() {
			Command result = super.pollLast();
			App.getFrame().getHeaderWrapperView().getToolboxView().getBtnUndo().setEnabled(!isEmpty());
			App.getFrame().getHeaderWrapperView().getMntmUndo().setEnabled(!isEmpty());
			return result;
		}

	};
	private static Deque<Command> redoStack = new LinkedList<Command>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7415523813015969855L;

		@Override
		public boolean offerLast(Command arg0) {
			boolean result = super.offerLast(arg0);
			App.getFrame().getHeaderWrapperView().getToolboxView().getBtnRedo().setEnabled(!isEmpty());
			App.getFrame().getHeaderWrapperView().getMntmRedo().setEnabled(!isEmpty());
			return result;
		}

		@Override
		public Command pollLast() {
			Command result = super.pollLast();
			App.getFrame().getHeaderWrapperView().getToolboxView().getBtnRedo().setEnabled(!isEmpty());
			App.getFrame().getHeaderWrapperView().getMntmRedo().setEnabled(!isEmpty());
			return result;
		}

	};

	/**
	 * Returns shape on given index from shape list
	 * 
	 * @param i
	 * @return
	 */
	public Shape get(int i) {
		return shapesList.get(i);
	}

	/**
	 * Adds given shape to shape list
	 * 
	 * @param s
	 */
	public void add(Shape s) {
		shapesList.add(s);
	}

	/**
	 * Remove given shape from shape list
	 * 
	 * @param s
	 * @return
	 */
	public boolean remove(Shape s) {
		return shapesList.remove(s);
	}

	/**
	 * Returns integer index of given shape in shape list
	 * 
	 * @param s
	 * @return
	 */
	public int getShapeIndex(Shape s) {
		return shapesList.indexOf(s);
	}

	public ArrayList<Shape> getShapesList() {
		return shapesList;
	}

	public static Deque<Command> getUndoStack() {
		return undoStack;
	}

	public static Deque<Command> getRedoStack() {
		return redoStack;
	}

	public void setShapesList(ArrayList<Shape> shapesList) {
		this.shapesList = shapesList;
	}

	public static void setUndoStack(Deque<Command> undoStack) {
		ShapeModel.undoStack = undoStack;
	}

	public static void setRedoStack(Deque<Command> redoStack) {
		ShapeModel.redoStack = redoStack;
	}
}
