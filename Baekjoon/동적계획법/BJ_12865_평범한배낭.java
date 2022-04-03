import java.io.*;
import java.util.*;

public class BJ_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 총무게
		int[][] bag = new int[N][2];
		int[][] D = new int[N+1][K+1];
		for (int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			bag[i][0] = Integer.parseInt(st.nextToken()); //무게
			bag[i][1] = Integer.parseInt(st.nextToken()); //가치
		}
		for (int i = 1; i <= N; i++) {
			int wei = bag[i-1][0];
			int val = bag[i-1][1];
			for (int j = 1; j <= K; j++) {
				if(wei<=j) {
					D[i][j] = Math.max(D[i-1][j], D[i-1][j-wei]+val);
				}else {
					D[i][j] = D[i-1][j];
				}
			}
		}	
		System.out.println(D[N][K]);
	}
}