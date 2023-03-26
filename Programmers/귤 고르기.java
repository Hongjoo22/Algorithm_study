import java.util.*;
class Solution {
    public PriorityQueue<Integer> pq;
    public int solution(int key, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer tan : tangerine){
            map.put(tan, map.getOrDefault(tan,0)+1);
        }
        map.forEach((k,v)->{
           pq.add(v); 
        });
        int count = 0;
        while(!pq.isEmpty()){
            count += pq.poll();
            answer++;
            if(count>=key) break;
        }
        return answer;
    }
}
