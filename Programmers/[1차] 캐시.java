import java.util.*;
class Solution {
    public int min;
    public String remove;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            if(map.containsKey(city)) answer += 1;
            else answer +=5;
            
            map.put(city, i); 
            
            if(map.size() > cacheSize){        
              min = Integer.MAX_VALUE;
              remove = "";
              map.forEach((k,v)->{
                  if(min > v){
                      min = v;
                      remove = k;
                  }
              });
              map.remove(remove);
            }
        }
        return answer;
    }
}
