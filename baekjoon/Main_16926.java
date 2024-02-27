package baekjoon;
// 배열 돌리기1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16926 {
	
	static int originalArr[][];		 			//원본배열
	static int rotationArr[][];  	 			//돌릴배열
	static ArrayList<Integer> rotationCount;    //배열 회전수 저장
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(reader.readLine());
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(st.nextToken()); //1차원 배열 길이
			int M = Integer.parseInt(st.nextToken()); //2차월 배열 길이
			int R = Integer.parseInt(st.nextToken()); //돌릴 횟수
			
			originalArr = new int[N][M];
			rotationArr = new int[N][M];
			rotationCount = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {				  //배열에 입력받은 값 넣기
				
				st = new StringTokenizer(reader.readLine());

				for(int j = 0; j < M; j++) {

					originalArr[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			findRotationNum(N, M);        			  //회전수 구하는 메서드
			int count = findLCM();
			
			if(R > count) {
				R = R % count;
			}

			for(int i = 0; i < R; i++) {				  //R번만큼 배열 돌리기
				rotationArr(N - 1, M - 1, 0);
			}
			
			for(int i = 0; i < N; i++) {				  //돌린 배열을 출력을 위해 stringBuider에 저장

				for(int j = 0; j < M; j++) {

					sb.append(rotationArr[i][j]).append(" ");

				}
				sb.append("\n");
				
			}
			
			System.out.println(sb.toString());

		} catch (Exception e) {
			System.out.println("Main_16926.main");
			e.printStackTrace();
		}

	}//main
	
	
	/**
	 * 배열을 반시계 방향으로 돌리는 메서드
	 * @param n 1차원 배열 길이
	 * @param m 2차원 배열 길이
	 * @param num 마지막인덱스 = 배열의길이-num  
	 */
	private static void rotationArr(int n, int m, int num) {
		
		if(n < originalArr.length/2 || m < originalArr[0].length/2) {	// 재귀 메서드를 끝내는 조건문
			copyArray(rotationArr,originalArr);						    // 제한사항중 n m 둘다 홀수일 수는 없으므로 ||조건
			return;
		}

		int fixedN = n-num;								// 고정된 1차원 배열 끝 인덱스
		int fixedM = m-num;								// 고정된 2차원 배열 끝 인덱스
		int numBorder = fixedN * 2 + fixedM * 2;		// 2차원 배열 테두리에 있는 값의 수 (둘레)
		
		for(int i = 0; i < numBorder; i++) {                // 테두리 수 만큼 반복
					
			if(i < fixedN) {								// 4개의 변중 오른쪽 아래에서 오른쪽 위 방향으로 이동
				rotationArr[n-1][m] = originalArr[n][m];
				n--;
			} else if(i < fixedN+fixedM) {					// 4개의 변중 오른쪽 위에서 왼쪽 위 방향으로 이동
				rotationArr[n][m-1] = originalArr[n][m];
				m--;	
			} else if(i < fixedN*2+fixedM) {				// 4개의 변중 왼쪽 위에서 왼쪽 아래 방향으로 이동
				rotationArr[n+1][m] = originalArr[n][m];
				n++;
			} else if(i<fixedN*2+fixedM*2) {				// 4개의 변중 왼쪽 아래에서 오른쪽 아래 방향으로 이동
				rotationArr[n][m+1] = originalArr[n][m];
				m++;
			}		
			
		}
		
		rotationArr(n-1,m-1,num+1);						//바깥 테두리 종료후 안쪽 테두리로 진입 이때 num는 +1

	}
	
	/**
	 * 돌린 배열을 원본 배열로 저장하는 메서드
	 * R번 돌리기 위해 원본 배열을 돌린 배열로 저장(깊은 복사)
	 * @param copyArr 복사할 배열
	 * @param arr 복사 받을 배열
	 */
	private static void copyArray(int[][] copyArr, int[][] arr) {
		
	    for (int i = 0; i < copyArr.length; i++) {
	    	
	        for (int j = 0; j < copyArr[i].length; j++) {
	            arr[i][j] = copyArr[i][j];
	        }
	    }
	    
	}//copyArray
	
	/**
	 * 유클리드 호제법으로 최대공약수 찾기
	 * @param a
	 * @param b
	 * @return 최대 공약수
	 */
	private static int findGCD(int a, int b) {
		
		int temp = 0;
		
		while(b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}//findGCD
	
	
	/**
	 * 최대 공약수로 최소 공배수 구하기
	 * @param a
	 * @param b
	 * @return 최소 공배수
	 */
	private static int findLCM(int a, int b) {
		
		return a * (b / findGCD(a,b));
	}//findLCM
	
	
	/**
	 * N개의 숫자의 최소 공배수 구하기
	 * @return 최소 공배수
	 */
	private static int findLCM() {
		
		int lcm = rotationCount.get(0);
		for(int i = 1; i < rotationCount.size(); i++) {
			lcm = findLCM(lcm,rotationCount.get(i));
		}
		return lcm;
	}//findLCM
	
	
	/**
	 * 각각의 회전 수 구하기
	 * @param n
	 * @param m
	 */
	private static void findRotationNum(int n, int m) {
		
		if(n - 1 <= 0 || m - 1 <= 0) {
			return;
		}

		int count = (n-1 + m-1) * 2;
		
		rotationCount.add(count);
		
		findRotationNum(n - 1, m - 1);

	}//findRotationNum

}
