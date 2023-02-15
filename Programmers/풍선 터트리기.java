import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int N = arr.length;
      
        // 각 인덱스 별로 좌우 최솟값 비교
        int[][] dp = new int[N][2];
        dp[0][0] = arr[0];
        dp[N-1][1] = arr[N-1];
        
        for(int i=1;i <N-1;i++){
          // 왼쪽 제일 작은 수
          dp[i][0] = Math.min(dp[i-1][0],arr[i-1]);
          // 오른쪽 제일 작은 수
          dp[N-1-i][1] = Math.min(dp[N-i][1],arr[N-i]);        
        }
        for(int i=0; i < N; i++){
          // 인덱스 기준 좌우에 둘다 나보다 작은 수가 있으면 안된다.   
          if(dp[i][0]<arr[i] && dp[i][1]<arr[i]) continue;
          answer++;
        }
        
        return answer;
    }
}
