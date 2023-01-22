import java.util.Scanner;

public class BJ_12852_1로만들기2 {

	static int[][] dp;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		
		// 값, idx를 저장
		dp = new int[X+1][2];
			
		for (int i = 2; i <= X; i++) {
			
			if(i%3==0) {
				if(i%2==0) {
					if(dp[i/3][0] < dp[i/2][0]) {
						dp[i][0] = dp[i/3][0]+1;
						dp[i][1] = i/3;
					}else {
						dp[i][0] = dp[i/2][0]+1;
						dp[i][1] = i/2;
					}
				}else {
					dp[i][0] = dp[i/3][0]+1;
					dp[i][1] = i/3;
				}
			}else if(i%2==0) {
				dp[i][0] = dp[i/2][0]+1;
				dp[i][1] = i/2;
			}
			
			// 둘다 안나누어 떨어지면 그전의 수+1을 해주거나 값 비교 후 갱신
			if(dp[i][0] > dp[i-1][0]+1 || dp[i][0]==0) {
				dp[i][0] = dp[i-1][0]+1;
				dp[i][1] = i-1;
			}
		}
		sb = new StringBuilder();
		makeAnswer(X);
		System.out.println(dp[X][0]);
		System.out.println(sb.toString());
	}

	private static void makeAnswer(int x) {
		if(x==1) {
			sb.append(x);
			return;
		}
		sb.append(x+" ");
		makeAnswer(dp[x][1]);
	}

}
