class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        int answer = sticker[0];
        int[][] dp = new int[2][N+2];
        dp[0][2] = sticker[0];
        
        for(int i = 3; i<= N+1;i++){
            if(i==N+1){
                dp[0][i] = Math.max(dp[0][i-2],dp[0][i-3]);
                dp[1][i] = Math.max(dp[1][i-2],dp[1][i-3])+ sticker[i-2];     
            }else{
                dp[0][i] = Math.max(dp[0][i-2],dp[0][i-3]) + sticker[i-2];
                dp[1][i] = Math.max(dp[1][i-2],dp[1][i-3]) + sticker[i-2];      
            }
           answer = Math.max(answer,Math.max(dp[0][i],dp[1][i]));
        }
        return answer;
    }
}
