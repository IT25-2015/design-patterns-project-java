package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.Serializable;

import app.MainFrame;
import model.ShapeModel;
import shapes.Command;
import shapes.point.AddPoint;
import shapes.point.Point;

public class CanvasController implements Serializable {
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;
	}

	public void handleCanvasClick(MouseEvent e) {
		// TODO Implement handle of this event
		Command point = new AddPoint(model, new Point(e.getX(), e.getY(), Color.RED));
		point.execute();
		ShapeModel.getUndoStack().offerLast(point);
	}
}
