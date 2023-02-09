import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        // ** (long) 형변환 해주는거 잊지말기
        long answer = times[times.length-1]*(long)n;
        long s = times[0];
        long e = answer;
        
        while(s<=e){
            long mid = (s+e)/2;
            long tmp = 0;
            
            // 해당 시간으로 몇명 심사할 수 있는지 확인
            for(long time:times) tmp += mid/time;
            
            // n이상이면 가능한 시간
            if(tmp>=n){
                answer = Math.min(answer,mid);
                // 최소값을 위해 더 줄여본다
                e = mid-1;
            // n미만이면 불가능
            }else s = mid+1;
        }
        return answer;
    }
}
