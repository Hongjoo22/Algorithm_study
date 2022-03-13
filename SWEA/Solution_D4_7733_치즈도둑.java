import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑 {

	static int N,max,count;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			max=-1;			
			for (int k = 0; k <= 100; k++) {
				v=new boolean[N][N];
				count=0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]==k) {						
							map[i][j]=-1;
						}
					}					
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]>k && !v[i][j]) {						
							dfs(i,j,k);
							count++;
						}
					}					
				}
				max=Math.max(max,count);			
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

	private static void dfs(int r,int c, int k) {	
		v[r][c]=true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc =c + dc[d];
			if(!cango(nr,nc) || map[nr][nc] ==-1 || v[nr][nc]) continue;
			if(map[nr][nc]>k) {
				dfs(nr,nc,k);
			}						
		}
	}

	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
