class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        // 누적합
        int[][] dp = new int[board.length+1][board[0].length+1];
        for(int i =0;i<skill.length;i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            // 공격
            int m = 1;
            if(type==1) m = -1;
            
            dp[r1][c1] += degree*m;
            dp[r2+1][c1] -= degree*m;
            dp[r1][c2+1] -= degree*m;
            dp[r2+1][c2+1] += degree*m;
        }
        // 행 -> 열 순으로 누적합
        for(int r=0;r<dp.length;r++){
            for(int c=1;c<dp[0].length;c++){
               dp[r][c] += dp[r][c-1];
            }
        }
        for(int c=0;c<dp[0].length;c++){
            for(int r=1;r<dp.length;r++){
               dp[r][c] += dp[r-1][c];
            }
        }
        
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                board[r][c] += dp[r][c];
                if(board[r][c]>0) answer++;
            }
        }
        
        return answer;
    }
}
