import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1219_길찾기 {

	static int[][] map;
	static boolean[][] v;
	static boolean cango;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			map = new int[100][100];
			v = new boolean[100][100];
			st = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < N; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			cango=false;
			dfs(0);
			int res = cango?1:0;
			System.out.println("#"+T+" "+res);
		}
	}
	private static void dfs(int x) {
		for (int i = 0; i < 100; i++) {
			if(map[x][i]==1 && !v[x][i]) {
				v[x][i]=true;
				if(i==99) {
					cango=true;
					return;
				}
				dfs(i);
			}
		}
	}

}
