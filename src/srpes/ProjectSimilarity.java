package srpes;

import java.util.ArrayList;
import java.util.List;

public class ProjectSimilarity {

	public static void main(String[] args) {
		
		int[] current_sstr_ssize_dmethod_developer = new int[]{1, 2, 2, 2 };
	
		List<int[]> historic_sstr_ssize_dmethod_developer = new ArrayList<>();
		historic_sstr_ssize_dmethod_developer.add(new int[]{1, 2, 2, 1 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 2 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 2, 2, 1 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 2 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 3 });
		
		double[] similarity_score = getSimilarity(current_sstr_ssize_dmethod_developer,historic_sstr_ssize_dmethod_developer );
		for (double d : similarity_score) {
			System.out.println(d);
		}
	}

	private static double[] getSimilarity(
			int[] current_sstr_ssize_dmethod_developer,
			List<int[]> historic_sstr_ssize_dmethod_developer) {
	
		double[] scores= new double[historic_sstr_ssize_dmethod_developer.size()];
		
		for(int i=0;i<historic_sstr_ssize_dmethod_developer.size();i++)
		{
			for(int j=0; j<current_sstr_ssize_dmethod_developer.length; j++){
				
				if(current_sstr_ssize_dmethod_developer[j] == historic_sstr_ssize_dmethod_developer.get(i)[j]){
					scores[i] += 1;
				}
			}
			scores[i] /= current_sstr_ssize_dmethod_developer.length;
		}
		return scores;
	}
	
}
