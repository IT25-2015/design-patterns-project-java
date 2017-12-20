package View;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import Model.ShapeModel;
import lombok.Setter;
import shapes.Shape;

@SuppressWarnings("serial")
public class DrawingView extends JPanel {
	private @Setter ShapeModel model;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			Iterator<Shape> it = model.getShapesList().iterator();
			while (it.hasNext()) {
				it.next().draw(g);
			}
		}
		repaint();
	}
}
