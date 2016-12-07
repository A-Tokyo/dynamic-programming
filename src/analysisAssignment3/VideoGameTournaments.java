/**
 * You are given a schedule of video game tournaments, sorted by the date on which they will occur.
 * Each tournament i has a difficulty level d[i] and a prize amount p[i].
 * You feel confident you can win any tournament,
 * however the organizers do not allow anyone who has won a more difficult tournament to participate 
 * (so if you won a tournament with difficulty 2, from this point on, you can only participate in tournaments with difficulty level 2 or greater. 
 * Design and implement in Java a Dynamic Programming algorithm to select which tournaments you should participate in,
 * if you want to maximize your profit 
 * Notes: - You plan to win all the tournaments in which you participate!
 */
package analysisAssignment3;

import java.util.ArrayList;

/**
 * @author Tokyo
 *
 */
public class VideoGameTournaments {
	static int [] dpArray;
	
	public static void fillDPArray(int [] difficulties, int []prizes) {
		dpArray = new int [difficulties.length];
		dpArray[0] = prizes[0];
		for (int i = 1; i < difficulties.length; i++) {
			for (int j = i; j >= 0; j--) {
				if (difficulties[i] >= difficulties[j])
					dpArray[i] = Math.max(dpArray[i], dpArray[j] + prizes[i]);
			}
			dpArray[i] = Math.max(dpArray[i], dpArray[i-1]);
		}
	}
	
	public static ArrayList<Integer> getTournaments(int [] difficulties, int []prizes) {
		fillDPArray(difficulties, prizes);
		ArrayList<Integer> tournaments = new ArrayList<Integer>();
		// TODO trace dpArray
		return tournaments;
	}
	
	public static String arrayToString(int [] [] array) {
		String result = "";
		for(int i = 0; i<array.length; i++){
			result+=("[ ");
		    for(int j = 0; j<array[i].length; j++){
		    	result+=(array[i][j] + (j==array.length-1?" ]":", "));
		    }
		    result+="\n";
		}
		return result;
	}
	
	public static String arrayToString(int [] array) {
		String result = "";
		if(array.length>0)
			result+=("[ ");
		    for(int i = 0; i<array.length; i++){
		    	result+=(array[i] + (i==array.length-1?" ]":", "));
		    }
		    result+="\n";
		return result;
	}
	
	public static void main(String[] args) {
		int [] difficulties = {2,4,1,6};
		int [] prizes = {3,2,8,7};
		
		fillDPArray(difficulties, prizes);
		System.out.println(arrayToString(dpArray));
	}

}
