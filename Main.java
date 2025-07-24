import java.util.Arrays;

public class Main {

public final static double[] X = new double[]{1, 2, 3, 4, 5};
public final static double[] Y = new double[]{3, 6, 9, 12, 15};

    public static void main(String[] args) {

      double w = .1;
      double[] results = new double[X.length];

      for(int i=0; i<X.length;i++){
        results[i]=X[i]*w;
      }
      System.out.println(Arrays.toString(results));
    }
}
