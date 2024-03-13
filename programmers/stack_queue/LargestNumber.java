package programmers.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumber {
	
	static int[] arr;
	static int[] copyArr;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int N = Integer.parseInt(reader.readLine());
		
		arr = new int[N];
		copyArr = new int[N];
		
		for(int i = 0; i < N ; i++) {
			
			arr[i] = Integer.parseInt(reader.readLine());
			
		}
		
		
		mergeSort(0,arr.length-1);
		
		for(int a : arr) {
			builder.append(a);
		}
		
		if(String.valueOf(builder).substring(0, 1).equals("0")) {
			System.out.println("0");
		}else {
			System.out.println(String.valueOf(builder));
		}
		

	}//main

	private static void mergeSort(int left, int right) {
		if(left<right) {
			
			int mid = left + (right-left)/2;
			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,mid,right);
			
			
		}
		
		
	}

	private static void merge(int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while(i <= mid && j <= right) {
			
			int compareValue = (arr[i]+""+arr[j]).compareTo(arr[j]+""+arr[i]); //음수면 앞 조건이 작은거 양수면 뒤 조건이 작은거
			
			if(compareValue < 0) {
				copyArr[k++] = arr[j++];
			}else {
				copyArr[k++] = arr[i++];
			}
		}
		
		if(i>mid) {
			
			while(j<=right) {
				copyArr[k++] = arr[j++];
			}
			
		}else {
			
			while(i<=mid) {
				copyArr[k++] = arr[i++];
			}
			
		}
			
		for(int a = left; a <= right; a++) {
			arr[a] = copyArr[a];
		}
		
	}

}
