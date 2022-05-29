import java.io.*;
import java.util.*;

public class BJ_16234_인구이동 {

	static int N,L,R, day;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] v;
	static boolean go;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		day = 0;
		while(true) {
			
			v = new boolean[N][N];
			go = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!v[i][j]) {
						bfs(i,j);
					}
				}
			}
			if(go==false) break;
			day++;
		}
		
		System.out.println(day);
	}
	private static void bfs(int r, int c) {
		int count=0;
		int kingdom=0;
		ArrayList<int[]> list=  new ArrayList<>();
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {r,c});
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			v[cur[0]][cur[1]] = true;
			count += map[cur[0]][cur[1]];
			kingdom++;
			list.add(new int[] {cur[0],cur[1]});
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr<0 || nc<0 || nr>=N || nc>=N || v[nr][nc]) continue;
				int dis = Math.abs(map[nr][nc]-map[cur[0]][cur[1]]);
				if(dis>=L && dis<=R) {
					v[nr][nc] = true;
					qu.add(new int[] {nr,nc});
				}
				
			}
		}
		int tmp = count/kingdom;
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = tmp;
		}
		if(kingdom>1) go = true;
	}
}
