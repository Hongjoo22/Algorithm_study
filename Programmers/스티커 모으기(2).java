class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        // 길이가 1인 경우 예외처리
        int answer = sticker[0];
        int[][] dp = new int[2][N+1];
        // 첫번째 스티커를 뗀경우
        dp[0][1] = sticker[0];
        
        for(int i = 2; i<= N;i++){
            // 첫번째 스티커를 뗀경우
            if(i==N){
                dp[0][i] = Math.max(dp[0][i-1],dp[0][i-2]);    
            }else{
                dp[0][i] = Math.max(dp[0][i-1],dp[0][i-2] + sticker[i-1]);   
            }
            // 2번째부터 뗀경우
            dp[1][i] = Math.max(dp[1][i-1],dp[1][i-2]+ sticker[i-1]); 
           answer = Math.max(answer,Math.max(dp[0][i],dp[1][i]));
        }
        return answer;
    }
}
