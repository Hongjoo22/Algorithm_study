import java.io.*;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크 {

	static final int INF = 99999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j && map[i][j]==0) map[i][j]=INF;
				}
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if(i==k) continue;
					for (int j = 0; j < N; j++) {
						if(j==k || i==j) continue;
						if(map[i][j]>map[i][k]+map[k][j]) {
							map[i][j]=map[i][k]+map[k][j];
						}
					}
				}
			}
			int min  = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum+=map[i][j];
				}
				if(min>sum) min = sum;
			}			
			System.out.println("#"+t+" "+min);
		}
	}

}
