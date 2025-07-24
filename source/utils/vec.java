package utils;
public class vec {
  public static double[] scale(double[] x, double w){
    double[] new_x = new double[x.length];
    for (int i = 0; i < x.length; i++) {
      new_x[i]=x[i]*w;
    }
    return new_x;
  }

  public static double[] multiply(double[] v1, double[] v2) {
    if (v1.length != v2.length) {
        throw new IllegalArgumentException("Arrays must have the same length");
    }

    double[] r = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
      r[i]=v1[i] * v2[i];
    }
    return r;
  }

  public static double[] subtract(double[] v1, double[] v2) {
    if (v1.length != v2.length) {
        throw new IllegalArgumentException("Arrays must have the same length");
    }

    double[] r = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
        r[i] = v1[i] - v2[i];
    }
    return r;
  }

  public static double[] add(double[] v1, double[] v2) {
    if (v1.length != v2.length) {
        throw new IllegalArgumentException("Arrays must have the same length");
    }

    double[] r = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
        r[i] = v1[i] + v2[i];
    }
    return r;
  }

  public static double[] add(double[] v1, double b) {
 
    double[] r = new double[v1.length];
    for (int i = 0; i < v1.length; i++) {
        r[i] = v1[i] + b;
    }
    return r;
  }

  public static double dot(double[] v1, double[] v2) {
    if (v1.length != v2.length) {
        throw new IllegalArgumentException("Arrays must have the same length");
    }
     
    double r = 0;
    for (int i = 0; i < v1.length; i++) {
      r+= v1[i]*v2[i];
    }
    return r;
  }

  public static double sum(double[] x) {
    double s = 0;
    for (int i = 0; i < x.length; i++) {
      s+=x[i];
    }
    return s;
  }
}

