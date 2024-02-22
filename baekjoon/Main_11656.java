package baekjoon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 접미사 배열

public class Main_11656{
    
    public static void main(String[] args){
               	
    	try {
   
    		
    		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder sb = new StringBuilder();
    		
    		String word = reader.readLine();                  // 입력받기
    		
    		String[] wordArr = new String[word.length()];     // 배열 생성후 입력한 단어의 길이만큼의 길이 설정
    		
    		for(int i=0; i<word.length(); i++){				  // 앞 문자 하나씩 빼면서 배열에 저장
    			wordArr[i] = word.substring(i);
    		}
    		
    		Arrays.sort(wordArr); 							  // 오름차순 정렬
    		
    		for(int i=0; i<wordArr.length; i++){			  // 정렬된 배열을 StringBuilder에 저장
    			sb.append(wordArr[i]).append("\n");
    		}
    		reader.close();
    		
    		System.out.println(sb.toString()); 			
			
		} catch (Exception e) {
			System.out.println("ExamArray.main");
			e.printStackTrace();
		}
                
            
     }
    
}
