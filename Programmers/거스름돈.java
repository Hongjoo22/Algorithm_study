import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        int[][] dp = new int[money.length+1][n+1];
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=money[i-1]){
                    dp[i][j] = (dp[i][j-money[i-1]]+dp[i-1][j])%1000000007;
                    // 현재 동전을 사용할 수 있는 최초 거스름돈
                    if(j==money[i-1]) dp[i][j]++;
                }else dp[i][j] = dp[i-1][j];
            }
        }        
        return dp[money.length][n];
    }
}
