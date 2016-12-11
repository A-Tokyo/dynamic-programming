package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coforces_189A_CutRibbon {
	static int n;
	static int a;
	static int b;
	static int c;
	static int [] memo;
	
	public static int cutRibbon(int n){
		if(n<0)
			return Integer.MIN_VALUE;
		if(memo[n]!=-1)
			return memo[n];
		if(n == a)
			return memo[n] = Math.max(1, 1+Math.max(cutRibbon(n-b), cutRibbon(n-c)));
		if(n == b)
			return memo[n] = Math.max(1, 1+Math.max(cutRibbon(n-a), cutRibbon(n-c)));
		if(n == c)
			return memo[n] = Math.max(1, 1+Math.max(cutRibbon(n-a), cutRibbon(n-b)));
		return memo[n] = 1 + Math.max(cutRibbon(n-a), Math.max(cutRibbon(n-b), cutRibbon(n-c)));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] thisLine = br.readLine().split(" ");
		n = Integer.parseInt(thisLine[0]);
		a = Integer.parseInt(thisLine[1]);
		b = Integer.parseInt(thisLine[2]);
		c = Integer.parseInt(thisLine[3]);
		memo = new int [n+1];
		memo[0]=0;
		for (int i = 1; i < n+1; i++) {
			memo[i] = -1;
		}
		System.out.println(cutRibbon(n));
	}

}
