import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15683_감시 {
	static int N, M, K;
	static int[][] map;
	static int count;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<cctv> cv = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cv.add(new cctv(i, j, map[i][j]));
				}
			}
		}
		count = Integer.MAX_VALUE;
		K = cv.size();

		dfs(map, 0);

		System.out.println(count == Integer.MAX_VALUE ? 0 : count);
	}

	private static void dfs(int[][] nmap, int idx) {
		if (idx == K) {
			int tot = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (nmap[i][j] == 0)
						tot++;
				}
			}
			count = Math.min(count, tot);
			return;
		}
		int cr = cv.get(idx).r;
		int cc = cv.get(idx).c;
		int type = cv.get(idx).t;
		int[][] vMap = new int[N][M];
		switch (type) {
		case 1:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nmap[i], M);
				}
				gosharp(cr, cc, d, vMap); // 4방향체크
				dfs(vMap, idx + 1);
			}
			break;
		case 2:
			for (int d = 0; d < 2; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nmap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d + 2) % 4, vMap);
				dfs(vMap, idx + 1);
			}
			break;
		case 3:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nmap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d + 1) % 4, vMap);
				dfs(vMap, idx + 1);
			}
			break;
		case 4:
			for (int d = 0; d < 4; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nmap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d + 1) % 4, vMap);
				gosharp(cr, cc, (d + 2) % 4, vMap);
				dfs(vMap, idx + 1);
			}
			break;
		case 5:
			for (int d = 0; d < 1; d++) {
				for (int i = 0; i < N; i++) {
					vMap[i] = Arrays.copyOf(nmap[i], M);
				}
				gosharp(cr, cc, d, vMap);
				gosharp(cr, cc, (d + 1) % 4, vMap);
				gosharp(cr, cc, (d + 2) % 4, vMap);
				gosharp(cr, cc, (d + 3) % 4, vMap);
				dfs(vMap, idx + 1);
			}
			break;

		}
	}

	private static void gosharp(int r, int c, int d, int[][] mm) {
		while (true) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!cango(nr, nc))
				break;
			if (mm[nr][nc] == 6)
				break;
			if (mm[nr][nc] == 0)
				mm[nr][nc] = -1;
			r = nr;
			c = nc;
		}
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}

class cctv {
	int r;
	int c;
	int t;

	cctv(int r, int c, int t) {
		this.r = r;
		this.c = c;
		this.t = t;
	}
}