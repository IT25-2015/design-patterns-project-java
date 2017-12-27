package shapes.point;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Moveable;
import shapes.Shape;
import shapes.ShapeObserver;

@SuppressWarnings("serial")
public class Point extends Shape implements Moveable {
	private int x;
	private int y;
	private ShapeObserver observer;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	public Point(int x, int y, Color color) {
		this(x, y);
		setColor(color);
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	/**
	 * Returns distance of given point and this point
	 * 
	 * @param pt
	 * @return distance
	 */
	public double distance(Point pt) {
		double dx = x - pt.getX();
		double dy = y - pt.getY();
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	@Override
	public int compareTo(Shape o) {
		Point coordinateStart = new Point(0, 0);
		Point newPt = (Point) o;
		return (int) (this.distance(coordinateStart) - newPt.distance(coordinateStart));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point castedObj = (Point) obj;
			return x == castedObj.getX() && y == castedObj.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Point(x=%d,y=%d,color=%s)", x, y, getColor());
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		if (isSelected()) {
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x - 3, y - 3, 6, 6);
	}

	@Override
	public boolean contains(int x, int y) {
		Point click = new Point(x, y);
		return click.distance(this) <= 2;
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveFor(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
