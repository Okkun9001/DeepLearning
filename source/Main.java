import utils.vec;
import data.perceptron;
import nn.Model;

import java.util.Arrays;

public class Main {

  // Global parameters
  public static double LR = 1e-1;
  public static int EPOCH = 10000;
  public static double EPSILON = 1e-1;

  public static final double[][] X = perceptron.gates();
  public static final double[] Y = perceptron.XOR();

  public static void main(String[] args) {
    parseArgs(args);

    Model xor = new Model(3, X, Y, new double[]{LR, EPOCH, EPSILON});
    xor.learn();

    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        double c = xor.forward(new double[]{i,j});
        System.out.printf("%d | %d = %.6f%n", i,j,c);
      }
    }

  }

  public static void parseArgs(String[] args) {
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
