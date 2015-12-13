package utility;

import java.awt.Point;

public class Maths{
	public static double distance(Point p1, Point p2){
		return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
	}
	public static int random(int start, int end){
		return (int)(Math.random()*(end - start + 1));
	}
}
