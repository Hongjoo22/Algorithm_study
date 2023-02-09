import java.util.*;
class Solution {
    public HashMap<String, Integer> map;
    public  ArrayList<ArrayList<String>> matrix;
    public  ArrayList<ArrayList<Boolean>> v;
    public ArrayList<String> answer;
    public boolean finish;
    public ArrayList<String> solution(String[][] tickets) {
       
        map = new HashMap();
        int idx = 0;
        for(int i=0;i<tickets.length;i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], idx++);
            }
            if(!map.containsKey(tickets[i][1])){
                map.put(tickets[i][1], idx++);
            }
        }
        matrix = new ArrayList<>();
        v = new ArrayList<>();
        
        for(int i =0;i<map.size();i++){
            matrix.add(new ArrayList<>());
            v.add(new ArrayList<>());
        }
        for(int i=0;i<tickets.length;i++){           
            matrix.get(map.get(tickets[i][0])).add(tickets[i][1]);         
            v.get(map.get(tickets[i][0])).add(false);
        }
        
        for(int i =0;i<matrix.size();i++){
            Collections.sort(matrix.get(i));  
        }
        // System.out.println(Arrays.deepToString(matrix.toArray())); 
        answer = new ArrayList<>();
        finish = false;
        dfs("ICN", matrix.get(map.get("ICN")),0, tickets.length);
        return answer;
    }
    public void dfs(String now, ArrayList<String> list, int idx, int N){
        
        answer.add(now);
        // 모든 티켓을 사용했을 때
        if(idx==N){
            finish = true;
            return;
        }
        for(int i =0;i<list.size();i++){
            if(!v.get(map.get(now)).get(i)){
                v.get(map.get(now)).set(i, true);
                String next = list.get(i);
                dfs(next, matrix.get(map.get(next)), idx+1, N);
                // 여기서 끝나지 않았으면 다음 경로로 이동
                if(!finish) {
                    v.get(map.get(now)).set(i, false);
                 
                }
            }
        }
        // 여기서 끝나지 않았으면 지금 위치가 아님
        if(!finish){
            answer.remove(idx);
        }
    }
}
