import java.util.*;
class Solution {
    public class Stone implements Comparable<Stone>{
        int idx;
        int cost;
        public Stone(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Stone o){
            if(this.cost==o.cost) return this.idx - o.idx;
            else return o.cost - this.cost;
        }
    }
    public int solution(int[] stones, int k) {
        
        PriorityQueue<Stone> pq = new PriorityQueue<>();
        
        for(int i =0;i<k;i++){
            pq.add(new Stone(i, stones[i]));
        }
        
        int s_idx = 0;
        int min = pq.peek().cost;
        
        while(!pq.isEmpty()){
            
            // cost 내림차순으로 정렬된 stone의 idx가 현재 구간 밖이면 버림
            // while문으로 poll 안해줘서 2시간 날림
            while(pq.peek().idx < s_idx){
                pq.poll();
            }
            Stone stone = pq.peek();            
            min = Math.min(min, stone.cost);
            
            if(s_idx+k>=stones.length) break;
            pq.add(new Stone(s_idx+k,stones[s_idx+k]));
            s_idx++;
            
        }
        
       
        return min;
    }
}
