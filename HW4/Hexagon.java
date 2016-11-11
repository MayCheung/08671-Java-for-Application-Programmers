/**
 * Code for Hexagon.
 * @author Hao Wang (haow2)
 */
// import java.text.DecimalFormat;
/**
* Hexagon class.
*/
public class Hexagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor of Hexagon with side parameter.
     * @param newSide side
     */
    public Hexagon(double newSide) {
        super();
        side = newSide;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return Math.sqrt(3.0) * 3.0 / 2.0 * side * side;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getPerimeter() {
        return 6.0 * side;
    }

    /**
     * Returns side value of Hexagon object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Hexagon object.
     * @return String representation of Hexagon object
     */
    @Override
    public String toString() {
        // String areaStr = new DecimalFormat("#.000").format(getArea());
        // String perimeterStr = new DecimalFormat("#.000").format(getPerimeter());
        String areaStr = String.format("%.3f", getArea());
        String perimeterStr = String.format("%.3f", getPerimeter());
        return "Hexagon " + areaStr + " " + perimeterStr;
    }
}
