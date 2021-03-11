package Assignment9;

public interface Shape {
	double PI = 3.14;
	enum shapeTypes { CIRCLE, RECTANGLE, SQUARE, TRIANGLE } 
	
	//assign the id to the shape
	void setId(int shapeId); 
	
	//return the area of the shape
	double getArea(); 
	
	//return parameter of the shape
	double getPerimeter(); 
	
	//return the id of the shape
	int getId(); 
	
	//return the origin of the shape
	Point getOrigin(); 
	
	//return the timestamp of the shape
	String getTimestamp(); 
	
	//check weather the point is inside the shape or not
	boolean isPointEnclosed(Point point);  
}