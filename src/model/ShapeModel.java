package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import shapes.Command;
import shapes.Shape;

public class ShapeModel implements Serializable {
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();
	private static Deque<Command> undoStack = new LinkedList<>();
	private static Deque<Command> redoStack = new LinkedList<>();

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

	public ArrayList<Shape> getShapesList() {
		return shapesList;
	}

	public static Deque<Command> getUndoStack() {
		return undoStack;
	}

	public static Deque<Command> getRedoStack() {
		return redoStack;
	}
}
