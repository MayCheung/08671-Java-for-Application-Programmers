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
        super((2.0 + 2.0 * Math.sqrt(2.0)) * newSide * newSide, 8.0 * newSide);
        side = newSide;
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
        String areaStr = String.format("%.3f", super.getArea());
        String perimeterStr = String.format("%.3f", super.getPerimeter());
        return "Octagon " + areaStr + " " + perimeterStr;
    }
}
