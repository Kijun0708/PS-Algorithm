package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_1931 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		List<Meeting> list = new ArrayList<>();
		
		int N = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < N; i++) {
			
			tokenizer = new StringTokenizer(reader.readLine());
			
			Meeting meeting = new Meeting(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
			
			list.add(meeting);
			
		}
		
		list =  list.stream()
							.sorted((s1,s2) -> {
								if(s1.getEndTime()==s2.getEndTime()) {
									return s1.getStartTime()- s2.getStartTime();
								}else {
									return s1.getEndTime() - s2.getEndTime();
								}	
							})
							.collect(Collectors.toList());
		
		int count = 0;
		int prevEndTime = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(prevEndTime <= list.get(i).getStartTime()) {
				count++;
				prevEndTime = list.get(i).getEndTime();
			}
			
		}
		
		System.out.println(count);
		
		
	}//main

}

class Meeting{
	
	private int startTime;
	private int endTime;
		
	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getStartTime() {
		return startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}	
	
}
