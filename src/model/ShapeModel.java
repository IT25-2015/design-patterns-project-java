package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import shapes.Command;
import shapes.Shape;

public class ShapeModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5650547213589215369L;
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	private Deque<Command> undoStack = new LinkedList<Command>();
	private Deque<Command> redoStack = new LinkedList<Command>();

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

	public void setShapesList(ArrayList<Shape> shapesList) {
		this.shapesList = shapesList;
	}

	public Deque<Command> getUndoStack() {
		return undoStack;
	}

	public Deque<Command> getRedoStack() {
		return redoStack;
	}
}
