/**
 * Code for Rectangle.
 * @author Hao Wang (haow2)
 */
// import java.text.DecimalFormat;
/**
* Rectangle class.
*/
public class Rectangle extends Shape {
    /**
    * Instance variable for width.
    */
    private double width;
    /**
    * Instance variable for height.
    */
    private double height;

    /**
     * Constructor with width and height.
     * @param newWidth width value
     * @param newHeight height value
     */
    public Rectangle(double newWidth, double newHeight) {
        super();
        width = newWidth;
        height = newHeight;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return width * height;
    }

    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getPerimeter() {
        return (width + height) * 2.0;
    }

    /**
     * Returns width value of rectangle object.
     * @return width value in double
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height value of rectangle object.
     * @return height value in double
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns Spring representation of rectangle object.
     * @return String representation of rectangle object
     */
    @Override
    public String toString() {
        // String areaStr = new DecimalFormat("#.000").format(getArea());
        // String perimeterStr = new DecimalFormat("#.000").format(getPerimeter());
        String areaStr = String.format("%.3f", getArea());
        String perimeterStr = String.format("%.3f", getPerimeter());
        return "Rectangle " + areaStr + " " + perimeterStr;
    }
}
