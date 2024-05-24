import java.util.Scanner;

public class NewtonForwardInterpolation {
    static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
    static double newtonForward(double x[], double y[][], double value, int n) {
        double sum = y[0][0];
        double u = (value - x[0]) / (x[1] - x[0]);

        for (int i = 1; i < n; i++) {
            double term = u;
            for (int j = 1; j < i; j++) {
                term = term * (u - j);
            }
            term = term * y[0][i] / factorial(i);
            sum = sum + term;
        }

        return sum;
    }
    static void calculateDifferenceTable(double y[][], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of data points:");
        int n = scanner.nextInt();

        double x[] = new double[n];
        double y[][] = new double[n][n];

        System.out.println("Enter the values of x:");
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextDouble();
        }

        System.out.println("Enter the values of y:");
        for (int i = 0; i < n; i++) {
            y[i][0] = scanner.nextDouble();
        }

        calculateDifferenceTable(y, n);

        System.out.println("Enter the value to interpolate:");
        double value = scanner.nextDouble();

        double result = newtonForward(x, y, value, n);
        System.out.println("Interpolated value at " + value + " is " + result);
    }
}
