import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5427_불 {

	static int R,C;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			int[][] time = new int[R][C];
			int[][] fire = new int[R][C];
			
			Queue<int[]> moving = new LinkedList<int[]>();
			Queue<int[]> fm = new LinkedList<int[]>();
			
			for (int i = 0; i < R; i++) {
				char[] cs = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j]=cs[j];
					if(map[i][j]=='@') {
						time[i][j]=1;
						moving.add(new int[] {i,j});
					}else if(map[i][j]=='*') {
						fire[i][j]=1;
						fm.add(new int[] {i,j});
					}else { // # .
						time[i][j]=-1;
						fire[i][j]=-1;
					}
				}
			}
			// fire first
			while(!fm.isEmpty()) {
				int[] curr = fm.poll();
				int cr = curr[0];
				int cc = curr[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr+dr[d];
					int nc = cc+dc[d];
					if(!cango(nr,nc) || map[nr][nc]=='#') continue;
					if(fire[nr][nc]>=1) continue;
					fire[nr][nc]=fire[cr][cc]+1;
					fm.add(new int[] {nr,nc});
				}				
			}
			// moving
			boolean cango = false;
			out: while(!moving.isEmpty()) {
				int[] curr = moving.poll();
				int cr = curr[0];
				int cc = curr[1];
				for (int d = 0; d < 4; d++) {
					int nr = cr+dr[d];
					int nc = cc+dc[d];
					if(!cango(nr,nc)) { 
						System.out.println(time[cr][cc]);
						cango=true;
						break out;				
					}
					if(map[nr][nc]=='#'|| time[nr][nc]>=1)continue;
				    if(fire[nr][nc]!=-1 && time[cr][cc]+1 >= fire[nr][nc]) continue; // 불이지나간자리 조심..
					time[nr][nc]=time[cr][cc]+1;
					moving.add(new int[] {nr,nc});
				}				
			}
			if(!cango) System.out.println("IMPOSSIBLE");			
		}
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}

}
