package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {
	
	static int N;
	static int M;
	static int[] arr;
	static int maxSum;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		
		arr = new int[N];
		
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken()); 
		}
		
		dfs(0, 0, 0);
		System.out.println(maxSum);
		
	}//main

	private static void dfs(int start, int depth, int sum) {
		
		if(depth==3) {
			if(sum <= M) {
				maxSum = Math.max(sum, maxSum);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			dfs(i + 1, depth + 1, sum+arr[i]);
		}
		
	}//dfs

}
