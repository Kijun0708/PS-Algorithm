package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Mai_20920 {
	
	public static void main(String[] args) throws IOException {
		
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

		List<String> list = new ArrayList<>(map.keySet());

		list = list.stream()
				.sorted((o1,o2) -> {
					if (!map.get(o1).equals(map.get(o2))) {
                	    //등장 횟수를 기준으로 정렬 > 등장 횟수가 다를 때
                	    return Integer.compare(map.get(o2), map.get(o1)); // 양수면 o2부터, 아니면 o1부터
                	} else if (o1.length() != o2.length()) {
                	    // 길이가 다르면 긴 단어를 우선으로 정렬 > 등장 횟수가 같을 때
                	    return Integer.compare(o2.length(), o1.length());
                	} else {
                	    // 사전 순으로 정렬
                	    return o1.compareTo(o2);
                	}
				})
				.collect(Collectors.toList());

		for(String word : list) {
			builder.append(word).append("\n");
		}

		reader.close();

		System.out.println(builder);
	}//main

}
