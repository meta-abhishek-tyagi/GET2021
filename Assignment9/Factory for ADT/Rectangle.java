package Assignment9;

import java.util.Date;
import java.util.List;
public class Rectangle implements Shape {
   int width, height;
   Point coordinates;
   String timestamp;
   int shapeId;
	
  /*Constructor takes two argument 
    1. point object(Screen coordinates)
    2. list object(Parameter of shapes) */ 
   public Rectangle(Point point, List<Integer> list) {
      coordinates = new Point(point.getX(), point.getY());
      width = list.get(0);
      height = list.get(1);
      timestamp = new Date().toString();
   }
	
   //setters
   @Override
   public void setId(int shapeId) {
      this.shapeId = shapeId;	
   }
	
   //getters
   @Override
   public Point getOrigin() {
      return coordinates;
   }
   @Override
   public String getTimestamp() {
      return timestamp;
   }
   @Override
   public int getId() {
      return shapeId;
   }
	
   //return area of rectangle 
   @Override
   public double getArea() {
      return width * height;
   }
	
   //return parameter of rectangle 
   @Override
   public double getPerimeter() {
      return 2*(width+height);
   }

   @Override
   public boolean isPointEnclosed(Point point) {
      if(point.getX() > coordinates.getX() &&	point.getX() < coordinates.getX() + width && point.getY() > coordinates.getY() && point.getY() < coordinates.getY() + height)
	return true;
      return false;
   }
}
