import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        // 보석 개수
        int total_count = new HashSet<>(Arrays.asList(gems)).size();
        HashMap<String, Integer> map = new HashMap<>();
    
        // 현재 좌우 idx 값
        int s = 0;
        int e = 0;
        map.put(gems[s],1);
        // 최소 길이
        int min = Integer.MAX_VALUE;
        int N = gems.length;
        int[] answer = new int[2];
        while(s<=e){
            
            // 모든 보석을 포함했으면 최소 길이인지 판별
            if(map.size()==total_count){
                // 길이가 같은 것은 의미없다
                if(e-s<min){
                    min = e-s;
                    answer[0] = s+1;
                    answer[1] = e+1;
                }
                map.put(gems[s],map.get(gems[s])-1);
                if(map.get(gems[s]) == 0) map.remove(gems[s]);
                s++;
            }else{
                 // 보석개수가 모자라면 오른쪽 포인터를 움직임   
                if(++e==N) break;
                map.put(gems[e], map.getOrDefault(gems[e],0)+1);                
            }
        }
        
        return answer;
    }
}
