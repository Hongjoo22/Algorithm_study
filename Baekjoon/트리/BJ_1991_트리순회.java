import java.io.*;
import java.util.*;

public class BJ_1991_트리순회 {

	static class Node {
		char idx;
		Node left,right;
		Node(char idx){
			this.idx = idx;
		}
	}
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N];
		char root = 'A';
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(root++);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char self = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if(left!='.') nodes[self-'A'].left = nodes[left-'A'];
			if(right!='.') nodes[self-'A'].right = nodes[right-'A'];
		}
		sb = new StringBuilder();
		Node now = nodes[0];
		preOrder(now);
		sb.append("\n");
		inOrder(now);
		sb.append("\n");
		postOrder(now);
		sb.append("\n");
		System.out.println(sb);
	}
	// 전위
	private static void preOrder(Node now) {
		sb.append(now.idx);
		if(now.left!=null) preOrder(now.left);
		if(now.right!=null) preOrder(now.right);
	}
	//중위
	private static void inOrder(Node now) {
		if(now.left!=null) inOrder(now.left);
		sb.append(now.idx);
		if(now.right!=null) inOrder(now.right);
	}
	//후위
	private static void postOrder(Node now) {
		if(now.left!=null) postOrder(now.left);
		if(now.right!=null) postOrder(now.right);
		sb.append(now.idx);
	}
}
