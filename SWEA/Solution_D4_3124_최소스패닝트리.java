import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리 {
	static class Edge implements Comparable<Edge>{

		int from,to,weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
	}
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			Edge[] list = new Edge[E];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[i] = new Edge(from,to,weight);
			}
			Arrays.sort(list);
			makeset(V);
			
			int cnt=0;
			long res=0; // 자료크기가 크니 long으로
			for (Edge edge:list ) {
				if(union(edge.from, edge.to)) {
					res += edge.weight;
					if(++cnt == V-1) break; // 간선개수가 V-1이면 끝
				}
			}			
			System.out.println("#"+t+" "+res);
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
 
	private static int findSet(int a) {
		if(parents[a]==a) return a;
		else return findSet(parents[a]);
	}

	private static void makeset(int V) {
		parents = new int[V+1];
		for (int i = 1; i <= V; i++) {
			parents[i]=i;
		}
	}

}
