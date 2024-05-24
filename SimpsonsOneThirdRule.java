import java.util.Scanner;
public class SimpsonsOneThirdRule {
    public static double function(double x) {
        return Math.exp(-x * x); // Example: e^(-x^2)
    }

    public static double simpsonsOneThird(double a, double b, int n) {
        if (n % 2 != 0) {
            System.out.println("Number of intervals must be even.");
            return 0;
        }

        double h = (b - a) / n;
        double sum = function(a) + function(b);

        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                sum += 2 * function(a + i * h);
            } else {
                sum += 4 * function(a + i * h);
            }
        }

        return (h / 3) * sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lower limit (a):");
        double a = scanner.nextDouble();

        System.out.println("Enter the upper limit (b):");
        double b = scanner.nextDouble();

        System.out.println("Enter the number of intervals (even number):");
        int n = scanner.nextInt();

        double result = simpsonsOneThird(a, b, n);
        System.out.println("The integral result using Simpson's 1/3 Rule is: " + result);
    }
}
