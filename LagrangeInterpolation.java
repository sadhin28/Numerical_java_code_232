import java.util.Scanner;

public class LagrangeInterpolation {


    static double lagrangeInterpolation(double x[], double y[], double value, int n) {
        double result = 0.0;

        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    term = term * (value - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of data points:");
        int n = scanner.nextInt();

        double x[] = new double[n];
        double y[] = new double[n];

        System.out.println("Enter the values of x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Enter the values of y:");
        for (int i = 0; i < n; i++) {
            y[i] = scanner.nextDouble();
        }

        System.out.println("Enter the value to interpolate:");
        double value = scanner.nextDouble();

        double result = lagrangeInterpolation(x, y, value, n);
        System.out.println("Interpolated value at " + value + " is " + result);
    }
}
