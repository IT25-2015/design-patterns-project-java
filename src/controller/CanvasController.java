package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ButtonModel;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.Shape;
import shapes.circle.AddCircle;
import shapes.circle.Circle;
import shapes.line.AddLine;
import shapes.line.Line;
import shapes.point.AddPoint;
import shapes.point.Point;
import shapes.square.AddSquare;
import shapes.square.Square;

public class CanvasController implements Serializable {
	private ButtonModel selectedShapeTypeModel;
	private ButtonModel pointModel;
	private ButtonModel lineModel;
	private ButtonModel circleModel;
	private ButtonModel squareModel;
	private Point startDrawingPoint;
	private Shape draggedShape;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7683586572386187582L;
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;

		// Get models for shape buttons
		pointModel = frame.getShapePickerView().getRdbtnPoint().getModel();
		lineModel = frame.getShapePickerView().getRdbtnLine().getModel();
		circleModel = frame.getShapePickerView().getRdbtnCircle().getModel();
		squareModel = frame.getShapePickerView().getRdbtnSquare().getModel();
	}

	/**
	 * Will get called when MousePressed event happened If point is selected it will
	 * draw it and do all other things (Add to UndoStack, repaint, etc) If other
	 * shapes are selected, it will set starting point of shape
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasClick(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		if (selectedShapeTypeModel == pointModel) {
			Command point = new AddPoint(model, new Point(e.getX(), e.getY(), outer));
			point.execute();
			ShapeModel.getUndoStack().offerLast(point);
			frame.repaint();
		} else {
			if (startDrawingPoint == null) {
				startDrawingPoint = new Point(e.getX(), e.getY());
			} else {
				startDrawingPoint = null;
			}
		}
	}

	/**
	 * Will get called when MouseDragged event happened Will draw new shape while
	 * mouse is dragged (Something like preview of final shape)
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasDrag(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		if (draggedShape != null) {
			model.remove(draggedShape);
			draggedShape = null;
		}
		if (startDrawingPoint == null) {
			startDrawingPoint = new Point(e.getX(), e.getY());
		}
		if (selectedShapeTypeModel == lineModel && startDrawingPoint != null) {
			draggedShape = new Line(startDrawingPoint, new Point(e.getX(), e.getY()), outer);
			model.add(draggedShape);
			frame.repaint();
		} else if (selectedShapeTypeModel == circleModel && startDrawingPoint != null) {
			int startR = Math.abs(startDrawingPoint.getY() - e.getY()); // calculate r for circle
			draggedShape = new Circle(startDrawingPoint, startR, outer, inner);
			model.add(draggedShape);
			frame.repaint();
		} else if (selectedShapeTypeModel == squareModel && startDrawingPoint != null) {
			int startSide = Math.abs(startDrawingPoint.getY() - e.getY());
			draggedShape = new Square(startDrawingPoint, startSide, outer, inner);
			model.add(draggedShape);
			frame.repaint();
		}
	}

	/**
	 * Will draw final shape when mouse is released (MouseReleased event) Order of
	 * events MousePressed -> MouseDragged -> MouseReleased
	 * 
	 * @param e
	 * @param inner
	 * @param outer
	 */
	public void handleCanvasRelease(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		// Make sure that we have both starting point and dragged shape
		if (startDrawingPoint != null && draggedShape != null) {
			// Remove preview shape
			model.remove(draggedShape);
			frame.repaint();
			// Check what shape is selected
			if (selectedShapeTypeModel == lineModel) {
				// Create new command, execute it, add it to undo stack
				Command addLine = new AddLine(model, (Line) draggedShape);
				addLine.execute();
				ShapeModel.getUndoStack().offerLast(addLine);

			} else if (selectedShapeTypeModel == circleModel) {
				Command addCircle = new AddCircle(model, (Circle) draggedShape);
				addCircle.execute();
				ShapeModel.getUndoStack().offerLast(addCircle);
			} else if (selectedShapeTypeModel == squareModel) {
				Command addSquare = new AddSquare(model, (Square) draggedShape);
				addSquare.execute();
				ShapeModel.getUndoStack().offerLast(addSquare);
			}
			// re-draw frame
			frame.repaint();
			// Reset to null so we can draw new shape
			startDrawingPoint = null;
			draggedShape = null;
		}
	}
}
