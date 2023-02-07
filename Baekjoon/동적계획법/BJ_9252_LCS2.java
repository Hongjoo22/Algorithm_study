import java.io.*;

public class BJ_9252_LCS2 {

	static String str1, str2;
	static int N1, N2;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		N1 = str1.length();
		N2 = str2.length();
		dp = new int[N1+1][N2+1];
		
		
		for (int i = 1; i <= N1; i++) {
			for (int j = 1; j <= N2; j++) {
				// 둘 다 포함안된 문자열 기준 최대값은 i-1,j-1 임
				if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
				// 둘 중에 하나 포함한 것 중 최댓값으로
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N1][N2]);
		StringBuilder sb = new StringBuilder();
		print(sb,N1,N2);
		System.out.println(sb.toString());
	}
	private static void print(StringBuilder sb, int i, int j) {
		if(i<1 || j<1) return;
		if(str1.charAt(i-1)==str2.charAt(j-1)) {
			print(sb,i-1,j-1);
			sb.append(str1.charAt(i-1));
		}else {
			if(dp[i-1][j]>dp[i][j-1]) print(sb,i-1,j);
			else print(sb,i,j-1);
		}		
	}

}
