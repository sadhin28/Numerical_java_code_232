import java.util.Scanner;

public class PicardsMethod {

  
    public static double function(double x, double y) {
        return x + y; 
    }
    public static double trapezoidalIntegral(double x0, double x, double y0, int iterations) {
        double h = (x - x0) / iterations;
        double sum = function(x0, y0);
        
        for (int i = 1; i < iterations; i++) {
            double xi = x0 + i * h;
            double yi = y0 + i * h * function(x0, y0);
            sum += 2 * function(xi, yi);
        }
        
        sum += function(x, y0 + h * function(x0, y0)); 
        return (h / 2) * sum;
    }
    public static double picard(double x0, double y0, double x, int iterations) {
        double y = y0;
        
        for (int i = 0; i < iterations; i++) {
            y = y0 + trapezoidalIntegral(x0, x, y, iterations);
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

        System.out.println("Enter the number of iterations:");
        int iterations = scanner.nextInt();
        double result = picard(x0, y0, x, iterations);
        System.out.println("The approximate value of y at x = " + x + " is: " + result);
    }
}
