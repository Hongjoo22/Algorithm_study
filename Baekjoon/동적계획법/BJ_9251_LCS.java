import java.io.*;

public class BJ_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		String str2 = br.readLine().trim();
		int N  = str.length();
		int M  = str2.length();
		int[][] lcs = new int[N+1][M+1];		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(str.charAt(i-1)==str2.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else {
					lcs[i][j]= Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
 		System.out.println(lcs[N][M]);
	}
}
