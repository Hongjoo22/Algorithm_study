import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {

	static int N, M, count;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) count++;
			}
		}
		int time=0;
		int res =0;
		while(count!=0) {
			time++;
			res=count;
			bfs();
		}
		System.out.println(time);
		System.out.println(res);
	}

	private static void bfs() {
		Queue<int[]> qu = new LinkedList<>();		
		qu.add(new int[] { 0, 0 });
		v = new boolean[N][M];
		v[0][0]=true;		
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			int cr = cur[0];
			int cc = cur[1];			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!cango(nr, nc) || v[nr][nc]) continue;					
				if(map[nr][nc]==1) {
					count--;
					map[nr][nc]=0;
				}
				else if (map[nr][nc] == 0) {
					qu.add(new int[] {nr,nc});					
				}
				v[nr][nc]=true;
			}
		}
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
