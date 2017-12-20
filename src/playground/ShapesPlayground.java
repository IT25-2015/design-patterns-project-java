package playground;

import java.awt.Color;

import Shapes.Point;

public class ShapesPlayground {

	public static void main(String[] args) {
		Point pt = new Point(1,2,Color.BLACK);
		pt.setX(null);
		System.out.println(pt.getX());
		System.out.println(pt);
	}

}
