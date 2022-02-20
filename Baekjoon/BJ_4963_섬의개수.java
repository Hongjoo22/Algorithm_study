import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4963_섬의개수 {
	static int w,h;
	static int[][] map; 
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			w= Integer.parseInt(st.nextToken());
			h =Integer.parseInt(st.nextToken());
			if(w == 0 && h==0) break;
			map= new int[h][w];
			for (int i = 0; i < h; i++) {
				 st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			count=0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!(map[i][j]==-1) && map[i][j] ==1) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	private static void dfs(int r, int c) {
		map[r][c]=-1;
		
		for (int d = 0; d < 8; d++) {
			int nr = r+ dr[d];
			int nc = c + dc[d];
			if(!cango(nr,nc)) continue;
			if(map[nr][nc]==1 && map[nr][nc]!=-1) {
				dfs(nr,nc);
			}
		}
		
	}
	private static boolean cango(int r, int c) {
		return r>=0 && c>=0 && r<h && c<w;
	}

}
