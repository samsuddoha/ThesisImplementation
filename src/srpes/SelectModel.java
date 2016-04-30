package srpes;

import java.util.ArrayList;
import java.util.List;

public class SelectModel {

	public static void main(String[] args) {
		List<double[]> model_similarity_reliability = new ArrayList<>();
		model_similarity_reliability.add(new double[]{1, 0.81, 0.75});
		model_similarity_reliability.add(new double[]{2, 0.71, 0.45});
		model_similarity_reliability.add(new double[]{1, 0.55, 0.75});
		model_similarity_reliability.add(new double[]{2, 0.21, 0.55});
		model_similarity_reliability.add(new double[]{3, 0.81, 0.65});
		model_similarity_reliability.add(new double[]{1, 0.75, 0.75});
		model_similarity_reliability.add(new double[]{3, 0.81, 0.75});
		model_similarity_reliability.add(new double[]{1, 0.88, 0.68});
		model_similarity_reliability.add(new double[]{3, 0.85, 0.85});
		
		double[] bestModel_bestFitness = getBestFitModel(model_similarity_reliability);
		
		System.out.println(bestModel_bestFitness[0] + " " + bestModel_bestFitness[1]);
	}
	
	public static double[] getBestFitModel(List<double[]> model_similarity_reliability){
		
		List<double[]> temp_model_similarity_reliability = new ArrayList<>();

		double bestFitness = -9999;
		double bestModel = -9999;
		int bestFitness_sampleSize = 0;
		
		while(!model_similarity_reliability.isEmpty()){
			temp_model_similarity_reliability.add(model_similarity_reliability.remove(0));
			
			for(int i=0; i<model_similarity_reliability.size(); i++){
				if(temp_model_similarity_reliability.get(0)[0] == 
						model_similarity_reliability.get(i)[0]){
					
					temp_model_similarity_reliability.add(model_similarity_reliability.remove(i));
					
					i--;
				}
			}
			
			double recentFitness = calculateModelFitness(temp_model_similarity_reliability);
			int recentFitness_sampleSize = temp_model_similarity_reliability.size();
			//System.out.println(recentFitness);
			
			if((bestFitness<recentFitness) ||
				(bestFitness==recentFitness && bestFitness_sampleSize<recentFitness_sampleSize)){
				bestFitness = recentFitness;
				bestModel = temp_model_similarity_reliability.get(0)[0];
				bestFitness_sampleSize = recentFitness_sampleSize;
			}
			
			temp_model_similarity_reliability.clear();
			
		}
		
		return new double[]{bestModel, bestFitness};
	}
	
	public static double calculateModelFitness(List<double[]> similarity_reliability){
		
		double similarity_reliability_sum = 0;
		double similarity_sum = 0;
		double fitness = 0;
		
		for(int i=0; i<similarity_reliability.size(); i++){
			similarity_reliability_sum += similarity_reliability.get(i)[1]*
					similarity_reliability.get(i)[2]; 
			similarity_sum += similarity_reliability.get(i)[1];
		}
		
		fitness = similarity_reliability_sum/similarity_sum;
		
		return fitness;
	}
}
