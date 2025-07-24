import java.util.Arrays;
import utils.vec;
public class Main {

// Global parameters
public static double LR = 1e-3;
public static int EPOCH = 1000;
public static double EPSILON = 1e-3;

public static final double[] X = new double[]{1, 2, 3, 4, 5};
public static final double[] Y = new double[]{3, 6, 9, 12, 15};
public static double w = .0;
public static double b = .0;

    public static void main(String[] args) {

      parseArgs(args);
      for (int i = 0; i < EPOCH; i++) {
        System.out.println("Epoch "+ i + " -");
        step();
      }

    }

    public static void step(){

      double cost_m = cost(w-EPSILON,b);
      double cost_p = cost(w+EPSILON,b);
      double dG = (cost_p-cost_m)/(2*EPSILON);
      double dGdb = (cost(w, b+EPSILON)-cost(w, b-EPSILON))/ (2*EPSILON);
      w -= dG*LR;
      b -= dGdb*LR;
      System.out.printf("Loss: %.6f | w: %.6f | b: %.6f%n", dG, w, b);

    }

    // MSE
    public static double cost(double w, double b) {
      double[] y = vec.add(vec.scale(X, w), b);
      double[] d = vec.subtract(Y,y);
      double[] squaredErrors = vec.multiply(d, d);
      double cost = vec.sum(squaredErrors)/X.length;
      return cost;
    }

   public static void parseArgs(String[] args){
      for (String arg : args) {
        if (arg.startsWith("--epoch=")) {
          EPOCH = Integer.parseInt(arg.substring("--epoch=".length()));
        } else if (arg.startsWith("--lr=")) {
          LR = Double.parseDouble(arg.substring("--lr=".length()));
        } else if (arg.startsWith("--eps=")) {
          EPSILON = Double.parseDouble(arg.substring("--eps=".length()));
        }
      }
    }
}
