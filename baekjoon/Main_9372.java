package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9372 {
	
	public static void main(String[] args) throws IOException{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		StringTokenizer st;
		
		
		int T = Integer.parseInt(reader.readLine());
		int N = 0;
		int M = 0;
		int a = 0;
		int b = 0;
		
		for(int i =0; i<T; i++) {
			BinarySearchTree tree = new BinarySearchTree();
			st = new StringTokenizer(reader.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(reader.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
//				tree.insert(a);
//				tree.insert(b);
//				
//			}
//			builder.append(tree.getSize()-1+"\n");
			
			
		}
		
		System.out.println(builder.toString());
		
		
		
		
		

		
		
	}//main

}

//class Node{
//	public int key;
//	public Node left;
//	public Node right;
//	
//	public Node(int key) {
//		this.key = key;
//		this.left = null;
//		this.right = null;
//	}
//}
//
//class BinarySearchTree{
//	public Node root;
//	public int size;
//	
//	public BinarySearchTree() {
//		this.root = null;
//		this.size = 0;
//	}
//	
//	public void insert(int key) {
//		this.root = insertNode(this.root,key);
//	
//		
//	}
//	
//	public Node insertNode(Node root, int key) {
//		if(root==null) {
//			root = new Node(key);
//			size++;
//			return root;
//		}
//		
//		if(key < root.key) {
//			root.left = insertNode(root.left,key);
//		}else if(key > root.key) {
//			root.right = insertNode(root.right, key);
//		}else if( key == root.key) {
//			return root;
//		}
//		
//		return root;
//		
//	}
//	
//	public int getSize() {
//		return this.size;
//	}
	

	
	
}
