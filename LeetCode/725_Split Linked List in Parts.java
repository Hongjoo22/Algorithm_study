/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.*;
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode node = head;
        while(node!=null){
            list.add(node);
            node = node.next;
        }
        int N = list.size();
        int num  = N/k;
         // 조심!
        int plus = N - num*k;
        int idx = 0;
        
        for(int i=0;i<nodes.length;i++){
            if(idx<N) nodes[i] = list.get(idx);
            else break;
              // 출력 방식을 위한 split
            if(idx>0) {
                list.get(idx-1).next = null;
            }

            if(plus>0){
                idx += num + 1;
                plus--;
            }else{
                idx += num;
            }
        }

        return nodes;
    }
}
