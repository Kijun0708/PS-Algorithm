package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991 {
	
	static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws IOException{


		BinarySearchTree tree = new BinarySearchTree();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		int N = Integer.parseInt(reader.readLine());


		for(int i =0; i<N; i++) {
			st = new StringTokenizer(reader.readLine());
			tree.createRoot(st.nextToken(),st.nextToken(),st.nextToken());

		}
		
		preorder(tree.root);
		builder.append("\n");
		inorder(tree.root);
		builder.append("\n");
		postorder(tree.root);
		
		System.out.println(builder.toString());
		
		

	}

	private static void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			builder.append(node.key);
		}
		
		
	}

	private static void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			builder.append(node.key);
			inorder(node.right);
		}
		
	}

	private static void preorder(Node node) {
		if(node != null) {
			builder.append(node.key);
			preorder(node.left);
			preorder(node.right);
		}
		
	}

}

class Node{
	public String key;
	public Node left;
	public Node right;
	
	public Node(String key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree{
	public Node root;
	
	public void createRoot(String key, String left, String right) {
		if(root==null) {
			root = new Node(key);
			
			if(!left.equals(".")) {
				root.left = new Node(left);
			}
			
			if(!right.equals(".")) {
				root.right = new Node(right);
				
			}
			
		} else {
			addNode(root, key, left, right);
		}
		
	}

	private void addNode(Node node, String key, String left, String right) {
		if(node == null) {
			return;
		}
		
		if(node.key.equals(key)) {
			if(!left.equals(".")) {
				node.left = new Node(left);
			}
			if(!right.equals(".")) {
				node.right = new Node(right);
			}
		} else {
			addNode(node.left, key, left , right);
			addNode(node.right, key, left , right);
		}
		
		
	}

	




}
