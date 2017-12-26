package shapes.line;

import java.awt.Color;
import java.awt.Graphics;

import shapes.Shape;
import shapes.ShapeObserver;
import shapes.point.Point;

public class Line extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2677129039763167445L;
	private Point ptStart;
	private Point ptEnd;
	private ShapeObserver observer;

	public Line(Point ptStart, Point ptEnd) {
		this.ptStart = ptStart;
		this.ptEnd = ptEnd;
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	public Line(Point ptStart, Point ptEnd, Color color) {
		this(ptStart, ptEnd);
		setColor(color);
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	public Line() {
		
	}

	public Point lineCenter() {
		int centerX = (ptStart.getX() + ptEnd.getX()) / 2;
		int centerY = (ptStart.getY() + ptEnd.getY()) / 2;
		return new Point(centerX, centerY);
	}

	public double length() {
		return ptStart.distance(ptEnd);
	}

	@Override
	public String toString() {
		return String.format("Line(startX=%d,startY=%d,endX=%d,endY=%d,color=%s)", ptStart.getX(), ptStart.getY(),
				ptEnd.getX(), ptEnd.getY(), getColor());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line castedObj = (Line) obj;
			return ptStart.equals(castedObj.getPtStart()) && ptEnd.equals(castedObj.getPtEnd());
		}
		return false;
	}

	@Override
	public int compareTo(Shape shape) {
		if (shape instanceof Line) {
			Line castedShape = (Line) shape;
			return (int) this.length() - (int) castedShape.length();
		}
		return 0;
	}

	public void moveFor(int x, int y) {
		ptStart.setX(ptStart.getX() + x);
		ptStart.setY(ptStart.getY() + y);
		ptEnd.setX(ptEnd.getX() + x);
		ptEnd.setY(ptEnd.getY() + y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(ptStart.getX(), ptStart.getY(), ptEnd.getX(), ptEnd.getY());
		if (isSelected())
			selected(g);
	}

	@Override
	public void selected(Graphics g) {
		g.setColor(Color.BLUE);
		ptStart.selected(g);
		ptEnd.selected(g);
		lineCenter().selected(g);
	}

	@Override
	public boolean contains(int x, int y) {
		Point testPt = new Point(x, y);
		return (testPt.distance(ptStart) + testPt.distance(ptEnd) - length()) <= 0.5;
	}

	public Point getPtStart() {
		return ptStart;
	}

	public void setPtStart(Point ptStart) {
		this.ptStart = ptStart;
	}

	public Point getPtEnd() {
		return ptEnd;
	}

	public void setPtEnd(Point ptEnd) {
		this.ptEnd = ptEnd;
	}
}
