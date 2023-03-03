class Solution {
    public int total;
    public ListNode middleNode(ListNode head) {
        total = 0;
        return dfs(head, 1);
    }
    public ListNode dfs(ListNode node, int count){
        if(node.next == null) {
            total = count;
            return node;
        }

        ListNode tmp = dfs(node.next, count+1);
        if(total/2 == count-1) tmp = node;
        return tmp;
    }
}
