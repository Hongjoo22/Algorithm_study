import java.io.*;
import java.util.*;

public class BJ_1194_달이차오른다 {

	static int N,M,sr,sc,min;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M][0b111111+1];
		for (int i = 0; i < N; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				char tmp = cs[j];
				if(tmp=='0') {
					sr = i;
					sc = j;
					map[i][j]=0;
				}else if(tmp=='1') {
					map[i][j]=1;
				}else if(tmp=='#') {
					map[i][j]=2;
				}else if(tmp=='.') {
					map[i][j]=3;
				}else if(tmp>='A' && tmp<='F') {
					map[i][j]=cs[j]-'A'+4;
				}else if(tmp>='a' && tmp<='f') {
					map[i][j]=cs[j]-'a'+10;
				}
			}
		}	
		
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min == Integer.MAX_VALUE?-1:min);
	}
	private static void bfs() {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] {sr,sc,0,0});
		v[sr][sc][0]=true;
		while(!qu.isEmpty()) {
			int[] cur = qu.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				int nk = cur[3];
				if(!cango(nr,nc) || map[nr][nc]==2) continue;
				if(map[nr][nc]==1) {
					min = cur[2]+1;
					return ;
				}
				if(map[nr][nc]>=4 && map[nr][nc]<=9) {
					if((cur[3] & (1<<map[nr][nc]-4))==0) continue;
				}
				if(map[nr][nc]>=10 && map[nr][nc]<=15) {
					nk = cur[3] | (1<<map[nr][nc]-10);
				}
				if(v[nr][nc][nk]) continue;
				v[nr][nc][nk] = true;
				qu.add(new int[] {nr,nc,cur[2]+1,nk});
			}
		}
	}
	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
