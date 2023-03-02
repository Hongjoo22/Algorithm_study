import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int N = people.length;
        boolean[] v = new boolean[N];
        Arrays.sort(people);
        
        int s = 0;
        int e = N-1;
        
        while(s<=e){
            if(s>=N || e<0) break;
            if(v[s]) {
                s++;
                continue;
            }
            if(v[e]){
                e--;
                continue;
            }
            if(s!=e){
                if(people[s] + people[e] <= limit){
                    answer++;
                    v[s] = true;
                    v[e] = true;    
                }else{
                    e--;
                }
                    
            }else{
                v[s] = true;
                answer++;
            }
        }
        for(Boolean check:v) if(!check) answer++;
        return answer;
    }
}
