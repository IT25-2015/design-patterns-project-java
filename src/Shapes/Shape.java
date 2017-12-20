package Shapes;

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

	public abstract void draw(Graphics g);

	public abstract void selected(Graphics g);

	public abstract boolean contains(int x, int y);

}
