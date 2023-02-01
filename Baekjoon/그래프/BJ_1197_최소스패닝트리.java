import java.io.*;
import java.util.*;

public class BJ_1197_최소스패닝트리 {

	static int V,E;
	static ArrayList<ArrayList<Node>> matrix;
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return this.cost-node.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		matrix = new ArrayList<>();
		
		for (int i = 0; i <= V; i++) {
			matrix.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			 st = new  StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			 int C = Integer.parseInt(st.nextToken());
			 
			 matrix.get(A).add(new Node(B,C));
			 matrix.get(B).add(new Node(A,C));
		}	
		
		// prim
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] v = new boolean[V+1];
		long answer = 0;
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(v[node.idx]) continue;
			
			v[node.idx] = true;
			answer += node.cost;
			for (Node idx: matrix.get(node.idx)) {
				if(!v[idx.idx]) pq.add(new Node(idx.idx,idx.cost));
			}
			
		}
		System.out.println(answer);
	}

}
