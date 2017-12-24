package controller;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import app.MainFrame;
import model.ShapeModel;
import shapes.Shape;
import util.Logger;
import util.UndoRedoHelper;

public class ToolboxController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2584337498381831016L;
	ShapeModel model;
	MainFrame frame;

	public ToolboxController(ShapeModel model, MainFrame frame) {
		this.model = model;
		this.frame = frame;
	}

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

	/**
	 * Will handle event of selecting shape
	 * 
	 * @param e
	 */
	public void handleSelect(MouseEvent e) {
		boolean shapeFound = false;
		for (Shape s : model.getShapesList()) {
			if (s.contains(e.getX(), e.getY()) && !s.isSelected()) {
				s.setSelected(true);
				Logger.getInstance().log("SELECTED", s.toString(), true);
				frame.repaint();
				shapeFound = true;
			}
		}
		if (!shapeFound) {
			Logger.getInstance().log(String.format("No shapes found at location (%d,%d)", e.getX(), e.getY()), true);
			for (Shape s : model.getShapesList()) {
				s.setSelected(false);
				frame.repaint();
			}
		}
	}
	
	public void handleDelete() {
		ArrayList<Shape> shapesToDelete = new ArrayList<Shape>();
		for (Shape s : model.getShapesList()) {
			if(s.isSelected())
				shapesToDelete.add(s);
		}
		if(shapesToDelete.size() == 0) return;
		else if(shapesToDelete.size() == 1) {
			//TODO implement warning dialog
			model.getShapesList().remove(shapesToDelete.get(0));
			frame.repaint();
		} else {
			//TODO implement multiplie shape warning dialog
			for (Shape s : shapesToDelete) {
				model.getShapesList().remove(s);
			}
			frame.repaint();
		}
	}

	/**
	 * Will handle event when select button changes its state Exits from select mode
	 * when button is not toggled, de-selects all shapes
	 * 
	 * @param ev
	 */
	public void handleSelectBtnStateChange(ItemEvent ev) {
		if (ev.getStateChange() == ItemEvent.SELECTED) {
			Logger.getInstance().log("Entering select mode", true);
		} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
			Logger.getInstance().log("Exiting select mode", true);
			for (Shape s : model.getShapesList()) {
				s.setSelected(false);
				frame.repaint();
			}
			Logger.getInstance().log("All shapes have been de-selected", true);
		}
	}

	/**
	 * Will set background color of button based on chosen color in JColorChooser
	 * If color is not chosen, it will return current color
	 * @param btn
	 */
	public void handleColorButtonClick(JButton btn) {
		Color newColor = JColorChooser.showDialog(btn, "Choose color", btn.getBackground());
		btn.setBackground((newColor != null)?newColor:btn.getBackground());
	}
}
