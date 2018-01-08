package util;

import java.util.Collections;

import app.MainFrame;
import model.ShapeModel;
import shapes.Shape;

public class ZAxisHelper {

	/**
	 * Will bring selected shape to front(on top of all shapes) and return its new
	 * index
	 * 
	 * @param selectedIndex
	 * @param model
	 * @param frame
	 * @return
	 */
	public static int doBringToFront(int selectedIndex, ShapeModel model, MainFrame frame) {
		if (selectedIndex != -1 && selectedIndex != (model.getShapesList().size() - 1)) {
			Shape selectedShape = getSelectedShape(model);
			model.getShapesList().remove(selectedIndex);
			model.getShapesList().add(selectedShape);
		}
		frame.repaint();
		return model.getShapesList().size() - 1;
	}

	/**
	 * Will put selected shape to back(behind all shapes) and return its new index
	 * 
	 * @param selectedIndex
	 * @param model
	 * @param frame
	 * @return
	 */
	public static int doBringToBack(int selectedIndex, ShapeModel model, MainFrame frame) {
		if (selectedIndex != -1 && selectedIndex != 0) {
			Shape selectedShape = getSelectedShape(model);
			model.getShapesList().remove(selectedIndex);
			model.getShapesList().add(0, selectedShape);
		}
		frame.repaint();
		return 0;
	}

	/**
	 * Will move selected shape for 1 position to front
	 */
	public static void doToFront(int selectedIndex, ShapeModel model, MainFrame frame) {
		if (selectedIndex != -1 && selectedIndex != (model.getShapesList().size() - 1)) {
			Collections.swap(model.getShapesList(), selectedIndex + 1, selectedIndex);
		}
		frame.repaint();
	}

	/**
	 * Will move selected shape for 1 position to back
	 */
	public static void doToBack(int selectedIndex, ShapeModel model, MainFrame frame) {
		if (selectedIndex != -1 && selectedIndex != 0) {
			Collections.swap(model.getShapesList(), selectedIndex - 1, selectedIndex);
		}
		frame.repaint();
	}

	/**
	 * Will move given shape to given new index in given ShapeModel list of shapes
	 * 
	 * @param newIndex
	 * @param shape
	 * @param model
	 */
	public static void moveShapeToIndex(int newIndex, Shape shape, ShapeModel model) {
		if (model.getShapesList().remove(shape)) {
			if(newIndex < model.getShapesList().size() - 1) {
				model.getShapesList().add(newIndex, shape);
			} else {
				model.getShapesList().add(shape);
			}
		}
	}

	/**
	 * Will return single selected shape
	 * 
	 * @return Shape
	 */
	public static Shape getSelectedShape(ShapeModel model) {
		for (Shape s : model.getShapesList()) {
			if (s != null && s.isSelected()) {
				return s;
			}
		}
		return null;
	}

	/**
	 * Will return index in array list of selected shape
	 * 
	 * @return Int index
	 */
	public static int getSelectedShapeIndex(ShapeModel model) {
		int listSize = model.getShapesList().size() - 1;
		for (int i = 0; i <= listSize; i++) {
			if (model.getShapesList().get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
}
