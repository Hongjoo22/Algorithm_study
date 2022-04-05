import java.io.*;
import java.util.*;

public class Solution_5656_벽돌깨기 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, W, H, min;
	static int[][] map;
	static int[] sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sel = new int[N];
			min = Integer.MAX_VALUE;
			select(0);			
			System.out.println("#" + t + " "+min);
		}
	}

	private static void select(int cnt) {
		if(cnt==N) { // 중복순열로 던질 열의 순서 정하기
			int[][] arr = new int[H][W];
			for (int i = 0; i < map.length; i++) { // 시뮬레이션 돌릴 배열 깊은복사
				System.arraycopy(map[i], 0, arr[i], 0, arr[i].length);
			}			
			for (int j = 0; j < N; j++) {
				int r = 0;
				int c = sel[j];
				while(arr[r][c]==0) {
					r++;
					if(r==H-1) {
						break;
					}
				}
				boolean[][] v = new boolean[H][W];
				go(r, c, arr,v);
				check(arr,v);
			}
			int count=0;
			for (int i = 0; i < H; i++) { //개수세기
				for (int j = 0; j < W; j++) {
					if(arr[i][j]!=0) count++;
				}
			}
			min = Math.min(min, count);
			return;
		}
		for (int i = 0; i < W; i++) {
			sel[cnt]=i;
			select(cnt+1);
		}
	}
	private static void check(int[][] arr, boolean[][] v) {
		for (int i = 0; i < H; i++) { // 한번에 깨뜨리기
			for (int j = 0; j < W; j++) {
				if(arr[i][j]>0 && v[i][j]) arr[i][j]=0;
			}
		}

		for (int c = 0; c < W; c++) { // 벽돌내리기 여기가 어려움
			int r = H-1;
			while(r>0) {
				if(arr[r][c]==0) {
					int nr = r-1;
					while(nr>0 && arr[nr][c]==0) nr--;
					arr[r][c]=arr[nr][c];
					arr[nr][c]=0;
				}
				r--;
			}
		}

	}

	private static void go(int r, int c, int[][] arr, boolean[][] v) {		
		for (int d = 0; d < 4; d++) {
			for (int i = 0; i < arr[r][c]; i++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;
				if (!cango(nr, nc)|| v[nr][nc]) continue;
				v[nr][nc] = true;
				if (arr[nr][nc] > 0)
					go(nr, nc, arr, v);
			}
		}		
	}

	private static boolean cango(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}
}
