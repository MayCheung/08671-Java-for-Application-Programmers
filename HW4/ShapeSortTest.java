/**
 * Shape Sort Test.
 * @author Hao Wang (haow2)
 */
public class ShapeSortTest {
    /**
     * Demo code to sort and test different shapes.
     * @param args arguments
     */
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        String[] names = new String[args.length];
        double[] areas = new double[args.length];
        double[] peris = new double[args.length];
        int[] r = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (s == null || s.length() == 0) {
                continue;
            }
            // System.out.println(s);

            int j = 0;
            while (j < s.length()) {
                char c = s.charAt(j);
                if (c >= '0' && c <= '9') {
                    break;
                }
                j++;
            }
            if (j == s.length()) {
                continue;
            }
            names[i] = s.substring(0, j);
            r[i] = Integer.parseInt(s.substring(j));
            if (names[i].equals("C")) {
                Circle cc = new Circle(r[i]);
                areas[i] = cc.getArea();
                peris[i] = cc.getPerimeter();
            } else if (names[i].equals("S")) {
                Square ss = new Square(r[i]);
                areas[i] = ss.getArea();
                peris[i] = ss.getPerimeter();
            } else if (names[i].equals("H")) {
                Hexagon hh = new Hexagon(r[i]);
                areas[i] = hh.getArea();
                peris[i] = hh.getPerimeter();
            } else if (names[i].equals("O")) {
                Octagon oo = new Octagon(r[i]);
                areas[i] = oo.getArea();
                peris[i] = oo.getPerimeter();
            }
            // System.out.println(names[i] + "\t" + areas[i] + "\t" + peris[i]);
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (areas[j] < areas[i]) {
                    String tempName = names[j];
                    double tempArea = areas[j];
                    double tempPeri = peris[j];
                    int tempR = r[j];
                    names[j] = names[i];
                    areas[j] = areas[i];
                    peris[j] = peris[i];
                    r[j] = r[i];
                    names[i] = tempName;
                    areas[i] = tempArea;
                    peris[i] = tempPeri;
                    r[i] = tempR;
                }
            }
        }

        for (int i = 0; i < args.length; i++) {
            String print = "";
            if (names[i].equals("C")) {
                Circle cc = new Circle(r[i]);
                print += cc.toString();
            } else if (names[i].equals("S")) {
                Square ss = new Square(r[i]);
                print += ss.toString();
            } else if (names[i].equals("H")) {
                Hexagon hh = new Hexagon(r[i]);
                print += hh.toString();
            } else if (names[i].equals("O")) {
                Octagon oo = new Octagon(r[i]);
                print += oo.toString();
            }
            System.out.println(print);
        }

        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (peris[j] > peris[i]) {
                    String tempName = names[j];
                    double tempArea = areas[j];
                    double tempPeri = peris[j];
                    int tempR = r[j];
                    names[j] = names[i];
                    areas[j] = areas[i];
                    peris[j] = peris[i];
                    r[j] = r[i];
                    names[i] = tempName;
                    areas[i] = tempArea;
                    peris[i] = tempPeri;
                    r[i] = tempR;
                }
            }
        }
        for (int i = 0; i < args.length; i++) {
            String print = "";
            if (names[i].equals("C")) {
                Circle cc = new Circle(r[i]);
                print += cc.toString();
            } else if (names[i].equals("S")) {
                Square ss = new Square(r[i]);
                print += ss.toString();
            } else if (names[i].equals("H")) {
                Hexagon hh = new Hexagon(r[i]);
                print += hh.toString();
            } else if (names[i].equals("O")) {
                Octagon oo = new Octagon(r[i]);
                print += oo.toString();
            }
            System.out.println(print);
        }
    }
}
