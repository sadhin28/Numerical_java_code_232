
import java.util.Scanner;

public class RK4Method {

    public static double function(double x, double y) {
        return x + y; 
    }

    public static double rk4(double x0, double y0, double x, double h) {
        int n = (int)((x - x0) / h);
        double y = y0;

        for (int i = 0; i < n; i++) {
            double k1 = h * function(x0, y);
            double k2 = h * function(x0 + h / 2, y + k1 / 2);
            double k3 = h * function(x0 + h / 2, y + k2 / 2);
            double k4 = h * function(x0 + h, y + k3);
            
            y += (k1 + 2 * k2 + 2 * k3 + k4) / 6;
            x0 += h;
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
        double result = rk4(x0, y0, x, h);
        System.out.println("The approximate value of y at x = " + x + " is: " + result);
    }
}
