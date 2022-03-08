import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이 {

	static int[][] map;
	static int white,blue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		white =0 ;
		blue =0 ;
		dfs(0,0,N);		
		System.out.println(white);
		System.out.println(blue);
	}
	private static void dfs(int r, int c, int n) {
		int sum=0;
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				sum+=map[i][j];
			}
		}
		if(sum==0) {
			white++;
			return;
		}
		else if(sum == n*n) {
			blue++;
			return;
		}
		else {
			int half=n/2;
			dfs(r,c,half);
			dfs(r+half,c,half);
			dfs(r,c+half,half);
			dfs(r+half,c+half,half);
		}
	}

}
