import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {

	static int R, C;
	static char[][] map;
	static int[][] time;
	static int[][] fire;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean poss;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		time = new int[R][C];
		fire = new int[R][C];
		Queue<int[]> ju = new LinkedList<int[]>();
		Queue<int[]> fu = new LinkedList<int[]>();
		for (int i = 0; i < R; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = cs[j];
				if (map[i][j] == 'J') {
					time[i][j]=1;
					ju.add(new int[] {i,j});
				} else if (map[i][j] == 'F') {
					fire[i][j]=1;
					fu.add(new int[] {i,j});
				}else if(map[i][j]=='.') {
					fire[i][j]=-1;
					time[i][j]=-1;
				}
			}
		}
		
		poss = false;
		
		while (!fu.isEmpty()) {
			int[] curr = fu.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!cango(nr, nc) || map[nr][nc] == '#' || fire[nr][nc]>=1)
					continue;			
				fire[nr][nc]=fire[cr][cc]+1;
				fu.add(new int[] { nr, nc });
				
			}
		}
		
		while (!ju.isEmpty()) {
			int[] curr = ju.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if(!cango(nr, nc) ) {
					System.out.println(time[cr][cc]);
					return;
				}
				if (map[nr][nc] == '#' || time[nr][nc]>=1)
					continue;
				if(fire[nr][nc] != -1 && time[cr][cc]+1 >= fire[nr][nc]) continue;			
				time[nr][nc] = time[cr][cc] + 1;
				ju.add(new int[] { nr, nc });			
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
