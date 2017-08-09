package gradientDescent;
import java.util.Arrays;
import java.util.Scanner;

public class GradientDescent {
    private double [] theta;
    private double [][] trainingSet;
    private int numberOfVariables;
    private double learningRate;
    private double initTheta;
    private int totalData;
	private Scanner sc;

    public GradientDescent(double initTheta) {
        this.initTheta = initTheta;
    }

    public double getHypothesis(int TrainingDataPosition) {
        double result = 0;
        for (int i = 0; i < numberOfVariables; i++) {
            result += theta[i] * trainingSet[TrainingDataPosition][i];
        }
        return result;
    }

    public double getCost(int variablePosition) {
        double result = 0;
        for (int i = 0; i < totalData; i++) {
            //result += (-numberOfVariables * 1.0 / totalData) * (trainingSet[i][numberOfVariables] - getHypothesis(i)) * trainingSet[i][variablePosition];
        	result += (-numberOfVariables) * (trainingSet[i][numberOfVariables] - getHypothesis(i)) * trainingSet[i][variablePosition];
        	
        }
        return result;
    }

    public void update() {
        double[] newTheta = new double[numberOfVariables];
        for (int i = 0; i < numberOfVariables; i++) {
            //newTheta[i] = theta[i] - learningRate * getCost(i);
        	newTheta[i] = theta[i] - (learningRate * 1.0 / totalData) * getCost(i);
        }
        System.arraycopy(newTheta, 0, theta, 0, numberOfVariables);
        for (double d : theta) System.out.print(d + " ");
        System.out.println();
    }

    public void train(double learningRate, double[][] trainingSet, int iterations) {
        initTrainingSet(trainingSet);
        this.learningRate = learningRate;
        theta = new double[numberOfVariables];
        Arrays.fill(theta, 0.0);
        theta[0] = initTheta;
        while (iterations > 0) {
            update();
            iterations--;
        }
    }

    private void initTrainingSet(double[][] trainingSet) {
        totalData = trainingSet.length;
        numberOfVariables = trainingSet[0].length;
        this.trainingSet = new double[totalData][numberOfVariables + 1];
        for (int i = 0; i < totalData; i++) {
            this.trainingSet[i][0] = 1.0;
            for (int j = 0; j < numberOfVariables; j++) {
                this.trainingSet[i][j + 1] = trainingSet[i][j];
            }
        }
    }

    
    
    public double checkHypothesisResult() {
		// TODO Auto-generated method stub
    	System.out.println("Enter the variables:");
    	double [] x = new double[numberOfVariables];
    	double result = theta[0];
    	
    	sc = new Scanner(System.in);
    	for (int j = 0; j < numberOfVariables-1; j++) {
    		x[j] = sc.nextDouble();
    	}
    	for (int i = 1; i < numberOfVariables; i++) {
    		result += theta[i] * x[i - 1];
    	}

    	return result;
    }
}