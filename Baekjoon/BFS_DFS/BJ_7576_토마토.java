import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<Node> qu = new LinkedList<Node>();

	static class Node {
		int r, c, distance;

		public Node(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					qu.add(new Node(i, j, 0));
			}
		}
	
		int max= -1;
		boolean succ= true;
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					succ =false;
					break;
				}
				if(max<map[i][j]) {
					max=map[i][j];
				}
			}if(!succ) break;	
		}
		System.out.println(succ?(max-1):(-1)); // 1에서 더했기때문에 max-1해준다.
	}

	private static void bfs() {
		while (!qu.isEmpty()) {
			Node node = qu.poll();
			for (int d = 0; d < 4; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				if (!cango(nr, nc) || map[nr][nc]==-1)
					continue;
				if(map[nr][nc]==0) {
					map[nr][nc]=map[node.r][node.c]+1;
					qu.add(new Node(nr,nc,map[nr][nc]));
				}
			}
		}
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
