import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        // 보석 개수 세기
        for(String gem:gems){
            set.add(gem);
        }
        // 현재 좌우 idx 값
        int s = 0;
        int e = 0;
        map.put(gems[0],1);
        // 최소 길이 일때의 좌우 idx 값
        int min_s = 0;
        int min_e = 0;
        // 최소 길이
        int min = Integer.MAX_VALUE;
        // 보석 개수
        int total_count = set.size();
        int N = gems.length;
        
        while(s<=e && e<N){
            
            // 모든 보석을 포함했으면 최소 길이인지 판별
            if(map.size()==total_count){
                // 길이가 같은 것은 의미없다
                if(e-s+1<min){
                    min = e-s+1;
                    min_s = s+1;
                    min_e = e+1;
                }
                
                if(s<N && map.get(gems[s])==1){
                    map.remove(gems[s]);
                }else if(s<N){
                    map.put(gems[s],map.get(gems[s])-1);
                }
                s++;
            }else{
                 // 보석개수가 모자라면 오른쪽 포인터를 움직임   
                e++;
                if(e<N && map.containsKey(gems[e])){
                    map.put(gems[e], map.get(gems[e])+1);
                }else if(e<N){
                    map.put(gems[e],1);
                }
            }
        }
        
        int[] answer = {min_s,min_e};
        return answer;
    }
}
