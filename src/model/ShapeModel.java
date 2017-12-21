package model;

import java.util.ArrayList;

import shapes.Shape;

public class ShapeModel {
	private ArrayList<Shape> shapesList = new ArrayList<Shape>();

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
}
