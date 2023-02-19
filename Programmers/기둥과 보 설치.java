import java.util.*;
class Solution {
    // 빡구현 문제
    public ArrayList<int[]> solution(int n, int[][] build_frame) {
        ArrayList<int[]> answer = new ArrayList<>();
        // 시계방향 (위,아래는 기둥)(왼,오는 보)
        int[][][] map = new int[n+1][n+1][4];
        for(int i=0;i<build_frame.length;i++){
            int c = build_frame[i][0];
            int r = n - build_frame[i][1];
            int type = build_frame[i][2];
            int Case = build_frame[i][3];
            
            // 삭제 (어려움)
            if(Case==0){
                // 기둥
                if(type==0){
                    // 위에 기둥이 있을때 왼쪽이나 오른쪽에 보가 둘다 없으면 무시
                    if(map[r-1][c][0] == 1 && map[r-1][c][1] == 0 && map[r-1][c][3] == 0) continue;
                    // 한쪽에 보가 있으면 양쪽에 보가 있는지 반대편에 기둥있는지 check
                    if(c<n && map[r-1][c][1] == 1) {
                        if((map[r-1][c][3]==0 || map[r-1][c+1][1]==0) && map[r-1][c+1][2] == 0) continue;
                    }
                    if(c>0 && map[r-1][c][3] == 1) {
                        if((map[r-1][c][1]==0 || map[r-1][c-1][3]==0) && map[r-1][c-1][2] == 0) continue;
                    }
                    map[r][c][0] = 0;
                    map[r-1][c][2] = 0;
                   
                }else{
                    // 보 (특히 주의)
                    // 양쪽 끝부분에 보가 하나라도 있으면 각각 check (아래쪽 기둥을 둘다 체크해줘야 함)
                    if(map[r][c+1][1]==1 && map[r][c+1][2]==0 && map[r][c+2][2]==0) continue;
                    if(map[r][c][3]==1 && map[r][c][2]==0 && map[r][c-1][2]==0) continue;
                    // 위에 기둥이 있으면 아래에 기둥 && 왼쪽에 보가 있는지 체크
                    if(map[r][c][0]==1 && map[r][c][2]==0 &&  map[r][c][3]==0) continue;
                    // 건너편 기둥 check
                    if(map[r][c+1][0]==1 && map[r][c+1][2]==0 &&  map[r][c+1][1]==0) continue;
                    
                    map[r][c][1] = 0;
                    map[r][c+1][3] = 0;
                }
            }else{
                // 기둥
                if(type==0){
                    // 바닥, 보의 한쪽 끝, 다른 기둥 위
                    if(r==n || map[r][c][1]==1 || map[r][c][3]==1 || map[r][c][2]==1){
                        map[r][c][0] = 1;
                        map[r-1][c][2] = 1;
                    }                    
                }else{
                    // 한쪽 끝이 기둥 위거나 양쪽에 보가 있다면
                    if(map[r][c][2]==1 || map[r][c+1][2]==1 || (map[r][c][3] == 1 && map[r][c+1][1] == 1)){
                        map[r][c][1] = 1;
                        map[r][c+1][3] = 1;
                    }
                }
            }
            
        }
        
        for(int r=0;r<=n;r++){
            for(int c=0;c<=n;c++){
                for(int k =0;k<2;k++){
                     if(map[r][c][k]==1){
                        answer.add(new int[3]);
                        answer.get(answer.size()-1)[0] = c;
                        answer.get(answer.size()-1)[1] = n-r;
                        answer.get(answer.size()-1)[2] = k;  
                     }     
                }
            }
        }
        // x->y->기둥->보 
        Collections.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    if(a[1]==b[1]) return a[2] - b[2];
                    else return a[1] - b[1];
                }else return a[0]-b[0];
            }
        });
        return answer;
    }
}
