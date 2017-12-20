package Shapes;

import java.awt.Color;
import java.awt.Graphics;

import lombok.Getter;
import lombok.Setter;

public class Point extends Shape implements Moveable{
	private @Getter @Setter int x;
	private @Getter @Setter int y;
	
	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Color color) {
		this(x, y);
		setColor(color);
	}

	@Override
	public int compareTo(Shape o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selected(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveFor(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
