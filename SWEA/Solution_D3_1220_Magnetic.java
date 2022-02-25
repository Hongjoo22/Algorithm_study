import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2는 위로 1은 아래로
public class Solution_D3_1220_Magnetic {
	static class Node{
		int r,c,type;
		public Node(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			Queue<Node> qu = new LinkedList<Node>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) qu.add(new Node(i,j,map[i][j]));
				}
			}
			int count=0;
			while(!qu.isEmpty()) {
				int r = qu.peek().r;
				int c = qu.peek().c;
				int type = qu.peek().type;
				if(type==1) {
					if(!cango(r+1,c)) {
						Node node = qu.poll();
						map[node.r][node.c]=0;
						continue;
					}
					if(map[r+1][c]==0) {
						Node node = qu.poll();
						map[node.r][node.c]=0;
						map[node.r+1][node.c] = 1;
						qu.add(new Node(node.r+1,node.c,node.type));
						continue;
					}
					if(map[r+1][c]==2 || map[r+1][c]==1) {
						qu.poll();
					}
				}else {
					if(!cango(r-1,c)) {
						Node node = qu.poll();
						map[node.r][node.c]=0;
						continue;
					}
					if(map[r-1][c]==0) {
						Node node = qu.poll();
						map[node.r][node.c]=0;
						map[node.r-1][node.c] = 2;
						qu.add(new Node(node.r-1,node.c,node.type));
						continue;
					}
					else if(map[r-1][c]==1) {
						count++;
						qu.poll();
					}else qu.poll();
				}
			}
			System.out.println("#"+t+" "+count);
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 &&  r<100 && c<100;
	}

}
