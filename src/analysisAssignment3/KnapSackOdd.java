/*
 * In the classical 1-0 knapsack problem, we either pick an item or we do not. Use Dynamic programming to solve a 1-0 knapsack problem with another condition set which is that either an item occurs zero or an odd number of times in the knapsack. Inputs: - n items {I1, I2, ..., In} where each input item Ix is a pair (wx, vx) where w is
 * weight and v is value.
 * - Knapsack size: C kg
 * Output: A feasible set of item indices (k1, ..., kn) such that ∑ kjwj <= C and
 * kj ε {0, 1, 3,5,...}. The goal is to maximize ∑ kjvj for a feasible set. AssumefurtherthatC=n2 andthatn<=wj <=n2 forallj.
 */
package analysisAssignment3;

public class KnapSackOdd {
	static int [][][] dpArray;
	static int [] weights;
	static int [] profits;
	static int negInfinity = Integer.MIN_VALUE;
	
	public static int knapSack(int currItem, int weightRemaining , int isOdd) {
		if(weightRemaining<0)
			return negInfinity;
		if(currItem==weights.length)
			return 0; //done
		if(dpArray[currItem][weightRemaining][isOdd]!=-1){
			return dpArray[currItem][weightRemaining][isOdd];
		}
		int taken, left, takenOddTimes = negInfinity;
		if(isOdd == 0){
			// First time to come to this item or this item was not taken
			taken = profits[currItem]+ knapSack(currItem+1, weightRemaining-weights[currItem], 0);
			left = knapSack(currItem+1, weightRemaining, 0);
			takenOddTimes = profits[currItem]+ knapSack(currItem, weightRemaining-weights[currItem], 1);
		}else{
			// try to take again
			taken = (2*profits[currItem])+ knapSack(currItem, weightRemaining-(2*weights[currItem]), 1);
			// now leave
			left = knapSack(currItem+1, weightRemaining, 0);
		}
		dpArray[currItem][weightRemaining][isOdd] = Math.max(Math.max(taken, left) , takenOddTimes);
		return dpArray[currItem][weightRemaining][isOdd];
	}
	
	public static int knapSack(int currItem, int weightRemaining ) {
		return knapSack(currItem, weightRemaining, 0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weights = new int [4];
		weights[0]=2;
		weights[1]=9;
		weights[2]=8;
		weights[3]=4;
		
		profits = new int [4];
		profits[0]=3;
		profits[1]=8;
		profits[2]=4;
		profits[3]=6;
		
		dpArray = new int [weights.length][weights.length*weights.length+1][2];
		
		for (int i = 0; i < dpArray.length; i++) {
			for (int j = 0; j < dpArray[i].length; j++) {
				for (int j2 = 0; j2 < dpArray[i][j].length; j2++) {
					dpArray[i][j][j2] = -1;
				}
			}
		}
		
		//AssumefurtherthatC=n2 andthatn<=wj <=n2 forallj.
		System.out.println(knapSack(0, 16));

		
	}

}
