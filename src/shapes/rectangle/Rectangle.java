package shapes.rectangle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.line.Line;
import shapes.point.Point;
import shapes.square.Square;

public class Rectangle extends Square {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7876647484668688482L;

	// Defining only width, sideLength(from Square) will be used for height
	private int width;

	public Rectangle(Point upperLeft, int height, int width) {
		super(upperLeft, height);
		this.width = width;
	}

	public Rectangle(Point upperLeft, int height, int width, Color outerColor) {
		this(upperLeft, height, width);
		setColor(outerColor);
	}

	public Rectangle(Point upperLeft, int height, int width, Color outerColor, Color innerColor) {
		this(upperLeft, height, width, outerColor);
		setInnerColor(innerColor);
	}

	@Override
	public Line diagonal() {
		return new Line(upperLeft, new Point(upperLeft.getX() + sideLength, upperLeft.getY() + width));
	}

	@Override
	public Point center() {
		return diagonal().lineCenter();
	}

	@Override
	public int surfaceArea() {
		return width * sideLength;
	}

	@Override
	public int volume() {
		return 2 * (width + sideLength);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle castedObj = (Rectangle) obj;
			return upperLeft.equals(castedObj.getUpperLeft()) && width == castedObj.getWidth()
					&& sideLength == castedObj.getSideLength();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Rectangle(UpperX=%d,UpperY=%d,height=%d,width=%d,outercolor=%s,innercolor=%s)",
				upperLeft.getX(), upperLeft.getY(), sideLength, width, getColor(), getInnerColor());
	}

	@Override
	public boolean contains(int x, int y) {
		return upperLeft.getX() <= x && x <= (upperLeft.getX() + sideLength) && upperLeft.getY() <= y
				&& y <= (upperLeft.getY() + width);
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, sideLength - 1, width - 1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeft.getX(), upperLeft.getY(), sideLength, width);
		if (isSelected())
			selected(g);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
