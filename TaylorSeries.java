import java.util.Scanner;

public class TaylorSeries {

    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static double taylorSeriesExp(double x, int terms) {
        double sum = 1.0;

        for (int i = 1; i < terms; i++) {
            sum += Math.pow(x, i) / factorial(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of x for e^x:");
        double x = scanner.nextDouble();

        System.out.println("Enter the number of terms to include in the Taylor series:");
        int terms = scanner.nextInt();

        double result = taylorSeriesExp(x, terms);
        System.out.println("The Taylor series approximation of e^" + x + " using " + terms + " terms is: " + result);
    }
}
