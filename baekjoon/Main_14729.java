package baekjoon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_14729 {
	
	public static void main(String[] args)throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Double> pq = new PriorityQueue<>(7,Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		
		int count = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<count; i++) {
			
			double num = Double.parseDouble(reader.readLine());
			if(pq.size()<7) {
				pq.add(num);
			}else if(pq.peek() > num) {
				pq.poll();
				pq.add(num);
			}
			
		}
		
		
		
		while(!pq.isEmpty()) {
			sb.insert(0, "\n"+String.format("%.3f",pq.poll()));
			if(pq.size()==1) {
				sb.insert(0, String.format("%.3f",pq.poll()));
			}
		}
		
		System.out.println(sb.toString());
		
	}//main

}
