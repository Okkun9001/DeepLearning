package data;

public class perceptron {
  public static double[][] gates() {
    return new double[][] {  {0, 0}, 
                              {1, 0},
                              {0, 1},
                              {1, 1}};
  }

  public static double[] OR() {
    return new double[]{0,1,1,1};
  }

   public static double[] AND() {
    return new double[]{0,0,0,1};
  } 

  public static double[] NAND() {
    return new double[]{1,1,1,0};
  }

  public static double[] XOR(){
    return new double[]{0,1,1,0};
  }
}
