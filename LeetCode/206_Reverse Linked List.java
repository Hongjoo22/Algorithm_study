class Solution {
    public ListNode reverseList(ListNode head) {
        // 예외 처리
        if(head==null) return null;
        ListNode answer = dfs(head, head.next);
        head.next = null;
        return answer;
    }
    public ListNode dfs(ListNode a, ListNode b){
        if(b==null) return a;
        ListNode tmp = b.next;
        b.next = a;
        
        return dfs(b, tmp);
    }
}
