/**
 * Code for Circle.
 * @author Hao Wang (haow2)
 */
// import java.text.DecimalFormat;
/**
* Circle class.
*/
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;

    /**
     * Constructor to create Circle with radius.
     * @param newRadius radius value of circle
     */
    public Circle(double newRadius) {
        super();
        radius = newRadius;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getPerimeter() {
        return Math.PI * radius * 2.0;
    }

    /**
     * Returns radius value of a Circle object.
     * @return double radius value
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Returns String representation of Circle object.
     * @return String representation of Circle object.
     */
    @Override
    public String toString() {
        // String areaStr = new DecimalFormat("#.000").format(getArea());
        // String perimeterStr = new DecimalFormat("#.000").format(getPerimeter());
        String areaStr = String.format("%.3f", getArea());
        String perimeterStr = String.format("%.3f", getPerimeter());
        return "Circle " + areaStr + " " + perimeterStr;
    }
}
