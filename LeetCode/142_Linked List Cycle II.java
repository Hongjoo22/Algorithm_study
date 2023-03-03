public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode tmp = head;
        HashSet<ListNode> set = new HashSet<>();
        while(tmp!=null){
            if(!set.contains(tmp)) set.add(tmp);
            else break;
            tmp = tmp.next;
        }
        return tmp;
    }
}
