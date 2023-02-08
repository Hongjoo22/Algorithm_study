import java.util.*;
class Solution {
    public class Node implements Comparable<Node>{
        int idx;
        int start;
        int cost;
        public Node(int idx, int start,int cost){
            this.idx = idx;
            this.start = start;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o1){
            if(this.start==o1.start) return this.cost-o1.cost;
            else return this.start-o1.start;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i =0;i<jobs.length;i++){
            int s = jobs[i][0];
            int cost = jobs[i][1];
            pq.add(new Node(i,s, cost));
        }
        int before = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            // 현재 실행 지점 이후 들어오면 cost가 작은 순서대로
            if(before <= node.start){
                answer += node.start + node.cost - jobs[node.idx][0];
                before = node.start + node.cost;
            }else{
                // 아니라면 시작 순서를 before로 초기화
                pq.add(new Node(node.idx, before, node.cost));
            }
        }
        answer /= jobs.length;
        return answer;
    }
}
