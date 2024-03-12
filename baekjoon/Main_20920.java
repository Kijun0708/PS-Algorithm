package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_20920 {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {		// N번만큼 반복 값 map에 넣기
			String word = reader.readLine();
			
			if(word.length()>=M) {			// 단어 길이가 M 이상일 경우에만
				
				if(map.containsKey(word)) { // 이미 있는 단어라면 value + 1
					int count = map.get(word) + 1;
					map.put(word, count);
				}else { 					// 없으면 value = 1
					map.put(word,1);
				}
				
			}
			
		}
		
		
		List<Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		
		list = list.stream()
			.sorted((s1,s2) -> {
				if(s1.getValue()==s2.getValue()) {
					if(s1.getKey().length()==s2.getKey().length()) {
						return s1.getKey().compareTo(s2.getKey());			// 사전순 정렬
					}else {
						return s2.getKey().length() - s1.getKey().length(); // 길이순 정렬
					}
				}else {
					return s2.getValue().compareTo(s1.getValue());			// 출현횟수가 많은 것 부터
				}
			})
			.collect(Collectors.toList());
		
		for(Entry<String,Integer> word : list) {
			builder.append(word.getKey()).append("\n");
		}
		
		reader.close();
		
		System.out.println(builder);
		
	}//main

}
