package logic;

import data.Point;
import data.PointController;

public class PointApplication {

	public static void main(String[] args) {
		Point point = new Point(5,10);
		PointController pc=new PointController();
		System.out.println(point.getX());
		System.out.println(point.getY());
		pc.addX(point);
		System.out.println(point.getX());

	}

}
