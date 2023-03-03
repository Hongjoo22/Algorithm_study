import java.io.*;
import java.util.*;

public class BJ_16139_인간컴퓨터상호작용2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine().trim();
		// 누적합 (자리수 조심!)
		int[][] dp = new int[26][str.length()+1];
		
		for (int i = 0; i < str.length(); i++) {
			dp[str.charAt(i)-'a'][i+1]++;
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] += dp[i][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char cs = st.nextToken().charAt(0);
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int answer = dp[cs-'a'][e+1] - dp[cs-'a'][s];
			
			sb.append(answer+"\n");
		}
		
		System.out.print(sb.toString());
	}

}
