package nn;
import utils.vec;

public class Model {
  
  int n; //#neurons
  int nWeights;
  double[] p; // hyper params: LR, EPOCH, EPSILON

  double[][] X;
  double[] Y;
  double[] W;

  public Model (int n, double[][] X, double[] Y, double[] params){
    this.X = X;
    this.Y = Y;
    this.p = params;
    this.nWeights = X[0].length+1;
    this.n = n;
    this.W = new double[n*nWeights];

    double scale = Math.sqrt(1./ nWeights);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < nWeights; j++) {
        W[i*nWeights + j]= (Math.random()-.5)*scale;
      }
    }
  }

  public void learn(){
    for (int i = 0; i < p[1]; i++) {
      double[] dG = gradient();
      this.W = vec.subtract(W, vec.scale(dG, p[0]));
    }
  }

  public double[] gradient(){
    double[] dG = new double[W.length];
    double save;
    for (int i = 0; i < W.length; i++) {

      save = W[i];

      W[i] -= p[2];
      double cost_m = cost();

      W[i] += 2*p[2];
      double cost_p = cost();

      dG[i] = (cost_p - cost_m) / (2 * p[2]);

      W[i] = save;
    }
    return dG;
  }

  // MSE
  public double cost() {
    double[] y = new double[X.length];
    for (int i = 0; i < X.length; i++) {
      y[i]= forward(X[i]);
    }
    double[] d = vec.subtract(Y, y);
    double[] squaredErrors = vec.multiply(d, d);
    double cost = vec.sum(squaredErrors) / X.length;
    return cost;
  }
  
  public double forward(double[] X) {
  
    double a = sigmoid(W[0]*X[0] + W[1]*X[1] + W[2]);
    double b = sigmoid(W[3]*X[0] + W[4]*X[1] + W[5]);
    return sigmoid(W[6]*a + W[7]*b + W[8]);
  }

  public double sigmoid(double x){
    return 1./(1.+Math.exp(-x));
  }
}
