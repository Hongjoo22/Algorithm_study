import java.io.*;
import java.util.StringTokenizer;

public class Solution_1865_일분배 {

	static double[][] map;
	static int N;
	static double res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new  double[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Double.parseDouble(st.nextToken());
					map[i][j]/=100;
				}
			}
			boolean[] v = new boolean[N];
			res = 0.000000;
			dfs(v,0,1.0);
			res*=100;
			System.out.printf("#%d  %.6f\n",t,res);
		}
	}
	private static void dfs(boolean[] v, int count, double tmp) {
		if(tmp <= res) return; // 곱할수록 작아짐
		
		if(count==N) {
			res = Math.max(res, tmp);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			dfs(v,count+1,tmp*map[count][i]);
			v[i] = false;
		}
	}
}
