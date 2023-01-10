import java.util.*;
class Solution {
    int[] parents, rank;
    public int solution(int n, int[][] computers) {
        
        parents = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(computers[i][j]==1){
                    union(i,j);                  
                }
            }
        }
        
        // 루트 노드를 안가리킬때 예외처리
        for(int i=0;i<n;i++){
            parents[i] = find(parents[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer idx: parents) set.add(idx);
        
        return set.size();
    }
    public int find(int x){
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
    public void union(int x,int y){
        x = find(x);
        y = find(y);
   
        if(x==y) return;
        if(parents[x] > parents[y]){
            parents[x] = y;
        }else{
            parents[y] = x;
        }
        // if(rank[x]==rank[y]) rank[x]++;       
    }
}
