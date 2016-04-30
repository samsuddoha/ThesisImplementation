package srpes;

import java.util.ArrayList;
import java.util.List;

public class MainSRPES {

	public static void main(String[] args) {
		
		List<int[]> current_sstr_ssize_dmethod_developer = new ArrayList<>();
		current_sstr_ssize_dmethod_developer.add(new int[]{1, 2, 2, 2 });
	
		List<int[]> historic_sstr_ssize_dmethod_developer = new ArrayList<>();
		historic_sstr_ssize_dmethod_developer.add(new int[]{1, 2, 2, 1 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 2 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 2, 2, 1 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 2 });
		historic_sstr_ssize_dmethod_developer.add(new int[]{2, 1, 2, 3 });
		
		double[] similarity_score = getSimilarity(current_sstr_ssize_dmethod_developer,historic_sstr_ssize_dmethod_developer );
		
		System.out.println(similarity_score);
	}

	private static double[] getSimilarity(
			List<int[]> current_sstr_ssize_dmethod_developer,
			List<int[]> historic_sstr_ssize_dmethod_developer) {
	
		
		double score=0;
		
		for(int i=0;i<historic_sstr_ssize_dmethod_developer.size();i++)
		{
			
			if(current_sstr_ssize_dmethod_developer.get(0)[0]==historic_sstr_ssize_dmethod_developer.get(i)[0])
			{
				score+=1;
			}
			else if(current_sstr_ssize_dmethod_developer.get(0)[1]==historic_sstr_ssize_dmethod_developer.get(i)[1])
			{
				score+=1;
			}
			else if(current_sstr_ssize_dmethod_developer.get(0)[2]==historic_sstr_ssize_dmethod_developer.get(i)[2])
			{
				score+=1;
			}
			else if(current_sstr_ssize_dmethod_developer.get(0)[3]==historic_sstr_ssize_dmethod_developer.get(i)[3])
			{
				score+=1;
			}
		}
		return null;
	}
	
}
