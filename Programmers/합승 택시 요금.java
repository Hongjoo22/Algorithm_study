import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] floyd = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            Arrays.fill(floyd[i], 9999999);
            floyd[i][i] = 0;
        }
        
        for(int i = 0; i < fares.length; i++){
            floyd[fares[i][0]][fares[i][1]] = fares[i][2];
            floyd[fares[i][1]][fares[i][0]] = fares[i][2];
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                if(i==k) continue;
                for(int j=1;j<=n;j++){
                    if(k==j || i==j) continue;
                    if(floyd[i][k]+floyd[k][j] < floyd[i][j]){
                        floyd[i][j] = floyd[i][k]+floyd[k][j];
                    }
                }
            }
        }
        
        for(int k=1;k<=n;k++){
            // 합승마지막 지점 k
            answer = Math.min(answer,floyd[s][k]+floyd[k][a]+floyd[k][b]);
        }
        
        return answer;
    }
    
}
