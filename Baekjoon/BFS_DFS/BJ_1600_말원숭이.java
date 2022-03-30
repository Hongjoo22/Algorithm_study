import java.io.*;
import java.util.*;

public class BJ_1600_말원숭이 {

	static int R,C,K;
	static int[][] map;
	static int[] dr= {-1,0,1,0}; // 원숭이
	static int[] dc= {0,1,0,-1};
	static int[] mr = {-2,-1,1,2,2,1,-1,-2}; // 말
	static int[] mc = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<Monkey> qu = new LinkedList<>();
		qu.offer(new Monkey(0,0,0,K));
		boolean[][][] v = new boolean[R][C][31]; // k는 0~30
		v[0][0][0] = true;
		while(!qu.isEmpty()) {
			Monkey mon = qu.poll();
			int cr = mon.r;
			int cc= mon.c;
			int cnt = mon.cnt; // 이동횟수
			int ck = mon.k; // 남은 기회
			if(cr==R-1 && cc==C-1) {
				System.out.println(cnt);
				return;
			}
			if(!cango(cr,cc) || map[cr][cc]==1 || v[cr][cc][ck]) continue;
			v[cr][cc][ck]=true;
			//monkey
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				qu.offer(new Monkey(nr,nc,cnt+1,ck));				
			}
			if(ck==0) continue;
			for (int d = 0; d < 8; d++) {
				int nr = cr + mr[d];
				int nc = cc + mc[d];
				qu.offer(new Monkey(nr,nc,cnt+1,ck-1));				
			}
		}
		System.out.println(-1);
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
class Monkey{
	int r,c,cnt,k;
	public Monkey(int r, int c, int cnt, int k) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.k = k;
	}	
}