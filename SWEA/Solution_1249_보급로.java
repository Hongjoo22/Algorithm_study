import java.io.*;
import java.util.*;

public class Solution_1249_보급로 {	
	static class Node implements Comparable<Node>{
		int r,c,cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt-o.cnt;
		}
		
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] D = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] cs = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = cs[j]-'0';
					D[i][j] = Integer.MAX_VALUE;
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0,0,map[0][0]));
			D[0][0]=map[0][0];
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				int r = cur.r;
				int c = cur.c;
				int cnt = cur.cnt;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c+ dc[d];
					if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
					if(D[nr][nc]>D[r][c]+cnt) {
						D[nr][nc]=D[r][c]+cnt;
						pq.add(new Node(nr,nc,map[nr][nc]));
					}
				}
			}
			
			System.out.println("#"+t+" "+D[N-1][N-1]);
		}
	}
}
