import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length;i++){
            if(set.contains(words[i]) || 
               (i>0 && words[i-1].charAt(words[i-1].length()-1)!= words[i].charAt(0))){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                break;
            }else set.add(words[i]);
        }
        
        return answer;
    }
}
