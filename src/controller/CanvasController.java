package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import javax.swing.ButtonModel;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.point.AddPoint;
import shapes.point.Point;

public class CanvasController implements Serializable {
	private ButtonModel selectedShapeTypeModel;
	private ButtonModel pointModel;
	private ButtonModel lineModel;
	private Point startDrawingPoint;

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
	}

	public void handleCanvasClick(MouseEvent e, Color inner, Color outer) {

		selectedShapeTypeModel = frame.getShapePickerView().getShapesGrp().getSelection();

		if (selectedShapeTypeModel == pointModel) {
			Command point = new AddPoint(model, new Point(e.getX(), e.getY(), outer));
			point.execute();
			ShapeModel.getUndoStack().offerLast(point);
			frame.repaint();
		} else if (selectedShapeTypeModel == lineModel) {
			if (startDrawingPoint == null) {
				startDrawingPoint = new Point(e.getX(), e.getY(), outer);
			}
			System.out.println("Line!");
		}
	}

	public void handleCanvasDrag(MouseEvent e, Color inner, Color outer) {
		if (selectedShapeTypeModel == lineModel && startDrawingPoint != null) {
			//model.add(new Line(startDrawingPoint, new Point(e.getX(),e.getY(),outer)));
		}
	}
}
