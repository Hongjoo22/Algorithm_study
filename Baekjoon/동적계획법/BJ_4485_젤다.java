import java.io.*;
import java.util.*;

public class BJ_4485_젤다 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int idx = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				return;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] D = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			bfs(map, D);
			StringBuilder sb = new StringBuilder();
			sb.append("Problem " + idx + ": " + D[N - 1][N - 1]);
			System.out.println(sb);
			idx++;
		}
	}

	private static void bfs(int[][] map, int[][] D) {
		PriorityQueue<Node> qu = new PriorityQueue<>();
		qu.add(new Node(0, 0, map[0][0]));
		D[0][0] = map[0][0];
		while (!qu.isEmpty()) {
			Node node = qu.poll();
			int cr = node.r;
			int cc = node.c;
			int cv = node.v;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!cango(nr, nc))
					continue;
				if (D[nr][nc] > map[nr][nc] + cv) {
					qu.add(new Node(nr, nc, map[nr][nc] + cv));
					D[nr][nc] = map[nr][nc] + cv;
				}
			}
		}
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}

class Node implements Comparable<Node> {
	int r, c, v;

	public Node(int r, int c, int v) {
		super();
		this.r = r;
		this.c = c;
		this.v = v;
	}

	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}
}