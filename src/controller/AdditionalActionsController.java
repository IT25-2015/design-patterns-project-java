package controller;

import java.util.Collections;

import app.MainFrame;
import model.ShapeModel;
import shapes.Shape;

public class AdditionalActionsController {
	private ShapeModel model;
	private MainFrame frame;

	public AdditionalActionsController(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	/**
	 * Will bring selected shape to front(on top of all shapes)
	 */
	public void doBringToFront() {
		int selectedIndex = getSelectedShapeIndex();
		if (selectedIndex != -1 && selectedIndex != (model.getShapesList().size() - 1)) {
			Shape selectedShape = getSelectedShape();
			model.getShapesList().remove(selectedIndex);
			model.getShapesList().add(selectedShape);
		}
		frame.repaint();
	}

	/**
	 * Will put selected shape to back(behind all shapes)
	 */
	public void doBringToBack() {
		int selectedIndex = getSelectedShapeIndex();
		if (selectedIndex != -1 && selectedIndex != 0) {
			Shape selectedShape = getSelectedShape();
			model.getShapesList().remove(selectedIndex);
			model.getShapesList().add(0, selectedShape);
		}
		frame.repaint();
	}

	/**
	 * Will move selected shape for 1 position to front
	 */
	public void doToFront() {
		int selectedIndex = getSelectedShapeIndex();
		if (selectedIndex != -1 && selectedIndex != (model.getShapesList().size() - 1)) {
			Collections.swap(model.getShapesList(), selectedIndex + 1, selectedIndex);
		}
		frame.repaint();
	}

	/**
	 * Will move selected shape for 1 position to back
	 */
	public void doToBack() {
		int selectedIndex = getSelectedShapeIndex();
		if (selectedIndex != -1 && selectedIndex != 0) {
			Collections.swap(model.getShapesList(), selectedIndex - 1, selectedIndex);
		}
		frame.repaint();
	}

	/**
	 * Will return single selected shape
	 * 
	 * @return Shape
	 */
	private Shape getSelectedShape() {
		for (Shape s : model.getShapesList()) {
			if (s.isSelected()) {
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
	private int getSelectedShapeIndex() {
		int listSize = model.getShapesList().size() - 1;
		for (int i = 0; i <= listSize; i++) {
			if (model.getShapesList().get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
}
