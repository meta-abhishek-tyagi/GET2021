package Assignment9;

import java.util.List;
public class ShapeFactory {
	/*Factory method that return desired shape object, takes three arguments
	  1.shapeType of type string
	  2.Point will specify either starting point of the shape or center point
	  3.list of integers will display other parameters of the shape like for square only width,
        circle only radius, rectangle length and breadth, so on.
   */
	Shape createShape(String shapeType, Point point, List<Integer> list){
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.CIRCLE)
			return new Circle(point, list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.TRIANGLE)
			return new Triangle(point, list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.SQUARE)
			return new Square(point, list);
		if(Shape.shapeTypes.valueOf(shapeType.toUpperCase()) == Shape.shapeTypes.RECTANGLE)
			return new Rectangle(point, list);
		return null;
	}
}