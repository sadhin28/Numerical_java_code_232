import java.util.Scanner;

public class StirlingsInterpolation {

    static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    static void calculateDifferenceTable(double y[][], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
            }
        }
    }
    static double stirlingInterpolation(double x[], double y[][], double value, int n) {
        int mid = n / 2;
        double h = x[1] - x[0];
        double u = (value - x[mid]) / h;
        double u2 = u * u;
        
        double result = y[mid][0];
        double term = u;

        // Interpolation calculation
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                if (mid - i / 2 >= 0 && mid + i / 2 < n) {
                    result += term * (y[mid - i / 2][i] + y[mid - i / 2 - 1][i]) / 2 / factorial(i);
                    term *= (u2 - (i * i) / 4.0);
                }
            } else {
                if (mid - i / 2 >= 0 && mid - i / 2 + 1 < n) {
                    result += term * y[mid - i / 2][i] / factorial(i);
                    term *= (u2 - (i * i) / 4.0);
                }
            }
            term /= (i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of data points (even number):");
        int n = scanner.nextInt();

        if (n % 2 != 0) {
            System.out.println("Number of data points must be even.");
            return;
        }

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

        double result = stirlingInterpolation(x, y, value, n);
        System.out.println("Interpolated value at " + value + " is " + result);
    }
}
