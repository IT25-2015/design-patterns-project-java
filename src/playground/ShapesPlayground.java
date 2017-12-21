package playground;

import java.awt.Color;

import shapes.point.Point;

public class ShapesPlayground {

	public static void main(String[] args) {
		Point pt = new Point(1, 2, Color.BLACK);
		pt.setX(2);
		System.out.println(pt.getX());
		System.out.println(pt);
	}

}
