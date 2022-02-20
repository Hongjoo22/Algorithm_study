import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_2667_단지번호 {

	static int N, count, tmp;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 }; 
	static int[] dc = { 0, 1, 0, -1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		List<Integer> li = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			char[] cs = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = cs[j] - '0';
			}
		}		
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j]==1) {
					tmp = 0;
					dfs(i,j);
					count++;
					li.add(tmp);
				}
			}
		}	
		Collections.sort(li);
		System.out.println(count);
		for(Integer a:li) {
			System.out.println(a);
		}
	}
	
	private static void dfs(int r, int c) {
		v[r][c] = true;
		tmp++;
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(!check(nr,nc)) continue;
			if(!v[nr][nc] && map[nr][nc]==1) {
				dfs(nr,nc);				
			}
		}
	}
	private static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
