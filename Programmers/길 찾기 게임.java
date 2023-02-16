import java.util.*;
class Solution {
    public class Node implements Comparable<Node> {
        int idx;
        int x;
        int level;
        Node left;
        Node right;
        
        public Node(int idx, int x, int level){
            this.idx = idx;
            this.x = x;
            this.level = level;
        }
        
        // level 큰 순 -> x 작은순으로 정렬
        @Override
        public int compareTo(Node node){
            if(this.level==node.level) return this.x - node.x;
            else return node.level-this.level;
        }
    }
    
    public int cnt;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        ArrayList<Node> list = new ArrayList<>();
                
        for(int i = 0; i < nodeinfo.length; i++){
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }      
       
        Collections.sort(list);
        Node root = list.get(0);
        
        for(int i = 1; i < list.size(); i++){
            makeTree(root, list.get(i));
        }
        
        cnt = 0;
        preOrder(root, answer[0]);
        cnt = 0;
        postOrder(root, answer[1]);
        
        return answer;
    }
    public void preOrder(Node now, int[] answer){
        if(cnt<answer.length) answer[cnt++] = now.idx;
        if(now.left!=null) preOrder(now.left, answer);
        if(now.right!=null) preOrder(now.right, answer);
    }
    
    public void postOrder(Node now, int[] answer){
        if(now.left!=null) postOrder(now.left, answer);
        if(now.right!=null) postOrder(now.right, answer);
        if(cnt<answer.length) answer[cnt++] = now.idx;
    }

    /* 여기가 중요함! root를 기준으로 child를 계속 갱신해준다. */
    public void makeTree(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null) parent.left = child;
            else makeTree(parent.left,child);
        }else{
            if(parent.right == null) parent.right = child;
            else makeTree(parent.right,child);
        }
        
    }
}
