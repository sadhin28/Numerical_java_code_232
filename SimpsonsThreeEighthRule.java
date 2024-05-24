import java.util.Scanner;

public class SimpsonsThreeEighthRule {

    public static double function(double x) {
        return Math.exp(-x * x); // Example: e^(-x^2)
    }
    public static double simpsonsThreeEighth(double a, double b, int n) {
        if (n % 3 != 0) {
            System.out.println("Number of intervals must be a multiple of 3.");
            return 0;
        }

        double h = (b - a) / n;
        double sum = function(a) + function(b);

        for (int i = 1; i < n; i++) {
            if (i % 3 == 0) {
                sum += 2 * function(a + i * h);
            } else {
                sum += 3 * function(a + i * h);
            }
        }

        return (3 * h / 8) * sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lower limit (a):");
        double a = scanner.nextDouble();

        System.out.println("Enter the upper limit (b):");
        double b = scanner.nextDouble();

        System.out.println("Enter the number of intervals (multiple of 3):");
        int n = scanner.nextInt();

        double result = simpsonsThreeEighth(a, b, n);
        System.out.println("The integral result using Simpson's 3/8 Rule is: " + result);
    }
}
