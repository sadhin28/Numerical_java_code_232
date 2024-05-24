import java.util.Scanner;

public class TrapezoidalRule {

    public static double function(double x) {
        return Math.exp(-x * x);
    }

    public static double trapezoidalRule(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = function(a) + function(b);

        for (int i = 1; i < n; i++) {
            sum += 2 * function(a + i * h);
        }

        return (h / 2) * sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lower limit (a):");
        double a = scanner.nextDouble();

        System.out.println("Enter the upper limit (b):");
        double b = scanner.nextDouble();

        System.out.println("Enter the number of intervals:");
        int n = scanner.nextInt();

        double result = trapezoidalRule(a, b, n);
        System.out.println("The integral result using the Trapezoidal Rule is: " + result);
    }
}
