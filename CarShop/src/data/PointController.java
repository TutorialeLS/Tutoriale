package data;
public class PointController {
	public void addX(Point point){
	point.setX(point.getX() + 1);	
	}
	public  void minuX(Point point){
		point.setX(point.getX() - 1);	
	}
	public  void addY(Point point){
		point.setY(point.getY() + 1);
	}
	public  void minuY(Point point){
		point.setY(point.getY() - 1);
	}
}
