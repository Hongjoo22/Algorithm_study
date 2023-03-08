import java.io.*;
import java.util.*;

public class BJ_14621_나만안되는연애 {

	static int N, M, count;
	static long answer;
	static char[] school;
	static boolean[] v;
	static ArrayList<ArrayList<Node>> list;
	static class Node implements Comparable<Node>{
		int idx;
		int dis;
		public Node(int idx, int dis) {
			super();
			this.idx = idx;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node node) {
			return this.dis-node.dis;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		school = new char[N+1];
		v = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			school[i] = st.nextToken().charAt(0);
		}
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Node(v,d));
			list.get(v).add(new Node(u,d));
		}
		
		// MST - Prim
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		
		answer = 0;
		// MST에 들어간 Node 개수 세기
		count = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
						
			if(v[node.idx]) continue;
			v[node.idx] = true;
			count++;
			for(Node now:list.get(node.idx)) {
				// w-m만 이어주기
				if(!v[now.idx] && school[node.idx]!=school[now.idx]) pq.add(new Node(now.idx, now.dis));
			}
			
			answer += node.dis;
			
		}
		
		System.out.println(count==N?answer:-1);
	}

	
}
