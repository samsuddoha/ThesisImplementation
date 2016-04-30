package criteriaMatching;

import java.util.ArrayList;

public class SimCri_Class {

	public static void main(String[] args) {
		ArrayList<int[]> project1 = new ArrayList<>();
		project1.add(new int[]{7, 10, 6, 7});
		project1.add(new int[]{5, 6, 3, 4});
		
		ArrayList<int[]> project2 = new ArrayList<>();
		project2.add(new int[]{5, 6, 9, 6});
		project2.add(new int[]{4, 3, 5, 2});
		
		double[] score = getScore(project1, project2);
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i]+",");
		}

	}

	private static double[] getScore(ArrayList<int[]> project1, ArrayList<int[]> project2) {
		double[] score = new double[project1.get(0).length];
		
		double[][] matrix = new double[project1.get(0).length][project1.get(0).length];
		for (int i = 0; i < project1.get(0).length; i++) {
			for (int j = 0; j < project2.get(0).length; j++) {
				double attributeRatio = 0;
				double methodRatio = 0;
				if(project1.get(0)[i] > project2.get(0)[j]){
					attributeRatio = project2.get(0)[j]*1.0/project1.get(0)[i];
				}else{
					attributeRatio = project1.get(0)[i]*1.0/project2.get(0)[j];
				}
				
				if(project1.get(1)[i] > project2.get(1)[j]){
					methodRatio = project2.get(1)[j]*1.0/project1.get(1)[i];
				}else{
					methodRatio = project1.get(1)[i]*1.0/project2.get(1)[j];
				}
				
				matrix[i][j] = (attributeRatio+methodRatio)/2;
			}
		}		
		ArrayList<Integer> indexContainer = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			double max = -55555;
			int index = 5555;
			for (int j = 0; j < matrix[0].length; j++) {
				if(!indexContainer.contains(j) && max<matrix[i][j]){
					max = matrix[i][j];
					index = j;
				}
			}
			score[i] = max;
			indexContainer.add(index);
		}
		
		
		return score;
	}

}
