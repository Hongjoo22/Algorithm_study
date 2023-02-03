import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i =0;i<edge.length;i++){
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        
        Queue<int[]> qu = new LinkedList<>();
        int[] depth = new int[n+1];
        // idx, 깊이
        qu.add(new int[]{1,0});
        int max_depth = 0;
        
        while(!qu.isEmpty()){
            int[] now = qu.poll();
            for(Integer i : list.get(now[0])){
                if(i!=1 && depth[i] == 0) {
                    depth[i] = now[1]+1;
                    qu.add(new int[]{i, now[1]+1});
                    max_depth = Math.max(depth[i],max_depth);                 
                }
            }          
        }
        int answer = 0;
        for(Integer d : depth) if(d==max_depth)  answer++;
        return answer;
    }
}
