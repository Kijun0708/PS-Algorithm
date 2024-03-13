package baekjoon;

import java.util.*;
import java.io.*;
public class Main_2751_2{
	
	static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        arr =new int[N];
        for(int i =0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        quickSort(0, arr.length-1);
        for(int a : arr){
            builder.append(a).append("\n");
        }
        System.out.println(builder);
    }
    public static void quickSort(int l, int r){
        if(l<r){
            int p = partition(l,r);
            quickSort(l, p-1);
            quickSort(p+1,r);
        }
    }
    public static int partition(int l, int r){
        int pivot = arr[r];
        int i = l;
        for(int j=l; j<=r-1; j++){
            if(arr[j]<=pivot){
                swap(i, j);
                i++;
            }
        }swap(i, r);
        return i;
    }
    public static void swap(int i , int j){
        int tmp = arr[i];
        arr[i] =arr[j];
        arr[j] = tmp;
    }
        
    
}