import java.util.Scanner;

public class BJ_10844_쉬운계단수 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int[][] dp = new int[N][10];
		
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if(j!=0 && j!=9) dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				else if(j==0) dp[i][j] = dp[i-1][j+1];
				else  dp[i][j] = dp[i-1][j-1];
			}
		}
		
		long answer = 0;
		
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[N-1][i]) % 1000000000;
		}
		
		System.out.println(answer);
	}

}
