import java.io.*;
import java.util.*;

public class BJ_14499_주사위굴리기 {

	static int N, M, K, r, c;
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[] dice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 1은 윗면 6은 아랫면
		dice = new int[7];

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());

			int nr = r + dr[d];
			int nc = c + dc[d];

			// 범위 넘어가면 무시
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

			// 전개도의 위치를 바꾼다
			if(d==1) change(dice[1],1,4,6,3);
			else if(d==2) change(dice[1],1,3,6,4);
			else if(d==3) change(dice[1],1,2,6,5);
			else change(dice[1],1,5,6,2);

			// 이동한 칸 수가 0이면, 주사위 바닥면 수를 복사
			if (map[nr][nc] == 0) {
				map[nr][nc] = dice[6];
			} else {
				// 0이 아니면, 칸->주사위 바닥면 복사 후 칸의 수는 0
				dice[6] = map[nr][nc];
				map[nr][nc] = 0;
			}

			// 주사위 윗면 출력
			sb.append(dice[1]+"\n");
			r = nr;
			c = nc;
		}
		
		System.out.print(sb.toString());
	}
	
	public static void change (int tmp, int a, int b, int c, int d) {
		dice[a] = dice[b];
		dice[b] = dice[c];
		dice[c] = dice[d];
		dice[d] = tmp;
	}

}
