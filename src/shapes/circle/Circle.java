package shapes.circle;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Moveable;
import shapes.Shape;
import shapes.ShapeObserver;
import shapes.SurfaceShape;
import shapes.line.Line;
import shapes.point.Point;

public class Circle extends SurfaceShape implements Moveable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5510713369353881462L;
	private Point center;
	private int r;
	private ShapeObserver observer;

	public Circle() {
	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	public Circle(Point center, int r, Color color) {
		this(center, r);
		setColor(color);
	}

	public Circle(Point center, int r, Color outerColor, Color innerColor) {
		this(center, r, outerColor);
		setInnerColor(innerColor);
	}

	/**
	 * Will calculate surface area of circle
	 * @return
	 */
	public double surfaceArea() {
		return Math.pow(r, 2) * Math.PI;
	}

	/**
	 * Will calculate volume of circle
	 * @return
	 */
	public double volume() {
		return 2 * r * Math.PI;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle castedObj = (Circle) obj;
			return center.equals(castedObj.getCenter()) && r == castedObj.getR();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Circle(X=%d,Y=%d,r=%d,outercolor=%s,innercolor=%s)", center.getX(), center.getY(), r,
				getColor(), getInnerColor());
	}

	@Override
	public int compareTo(Shape o) {
		if (o instanceof Circle) {
			Circle castedObj = (Circle) o;
			return r - castedObj.getR();
		}
		return 0;
	}

	@Override
	public void moveTo(int x, int y) {
		center.setX(x);
		center.setY(y);
	}

	@Override
	public void moveFor(int x, int y) {
		center.setX(center.getX() + x);
		center.setY(center.getY() + y);
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(center.getX() - r + 1, center.getY() - r + 1, 2 * r - 2, r * 2 - 2);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r * 2);
		fill(g);
		if (isSelected())
			selected(g);
	}

	@Override
	public void selected(Graphics g) {
		new Line(new Point(center.getX(), center.getY() - r), new Point(center.getX(), center.getY() + r)).selected(g);
		new Line(new Point(center.getX() - r, center.getY()), new Point(center.getX() + r, center.getY())).selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		Point testPt = new Point(x, y);
		return testPt.distance(center) <= r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
