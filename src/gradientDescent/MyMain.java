package gradientDescent;

import java.io.*;
import java.util.ArrayList;


public class MyMain {

    private static double[][] trainingSet;
    private static double learningRate = 0.000001;
    private static int iteration = 1000;


    
    public static void main(String[] args) {
        if(getTrainingData()) {
            GradientDescent gd = new GradientDescent(0);
            gd.train(learningRate, trainingSet, iteration);
            
            System.out.println("Predicted result:"+ gd.checkHypothesisResult());
        }
    }

    
		
  

	private static boolean getTrainingData() {
        ArrayList<String> dataString = new ArrayList<>();
        
        File file = new File("C:/Users/Tasnim Fabiha/workspace/Data Science/src/gradientDescent/Input File/data.txt");
        if(file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                try {
                    while((line = reader.readLine()) != null) {
                        dataString.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (dataString.size() > 0) {
            int totalTrainigData = dataString.size();
            int numberOfVariable = dataString.get(0).split(",").length;
            trainingSet = new double[totalTrainigData][numberOfVariable];
            for(int i = 0; i < totalTrainigData; i++) {
                String[] tokens = dataString.get(i).split(",");
                for (int j = 0; j < numberOfVariable; j++) {
                    trainingSet[i][j] = Double.valueOf(tokens[j]);
                }
            }
            return true;
        }
        return false;
    }
}