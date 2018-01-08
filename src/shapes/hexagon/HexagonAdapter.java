package shapes.hexagon;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Moveable;
import shapes.Shape;
import shapes.ShapeObserver;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape implements Moveable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2512401536592276622L;
	private Hexagon hexagon;
	private ShapeObserver observer;

	public HexagonAdapter(Hexagon hexagon) {
		this.hexagon = hexagon;
		observer = new ShapeObserver();
		observer.setShape(this);
		addObserver(observer);
	}

	public HexagonAdapter(Hexagon hexagon, Color color) {
		this(hexagon);
		setColor(color);
	}

	public HexagonAdapter(Hexagon hexagon, Color outerColor, Color innerColor) {
		this(hexagon, outerColor);
		setInnerColor(innerColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HexagonAdapter) {
			Hexagon hexaFromObj = ((HexagonAdapter) obj).getHexagon();
			return hexagon.getX() == hexaFromObj.getX() && hexagon.getY() == hexaFromObj.getY()
					&& hexagon.getR() == hexaFromObj.getR();
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Hexagon(X=%d,Y=%d,r=%d,outercolor=%s,innercolor=%s)", hexagon.getX(), hexagon.getY(),
				hexagon.getR(), getColor(), getInnerColor());
	}

	@Override
	public int compareTo(Shape o) {
		if (o instanceof HexagonAdapter) {
			return hexagon.getR() - ((HexagonAdapter) o).getHexagon().getR();
		}
		return 0;
	}

	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}

	@Override
	public void setSelected(boolean selected) {
		hexagon.setSelected(selected);
		super.setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

	@Override
	public void fill(Graphics g) {
		// Do nothing, paint is already doing fill
	}

	@Override
	public void selected(Graphics g) {
		// Do nothing, paint is already selecting shape if needed

	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void moveTo(int x, int y) {
		hexagon.setX(x);
		hexagon.setY(y);

	}

	@Override
	public void moveFor(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	@Override
	public void setInnerColor(Color innerColor) {
		hexagon.setAreaColor(innerColor);
		super.setInnerColor(innerColor);
	}

	@Override
	public Color getInnerColor() {
		return hexagon.getAreaColor();
	}

	@Override
	public void setColor(Color color) {
		hexagon.setBorderColor(color);
		super.setColor(color);
	}

	@Override
	public Color getColor() {
		return hexagon.getBorderColor();
	}
}
