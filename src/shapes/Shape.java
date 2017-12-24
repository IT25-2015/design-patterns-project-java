package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Observable;

@SuppressWarnings("serial")
public abstract class Shape extends Observable implements Comparable<Shape>, Serializable {

	private Color color = Color.BLACK;
	private boolean selected;

	public Shape() {
	}

	public Shape(Color color) {
		this.color = color;
	}

	/**
	 * Draws shape
	 * 
	 * @param g
	 */
	public abstract void draw(Graphics g);

	/**
	 * Draws selected shape animation
	 * 
	 * @param g
	 */
	public abstract void selected(Graphics g);

	/**
	 * Checks if shape is contained within given x,y coordinates
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public abstract boolean contains(int x, int y);

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		setChanged();
		notifyObservers();
		
	}

}
