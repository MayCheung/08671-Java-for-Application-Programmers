/**
 * Homework 2: Compute Check Digits.
 * @author Hao Wang (haow2)
 * */
public class CheckDigit {
    /**
     * This method is the main method.
     * @param args is the input String array
     * */
 public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }
        long input = Long.parseLong(args[0]);
        long k = input % 10;
        input /= 10;
        long j = input % 10;
        input /= 10;
        long i = input % 10;
        input /= 10;
        long h = input % 10;
        input /= 10;
        long g = input % 10;
        input /= 10;
        long f = input % 10;
        input /= 10;
        long e = input % 10;
        input /= 10;
        long d = input % 10;
        input /= 10;
        long c = input % 10;
        input /= 10;
        long b = input % 10;
        input /= 10;
        long a = input % 10;
        input /= 10;
        long x = 0;
        x = (10L - (3L * a + b + 3L * c + d + 3L * e + f + 3L * g + h + 3L * i + j + 3L * k) % 10L) % 10L;
        System.out.println("" + a + b + c + d + e + f + g + h + i + j + k);
        System.out.println(x);
    }
}
