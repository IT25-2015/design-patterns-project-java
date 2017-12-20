package shapes;

import java.awt.Color;
import java.awt.Graphics;

import lombok.Getter;
import lombok.Setter;

public abstract class Shape implements Comparable<Shape> {

	private @Getter @Setter Color color = Color.BLACK;
	private @Getter @Setter boolean selected;

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

}
