import java.io.*;
import java.util.*;

public class BJ_1197_최소스패닝트리2 {

	static int V,E;
	static PriorityQueue<Node> lines;
	static int[] parents;
	static class Node implements Comparable<Node>{
		int idx;
		int idx2;
		int cost;
		
		public Node(int idx,int idx2, int cost) {
			super();
			this.idx = idx;
			this.idx2 = idx2;
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
		lines = new PriorityQueue<>();
		parents = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < E; i++) {
			 st = new  StringTokenizer(br.readLine());
			 int A = Integer.parseInt(st.nextToken());
			 int B = Integer.parseInt(st.nextToken());
			 int C = Integer.parseInt(st.nextToken());
			
			 lines.add(new Node(A,B,C));
		}	
		
		// kruskal
		long answer = 0;
		int cnt = 0;
		while(cnt < V-1) {
			Node node = lines.poll();
			
			if(isUnion(node.idx, node.idx2))  continue;
			
			Union(node.idx, node.idx2);
			answer += node.cost;
			cnt++;
		}
		
		
		System.out.println(answer);
	}
	
	private static int find(int x) {
		if(x==parents[x]) return x;
		else return parents[x] = find(parents[x]);
	}
	
	private static void Union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return;
		
		if(x<y) {
			parents[y]=x;
		}else {
			parents[x]=y;
		}
	}
	private static boolean isUnion(int x, int y) {
		// find 조심!
		x = find(x);
		y = find(y);
		
		if(x==y) return true;
		
		return false;
	}

}
