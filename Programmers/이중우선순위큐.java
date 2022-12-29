import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            if(str.charAt(0)=='I'){
                int num = Integer.parseInt(str.split(" ")[1]);
                minPq.add(num);
                maxPq.add(num);
            }else{
                // 3. 남아있는 데이터가 없으면 연산 무시
                if(!maxPq.isEmpty()){                  
                     if(str.charAt(2)=='1'){
                        // 최댓값 삭제
                        minPq.remove(maxPq.poll());
                     }else{
                        // 최솟값 삭제
                        maxPq.remove(minPq.poll());
                     }    
                }              
            }
        }
    
        if(maxPq.size() == 0){
           answer[0] = answer[1] = 0;
        }else {
            answer[0] = maxPq.peek();
            answer[1] = minPq.peek();
        }
        
        return answer;
    }
}
