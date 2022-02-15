import java.io.IOException;
import java.util.Scanner;

// DFS
public class Solution_D4_1226_미로2 {
	static int[][] map;
	static int start_r, start_c;
	static int final_r, final_c;
	static int  cango;
	static int N =16;
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			in.nextInt();
			map=new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] cs = in.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]=cs[j]-'0';
					if(map[i][j]==2) {
						start_r=i;
						start_c=j;
					}else if(map[i][j]==3) {
						final_r=i;
						final_c=j;
					}
				}
			}
			cango=0;		
			dfs(start_r,start_c);
			System.out.println("#"+t+" "+cango);			
		}
	}
	static int[] dr = {-1,0,1,0}; // 시계	방향
	static int[] dc = {0,1,0,-1};
	
	private static void dfs(int cr, int cc) {
		map[cr][cc]=-1;
		for (int d = 0; d <4; d++) {
			int nr = cr+dr[d];
			int nc = cc+dc[d];
			if(!check(nr, nc)) continue;
			if(final_r==nr && final_c==nc) { // base condition
				cango=1;
				return;			
			}
			if(map[nr][nc]==0) {
				dfs(nr,nc);
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
