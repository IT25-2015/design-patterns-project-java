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
import shapes.Command;
import shapes.Shape;
import shapes.line.Line;
import shapes.line.RemoveLine;
import shapes.line.UpdateLine;
import shapes.point.Point;
import shapes.point.RemovePoint;
import shapes.point.UpdatePoint;
import util.DialogsHelper;
import util.Logger;
import util.UndoRedoHelper;
import util.modifyDialogs.LineModifyDialog;
import util.modifyDialogs.PointModifyDialog;

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
		frame.repaint();
	}

	/**
	 * Will handle event of clicking redo button
	 */
	public void handleRedoBtn() {
		UndoRedoHelper.redoAction();
		frame.repaint();
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

	/**
	 * Returns selected shape from shape list
	 * 
	 * @return Shape
	 */
	private Shape getSelectedShape() {
		for (Shape s : model.getShapesList()) {
			if (s.isSelected())
				return s;
		}
		return null;
	}

	/**
	 * Will handle event of shape modify
	 */
	public void handleModify() {
		Shape selected = getSelectedShape();
		if (selected != null && selected instanceof Shape) {
			if (selected instanceof Point) {
				Point selectedPt = (Point) selected;
				PointModifyDialog modifyDialog = new PointModifyDialog(selectedPt);
				Point modifiedPt = modifyDialog.getPt();
				if (!selectedPt.equals(modifiedPt) || selectedPt.getColor() != modifiedPt.getColor()) {
					Command updatePt = new UpdatePoint(selectedPt, modifiedPt);
					ShapeModel.getUndoStack().offerLast(updatePt);
					updatePt.execute();
					frame.repaint();
				}
			} else if (selected instanceof Line) {
				Line selectedLine = (Line) selected;
				LineModifyDialog modifyDialog = new LineModifyDialog(selectedLine);
				Line modifiedLine = modifyDialog.getLine();
				if (!selectedLine.equals(modifiedLine) || selectedLine.getColor() != modifiedLine.getColor()) {
					Command updateLine = new UpdateLine(selectedLine, modifiedLine);
					ShapeModel.getUndoStack().offerLast(updateLine);
					updateLine.execute();
					frame.repaint();
				}
			}
		}
	}

	/**
	 * Will check if there are any selected shapes in list and delete them
	 */
	public void handleDelete() {
		ArrayList<Shape> shapesToDelete = new ArrayList<Shape>();
		for (Shape s : model.getShapesList()) {
			if (s.isSelected())
				shapesToDelete.add(s);
		}
		if (shapesToDelete.size() == 0)
			return;
		else if (shapesToDelete.size() == 1) {

			Command removeCmd = null;
			Boolean confirmed = false;
			// Detect what kind of shape is to be deleted
			if (shapesToDelete.get(0) instanceof Point) {
				removeCmd = new RemovePoint(model, (Point) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Point.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Line) {
				removeCmd = new RemoveLine(model, (Line) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Line.class.getSimpleName() + "?");
			}

			// If user confirmed popup (JOptionPane)
			if (confirmed) {
				shapesToDelete.get(0).setSelected(false);
				ShapeModel.getUndoStack().offerLast(removeCmd);
				removeCmd.execute();
				frame.repaint();
			}

		} else { // Will get to else if there are more than 1 shapes to remove

			if (DialogsHelper.askUserToConfirm(String.format(
					"You selected %d shapes, are you sure you want to delete them all?", shapesToDelete.size()))) {
				Command removeCmd = null;
				for (Shape s : shapesToDelete) {
					s.setSelected(false); // Fix UNDO getting selected shape
					if (s instanceof Point) {
						removeCmd = new RemovePoint(model, (Point) s);
					} else if (s instanceof Line) {
						removeCmd = new RemoveLine(model, (Line) s);
					}

					ShapeModel.getUndoStack().offerLast(removeCmd);
					removeCmd.execute();
				}
				frame.repaint();
			}
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
	 * Will set background color of button based on chosen color in JColorChooser If
	 * color is not chosen, it will return current color
	 * 
	 * @param btn
	 */
	public void handleColorButtonClick(JButton btn) {
		Color newColor = JColorChooser.showDialog(btn, "Choose color", btn.getBackground());
		btn.setBackground((newColor != null) ? newColor : btn.getBackground());
	}
}
