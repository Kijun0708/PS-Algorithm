package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966 {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder builder = new StringBuilder();
			
			int testCase = Integer.parseInt(reader.readLine());
			
			for(int i = 0; i < testCase; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				int count = 0;
				
				Queue<Integer> queue = new LinkedList<>();
				Queue<Integer> indexQueue = new LinkedList<>();
				
				st = new StringTokenizer(reader.readLine());
				
				for(int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					queue.add(num);
					indexQueue.offer(j);
					
				}
				
				
				while(!queue.isEmpty()) {
					
					int max = Collections.max(queue);
					int currentNum = queue.poll();
					int index = indexQueue.poll();
					
					if(currentNum == max) {
						
						if(index == M) {
							count++;
							builder.append(count+"\n");
							break;
						}
						count++;
						
					}else {
						queue.offer(currentNum);
						indexQueue.offer(index);
					}
					
				}
				
			}
			
			System.out.println(builder.toString());
			
		} catch (Exception e) {
			System.out.println("Main_1966.main()");
			e.printStackTrace();
		}
		
	}//main

}
