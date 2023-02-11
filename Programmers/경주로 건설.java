import java.util.*;
class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    
    public class Block{
        int r;
        int c;
        int cost;
        // 전 dir
        int dir;
        
        public Block(int r, int c, int cost, int dir){
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] dp = new int[N][N][4];
        for(int i=0;i< N;i++){
            for(int j =0; j<N;j++){
                 Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        // pq도 그냥 bfs도 반례가 있다. 3차원 dp 배열로만 풀림
        Queue<Block> pq = new LinkedList<>();        
        pq.add(new Block(0,0,0,-1));
        
        while(!pq.isEmpty()){
            Block block = pq.poll();
            int r = block.r;
            int c = block.c;
            
            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0 && nc>=0 && nr<N && nc<N && board[nr][nc]==0){                  
                    int next = block.cost;
                    // 코너면 500 + 100
                    if(block.dir>=0 && (d%2 != block.dir%2)){
                       next += 600;
                    }else{
                        // 직선이면 100
                        next += 100;
                    }
                    if(dp[nr][nc][d] > next){
                        dp[nr][nc][d] = next;
                        pq.add(new Block(nr,nc,next,d));
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int d=0; d<4; d++){
            answer = Math.min(answer, dp[N-1][N-1][d]);
        }
        return answer;
    }
}
