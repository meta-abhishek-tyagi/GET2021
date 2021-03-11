package Assignment9;

public class Point {
    private int xCoordinate;
    private int yCoordinate;

	//Constructor
	Point(int xCoordinate, int yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	//getters
	int getX(){
		return xCoordinate;
	}
	int getY(){
		return yCoordinate;
	}
}
