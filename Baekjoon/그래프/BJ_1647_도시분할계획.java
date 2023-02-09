import java.io.*;
import java.util.*;

public class BJ_1647_도시분할계획 {

	static int N,M, max;
	static ArrayList<ArrayList<Node>> matrix;
	static PriorityQueue<Node> pq;
	static boolean[] v;
	public static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			matrix.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new  StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			int c =  Integer.parseInt(st.nextToken());
			
			matrix.get(a).add(new Node(b, c));
			matrix.get(b).add(new Node(a, c));
		}
		
		pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		v = new boolean[N+1];
		long answer = 0;
		max  = 0;
		// MST에서 최대 cost 빼면 됨
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(v[node.idx]) continue;
			
			v[node.idx] = true;
			answer += node.cost;
			max = Math.max(max, node.cost);
			
			for(Node now : matrix.get(node.idx)) {
				if(!v[now.idx]) pq.add(new Node(now.idx,now.cost));
			}
			
		}
		
		System.out.println(answer - max);
	}

}
