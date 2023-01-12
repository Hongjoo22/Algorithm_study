class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] D = new int[n+1][m+1];
       
        // 집출발부터 막히는 경우를 위해 집만 1 처리
        D[1][1] = 1;
        for(int i = 0; i<puddles.length;i++){
           D[puddles[i][1]][puddles[i][0]] = -1;        
        }
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(i==1 && j==1) continue;
                if(D[i][j] == -1) D[i][j] = 0;
                else D[i][j] = (D[i-1][j] + D[i][j-1])%1000000007;
            }
        }
       
        return D[n][m];
    }
}
