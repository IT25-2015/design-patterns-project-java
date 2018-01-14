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
import shapes.circle.Circle;
import shapes.circle.RemoveCircle;
import shapes.circle.UpdateCircle;
import shapes.hexagon.HexagonAdapter;
import shapes.hexagon.RemoveHexagonAdapter;
import shapes.hexagon.UpdateHexagonAdapter;
import shapes.line.Line;
import shapes.line.RemoveLine;
import shapes.line.UpdateLine;
import shapes.point.Point;
import shapes.point.RemovePoint;
import shapes.point.UpdatePoint;
import shapes.rectangle.Rectangle;
import shapes.rectangle.RemoveRectangle;
import shapes.rectangle.UpdateRectangle;
import shapes.square.RemoveSquare;
import shapes.square.Square;
import shapes.square.UpdateSquare;
import util.DialogsHelper;
import util.Logger;
import util.UndoRedoHelper;
import util.modifyDialogs.CircleModifyDialog;
import util.modifyDialogs.HexagonModifyDialog;
import util.modifyDialogs.LineModifyDialog;
import util.modifyDialogs.PointModifyDialog;
import util.modifyDialogs.RectangleModifyDialog;
import util.modifyDialogs.SquareModifyDialog;

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
		if (!frame.getHeaderWrapperView().getToolboxView().getTglBtnSelect().isEnabled())
			return;

		boolean shapeFound = false;
		for (int i = model.getShapesList().size() - 1; i >= 0; i--) {
			Shape s = model.getShapesList().get(i);
			if (s.contains(e.getX(), e.getY()) && !s.isSelected()) {
				s.setSelected(true);
				Logger.getInstance().log("[INFO] SELECTED", s.toString(), true);
				frame.repaint();
				shapeFound = true;
				break;
			}
		}
		if (!shapeFound) {
			Logger.getInstance().log(String.format("No shapes found at location (%d,%d)", e.getX(), e.getY()), true,
					true);
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
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnModify().isEnabled())
			return;

		Shape selected = getSelectedShape();
		if (selected != null && selected instanceof Shape) {
			if (selected instanceof Point) {
				Point selectedPt = (Point) selected;
				PointModifyDialog modifyDialog = new PointModifyDialog(selectedPt);
				Point modifiedPt = modifyDialog.getPt();
				if (!selectedPt.equals(modifiedPt) || selectedPt.getColor() != modifiedPt.getColor()) {
					Command updatePt = new UpdatePoint(selectedPt, modifiedPt, model.getShapeIndex(selectedPt));
					ShapeModel.getUndoStack().offerLast(updatePt);
					updatePt.execute();
					frame.repaint();
				}
			} else if (selected instanceof Line) {
				Line selectedLine = (Line) selected;
				LineModifyDialog modifyDialog = new LineModifyDialog(selectedLine);
				Line modifiedLine = modifyDialog.getLine();
				if (!selectedLine.equals(modifiedLine) || selectedLine.getColor() != modifiedLine.getColor()) {
					Command updateLine = new UpdateLine(selectedLine, modifiedLine, model.getShapeIndex(selectedLine));
					ShapeModel.getUndoStack().offerLast(updateLine);
					updateLine.execute();
					frame.repaint();
				}
			} else if (selected instanceof Circle) {
				Circle selectedCircle = (Circle) selected;
				CircleModifyDialog modifyDialog = new CircleModifyDialog(selectedCircle);
				Circle modifiedCircle = modifyDialog.getCircle();
				if (!selectedCircle.equals(modifiedCircle) || selectedCircle.getColor() != modifiedCircle.getColor()
						|| selectedCircle.getInnerColor() != modifiedCircle.getInnerColor()) {
					Command updateCircle = new UpdateCircle(selectedCircle, modifiedCircle,
							model.getShapeIndex(selectedCircle));
					ShapeModel.getUndoStack().offerLast(updateCircle);
					updateCircle.execute();
					frame.repaint();
				}
			} else if (selected instanceof Rectangle) {
				Rectangle selectedRectangle = (Rectangle) selected;
				RectangleModifyDialog modifyDialog = new RectangleModifyDialog(selectedRectangle);
				Rectangle modifiedRectangle = modifyDialog.getRectangle();
				if (!selectedRectangle.equals(modifiedRectangle)
						|| selectedRectangle.getColor() != modifiedRectangle.getColor()
						|| selectedRectangle.getInnerColor() != modifiedRectangle.getInnerColor()) {
					Command updateRectangle = new UpdateRectangle(selectedRectangle, modifiedRectangle,
							model.getShapeIndex(selectedRectangle));
					ShapeModel.getUndoStack().offerLast(updateRectangle);
					updateRectangle.execute();
					frame.repaint();
				}

			} else if (selected instanceof Square) {
				Square selectedSquare = (Square) selected;
				SquareModifyDialog modifyDialog = new SquareModifyDialog(selectedSquare);
				Square modifiedSquare = modifyDialog.getSquare();
				if (!selectedSquare.equals(modifiedSquare) || selectedSquare.getColor() != modifiedSquare.getColor()
						|| selectedSquare.getInnerColor() != modifiedSquare.getInnerColor()) {
					Command updateSquare = new UpdateSquare(selectedSquare, modifiedSquare,
							model.getShapeIndex(selectedSquare));
					ShapeModel.getUndoStack().offerLast(updateSquare);
					updateSquare.execute();
					frame.repaint();
				}
			} else if (selected instanceof HexagonAdapter) {
				HexagonAdapter selectedHexagon = (HexagonAdapter) selected;
				HexagonModifyDialog modifyDialog = new HexagonModifyDialog(selectedHexagon);
				HexagonAdapter modifiedHexagonAdapter = modifyDialog.getHexagonAdapter();
				if (!selectedHexagon.equals(modifiedHexagonAdapter)
						|| selectedHexagon.getColor() != modifiedHexagonAdapter.getColor()
						|| selectedHexagon.getInnerColor() != modifiedHexagonAdapter.getInnerColor()) {
					Command updateHexagonAdapter = new UpdateHexagonAdapter(selectedHexagon, modifiedHexagonAdapter,
							model.getShapeIndex(selectedHexagon));
					ShapeModel.getUndoStack().offerLast(updateHexagonAdapter);
					updateHexagonAdapter.execute();
					frame.repaint();
				}
			}
		}
	}

	/**
	 * Will check if there are any selected shapes in list and delete them
	 */
	public void handleDelete() {
		if (!frame.getHeaderWrapperView().getToolboxView().getBtnDelete().isEnabled())
			return;

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
			} else if (shapesToDelete.get(0) instanceof Circle) {
				removeCmd = new RemoveCircle(model, (Circle) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Circle.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Rectangle) {
				removeCmd = new RemoveRectangle(model, (Rectangle) shapesToDelete.get(0));
				confirmed = DialogsHelper.askUserToConfirm(
						"Are you sure you want to remove this " + Rectangle.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof Square) {
				removeCmd = new RemoveSquare(model, (Square) shapesToDelete.get(0));
				confirmed = DialogsHelper
						.askUserToConfirm("Are you sure you want to remove this " + Square.class.getSimpleName() + "?");
			} else if (shapesToDelete.get(0) instanceof HexagonAdapter) {
				removeCmd = new RemoveHexagonAdapter(model, (HexagonAdapter) shapesToDelete.get(0));
				confirmed = DialogsHelper.askUserToConfirm("Are you sure you want to remove this "
						+ ((HexagonAdapter) shapesToDelete.get(0)).getHexagon().getClass().getSimpleName() + "?");
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
					} else if (s instanceof Circle) {
						removeCmd = new RemoveCircle(model, (Circle) s);
					} else if (s instanceof Rectangle) {
						removeCmd = new RemoveRectangle(model, (Rectangle) s);
					} else if (s instanceof Square) {
						removeCmd = new RemoveSquare(model, (Square) s);
					} else if (s instanceof HexagonAdapter) {
						removeCmd = new RemoveHexagonAdapter(model, (HexagonAdapter) s);
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
			Logger.getInstance().log("Entering select mode", true, true);
		} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
			Logger.getInstance().log("Exiting select mode", true, true);
			for (Shape s : model.getShapesList()) {
				s.setSelected(false);
				frame.repaint();
			}
			Logger.getInstance().log("All shapes have been de-selected", true, true);
		}
	}

	/**
	 * Will set background color of button based on chosen color in JColorChooser If
	 * color is not chosen, it will return current color
	 * 
	 * @param btn
	 */
	public void handleColorButtonClick(JButton btn) {
		if (!btn.isEnabled())
			return;

		Color newColor = JColorChooser.showDialog(btn, "Choose color", btn.getBackground());
		btn.setBackground((newColor != null) ? newColor : btn.getBackground());
	}

	/**
	 * Will disable Inner Color button if point or line is selected, because they
	 * don't have inner color
	 */
	public void handleShapePickerChange() {
		boolean isPointActive = frame.getShapePickerView().getRdbtnPoint().isSelected();
		boolean isLineActive = frame.getShapePickerView().getRdbtnLine().isSelected();
		if (isLineActive || isPointActive) {
			frame.getHeaderWrapperView().getToolboxView().getBtnInnerColor().setEnabled(false);
			frame.repaint();
		} else {
			frame.getHeaderWrapperView().getToolboxView().getBtnInnerColor().setEnabled(true);
		}

	}
}
