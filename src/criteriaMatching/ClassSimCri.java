package criteriaMatching;
import java.util.ArrayList;

public class ClassSimCri {
	public static void main(String[] args) {
		ArrayList<int[]> project1 = new ArrayList<>();
		project1.add(new int[]{1, 7, 5});
		project1.add(new int[]{2, 10, 6});
		project1.add(new int[]{3, 6, 3});
		project1.add(new int[]{4, 7, 4});

		
		
		ArrayList<int[]> project2 = new ArrayList<>();
		project2.add(new int[]{1, 5, 4});
		project2.add(new int[]{2, 6, 3});
		project2.add(new int[]{3, 9, 5});
		project2.add(new int[]{4, 6, 2});
		
		double[] score = getScore(project1, project2);
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i]+",");
		}

	}

	private static double[] getScore(ArrayList<int[]> project1, ArrayList<int[]> project2) {
		double[] score = new double[project1.size()];
		
		double[][] matrix = new double[project1.size()][project2.size()];
		for (int i = 0; i < project1.size(); i++) {
			for (int j = 0; j < project2.size(); j++) {
				double attributeRatio = 0;
				double methodRatio = 0;
				if(project1.get(i)[1] > project2.get(j)[1]){
					attributeRatio = project2.get(j)[1]*1.0/project1.get(i)[1];
				}else{
					attributeRatio = project1.get(i)[1]*1.0/project2.get(j)[1];
				}
				
				if(project1.get(i)[2] > project2.get(j)[2]){
					methodRatio = project2.get(j)[2]*1.0/project1.get(i)[2];
				}else{
					methodRatio = project1.get(i)[2]*1.0/project2.get(j)[2];
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
