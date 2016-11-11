/**
 * Code for Square.
 * @author Hao Wang (haow2)
 */
// import java.text.DecimalFormat;
/**
* Square class.
*/
public class Square extends Rectangle {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor of Square with side parameter.
     * @param newSide side
     */
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }

    /**
     * Returns side value of Square object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }

    /**
     * Returns String representation of Square object.
     * @return String representation of Square object
     */
    @Override
    public String toString() {
        // String areaStr = new DecimalFormat("#.000").format(getArea());
        // String perimeterStr = new DecimalFormat("#.000").format(getPerimeter());
        String areaStr = String.format("%.3f", getArea());
        String perimeterStr = String.format("%.3f", getPerimeter());
        return "Square " + areaStr + " " + perimeterStr;
    }
}
