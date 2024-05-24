import java.util.Scanner;

public class EulersMethod {

    public static double function(double x, double y) {
        return x + y;
    }
    public static double euler(double x0, double y0, double x, double h) {
        double y = y0;
        while (x0 < x) {
            y = y + h * function(x0, y);
            x0 = x0 + h;
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter the initial value of x (x0):");
        double x0 = scanner.nextDouble();

        System.out.println("Enter the initial value of y (y0):");
        double y0 = scanner.nextDouble();

        System.out.println("Enter the value of x at which y is to be found:");
        double x = scanner.nextDouble();

        System.out.println("Enter the step size (h):");
        double h = scanner.nextDouble();

        double result = euler(x0, y0, x, h);
        System.out.println("The approximate value of y at x = " + x + " is: " + result);
    }
}
