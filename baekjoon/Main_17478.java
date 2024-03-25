package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.ModuleDescriptor.Builder;

public class Main_17478 {
	
	static int N;
	static StringBuilder builder;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		builder = new StringBuilder();
		
		N = Integer.parseInt(reader.readLine());
		
		
		builder.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(0,0);
		System.out.println(builder.toString());
		
	}//main

	private static void recursive(int count,int dash) {
		if(count==N) {
			insertDash(dash);
			builder.append("\"재귀함수가 뭔가요?\"\n");
			insertDash(dash);
			builder.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			insertDash(dash);
			builder.append("라고 답변하였지.\n");
			return;
		}
		
		if(count<N) {
			insertDash(dash);
			builder.append("\"재귀함수가 뭔가요?\"\n");
			insertDash(dash);
			builder.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			insertDash(dash);
			builder.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			insertDash(dash);
			builder.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		}
		
		recursive(count+1,dash+4);
		insertDash(dash);
		builder.append("라고 답변하였지.\n");
		
	}

	private static void insertDash(int dash) {
		for(int i=0; i<dash; i++) {
			builder.append("_");
		}
	}

}
