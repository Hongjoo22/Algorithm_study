import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer time:works){
            pq.add(time);
        }
        for(int i=0;i<n;i++){
            if(!pq.isEmpty()){
                int x =  pq.poll();
                if(x > 1) pq.add(x-1);
            }else break;
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}
