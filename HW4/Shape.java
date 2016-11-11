/**
 * Code for Shape.
 * @author Hao Wang (haow2)
 */
public abstract class Shape {
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
     */
    public Shape() { }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public abstract double getArea();

    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public abstract double getPerimeter();
}
