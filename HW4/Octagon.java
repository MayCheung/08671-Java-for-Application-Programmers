/**
 * Code for Octagon.
 * @author Hao Wang (haow2)
 */
// import java.text.DecimalFormat;
/**
* Octagon class.
*/
public class Octagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor of Octagon with side parameter.
     * @param newSide side
     */
    public Octagon(double newSide) {
        super();
        side = newSide;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return (2.0 + 2.0 * Math.sqrt(2.0)) * side * side;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getPerimeter() {
        return 8.0 * side;
    }

    /**
     * Returns side value of Octagon object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Octagon object.
     * @return String representation of Octagon object
     */
    @Override
    public String toString() {
        // String areaStr = new DecimalFormat("#.000").format(getArea());
        // String perimeterStr = new DecimalFormat("#.000").format(getPerimeter());
        String areaStr = String.format("%.3f", getArea());
        String perimeterStr = String.format("%.3f", getPerimeter());
        return "Octagon " + areaStr + " " + perimeterStr;
    }
}
