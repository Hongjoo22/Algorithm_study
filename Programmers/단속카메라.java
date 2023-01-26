import java.util.*;
class Solution {
    // 회의실 배정과 비슷한 문제
    public int solution(int[][] routes) {
       // 끝을 기준으로 오름차순 정렬 후 시작을 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1,o2) -> {
            if(o1[1]==o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        // 전 카메라 위치
        int before = routes[0][1];
        int answer = 1;
        for(int i = 1;i<routes.length;i++){
            if(routes[i][0]<=before && routes[i][1]>=before) continue;

            before = routes[i][1];
            answer++;
            
        }
        return answer;
    }
}
