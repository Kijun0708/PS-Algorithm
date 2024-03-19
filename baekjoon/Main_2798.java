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

	private static void dfs(int sum, int count, int index) {
		
		if(count == 3 || sum > M) {
			if(sum <= M) {
				maxSum = Math.max(sum, maxSum);
			}
			return;
		}
		
		// 더 이상 고를 카드가 없을때
		if(index >= N) { 
			return;
		}
		
		// 현재 카드를 선택하는 경우
		dfs(sum + arr[index], count + 1, index + 1);
		
		// 현재 카드를 선택하지 않는 경우
		dfs(sum, count, index + 1);
		
		
	}//dfs
	
}

//재귀란? 
//자기 자신을 계속 호출해서 원하는 값을 찾아내는 방법
//
//> 재귀 vs 반복문
//
//시간복잡도 
//
//재귀는 구하기 어려움
//반복문은 구하기 쉬움
//
//
//재귀는 반복문에 비해 코드 길이가 짧음 > 메모리 사용도 증가 (스택 메모리에 저장됨)
//반복문은 시간복잡도가 재귀에 비해 낮음
//
//하지만 복잡한 코드의 경우 반복문에 비해 재귀가 가독성이 더 좋음
//and 수학공식을 적용하기가 좋음.
//ex) 피보나치 수열 n = (n-2) + (n-1); 
//
//이걸 그대로 재귀식으로 이용 
//return fibonacci(n-2) + fibonacci(n-1);
//
//재귀의 효율을 높이기 위해 꼬리 재귀 최적화
//> 컴파일러가 재귀 알고리즘을 해석해서 반복문으로 바꿔서 실행
//but 자바는 지원 안함
//
//
//재귀를 풀때는 함수를 타고타고 들어가는 생각은 하지 말것