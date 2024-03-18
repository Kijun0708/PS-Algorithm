package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
	
	static int N;     //일할수 있는 날
	static int[] T;	  //상담 걸리는 기간
	static int[] P;   //금액
	static int max = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		N = Integer.parseInt(reader.readLine());
		
		T = new int[N + 1]; //0번인덱스는 더미
		P = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {   						//일수와 인덱스를 맞추기위해 1번인덱스 부터 시작
			tokenizer = new StringTokenizer(reader.readLine());
			
			T[i] = Integer.parseInt(tokenizer.nextToken());
			P[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		dfs(1,0);   				//첫째날,0원
		
		System.out.println(max);
	}//main

	private static void dfs(int day, int profit) {
		if(day == N + 1) {				    //마지막날 까지 왔다면 현재까지의 최고금액과 지금 금액 비교 후 저장
			max = Math.max(max, profit);
			return;
		}
		if(day > N + 1) { 					//퇴사일 초과할 경우
			return;
		}
		
		dfs(day + T[day], profit + P[day]); //상담을 하는 경우
		dfs(day + 1, profit);				//상담을 하지 않는 경우
		
	}//dfs

}
