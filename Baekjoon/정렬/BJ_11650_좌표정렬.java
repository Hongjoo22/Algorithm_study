import java.io.*;
import java.util.*;

public class BJ_11650_좌표정렬 {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o) {
			if(this.x == o.x) return this.y - o.y;
			else return this.x - o.x;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Node n = pq.poll();
			sb.append(n.x+" "+n.y+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
