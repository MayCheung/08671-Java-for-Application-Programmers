/**
 * Code for Shape.
 * @author Hao Wang (haow2)
 */
public class Shape {
    /**
    * Instance variable for area.
    */
    private double area;
    /**
    * Instance variable for perimeter.
    */
    private double perimeter;

    /**
     * Constructor with area parameter.
     * @param newArea area
     * @param newPerimeter perimeter
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Returns String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        String areaStr = String.format("%.3f", area);
        String perimeterStr = String.format("%.3f", perimeter);
        return "Shape " + areaStr + " " + perimeterStr;
    }
}
