package view;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import model.ShapeModel;
import shapes.Shape;
import shapes.SurfaceShape;
import shapes.circle.Circle;

@SuppressWarnings("serial")
public class CanvasView extends JPanel {
	public CanvasView() {
	}

	private ShapeModel model;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			Iterator<Shape> it = model.getShapesList().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}
		}
	}

	public void setModel(ShapeModel model) {
		this.model = model;
	}
}
