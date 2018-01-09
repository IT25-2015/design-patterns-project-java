package playground;

import logparser.ShapeParser;

public class ShapesPlayground {

	public static void main(String[] args) {
		ShapeParser.getInstance().parsePointProperties("ADDPOINT_EXECUTE_sid=0_Point(x=60,y=64,color=java.awt.Color[r=0,g=0,b=0])");
	}

}
