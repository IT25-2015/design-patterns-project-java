package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;

import app.MainFrame;
import model.ShapeModel;
import shapes.point.Point;

public class CanvasController {
	private MainFrame frame;
	private ShapeModel model;

	public CanvasController(MainFrame frame, ShapeModel model) {
		this.frame = frame;
		this.model = model;
	}

	public void handleCanvasClick(MouseEvent e) {
		// TODO Implement handle of this event
		System.out.println(String.format("Clicked on canvas at - %d , %d", e.getX(), e.getY()));
		model.add(new Point(e.getX(), e.getY(), Color.RED));
	}
}
