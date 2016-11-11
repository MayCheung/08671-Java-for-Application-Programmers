/**
 * Test Code
 * @author Hao Wang (haow2)
 */
public class ShapeTest {
    /**
     * Demo code to test different shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c);

        Rectangle r = new Rectangle(5, 3);
        System.out.println(r);

        Square s = new Square(3);
        System.out.println(s);
        System.out.println(s.getWidth());
        System.out.println(s.getHeight());
        System.out.println(s.getArea());
        System.out.println(s.getPerimeter());
    }
}