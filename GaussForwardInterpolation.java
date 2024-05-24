import java.util.Scanner;

public class GaussForwardInterpolation {

    static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
    static double gaussForward(double x[], double y[][], double value, int n) {
        double h = x[1] - x[0];
        double u = (value - x[(n - 1) / 2]) / h;
        double result = y[(n - 1) / 2][0];
        
        // Initializing u and calculation part
        double term = u;
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                result += (term * y[(n - 1) / 2 - (i / 2)][i]) / factorial(i);
            } else {
                result += (term * y[(n - 1) / 2 - (i / 2)][i]) / factorial(i);
                term *= (u - (i / 2));
            }
            term *= (u + (i / 2));
        }
        
        return result;
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

        double result = gaussForward(x, y, value, n);
        System.out.println("Interpolated value at " + value + " is " + result);
    }
}
