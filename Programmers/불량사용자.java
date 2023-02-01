import java.util.*;
class Solution {
    ArrayList<ArrayList<String>> list;
    public HashSet<String> answerSet;
    public int solution(String[] user_id, String[] banned_id) {
        
        Arrays.sort(user_id);
        // ban 아이디 후보 모든 조합 
        list = new ArrayList<>();
        // 답이 나온 목록 조합
        answerSet = new HashSet<>();
        
        for(int i=0;i<banned_id.length;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<banned_id.length;i++){
            for(int j=0;j<user_id.length;j++){
                if(banned_id[i].length()!=user_id[j].length()) continue;
                boolean check = true;
                for(int k=0;k<banned_id[i].length();k++){
                    if(banned_id[i].charAt(k)!= '*' && banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                        check = false;
                        break;
                    }
                    
                }
                // 해당 ban_id의 후보군 list
                 if(check){
                         list.get(i).add(user_id[j]);
                     }
            }
        }
        // 중복 조합을 피하기 위한 set
        HashSet<String> set = new HashSet<>();  
        dfs(0,set);
        // 중복 제거한 목록 개수
        return answerSet.size();
    }
    public void dfs(int idx, HashSet<String> set){
        // 중복없이 모두 선택했다면
        if(idx==list.size()){
            StringBuilder sb = new StringBuilder();
            String[] strList = new String[list.size()];
            int i=0;
            // set은 순서보장 안해줌
            for(String str : set){
                strList[i++] = str;
            } 
            // 모두 같은 요소여야 중복임
            Arrays.sort(strList);
            for(String str : strList){
               sb.append(str+" ");
            }
            answerSet.add(sb.toString());
            return;
        }
        // index가 idx인 ban_id의 후보군 list들
        for(String str : list.get(idx)){  
            if(!set.contains(str)) {
                set.add(str);
                dfs(idx+1,set);
                set.remove(str);
            }
        }
    }
}
