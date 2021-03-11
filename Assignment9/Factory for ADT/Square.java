package Assignment9;

import java.util.Date;
import java.util.List;
public class Square implements Shape {
   int side;
   Point coordinates;
   String timestamp;
   int shapeId;
		
  /* Constructor takes two arguments 
     1. point object(Screen coordinates)
     2. list object(Parameter of shapes) */ 
	 
     public Square(Point point, List<Integer> list) {
	coordinates = new Point(point.getX(), point.getY());
	side = list.get(0);
	timestamp = new Date().toString();
     }
	
     //setters
     @Override
     public void setId(int shapeId) {
	this.shapeId = shapeId;	
     }
	
     //getters
     @Override
     public String getTimestamp() {
	return timestamp;
     }
     @Override
     public int getId() {
	return shapeId;
     }
     @Override
     public Point getOrigin() {
	return coordinates;
     }
	
     @Override
     public boolean isPointEnclosed(Point point) {
	if(point.getX() > coordinates.getX() &&	point.getX() < coordinates.getX() + side && point.getY() > coordinates.getY() && point.getY() < coordinates.getY() + side)
	   return true;
	return false;
     }
	
     //return area of square
     @Override
     public double getArea() {
	return side * side;
     }
	
     //return perimeter of square
     @Override
     public double getPerimeter() {
	return 4 * side;
     }
}	
