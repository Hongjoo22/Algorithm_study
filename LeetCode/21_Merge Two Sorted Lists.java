class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode answer = null;
        if(list1.val <= list2.val){
            answer = list1;
            answer.next = mergeTwoLists(list1.next, list2);
        }else{
            answer = list2;
            answer.next = mergeTwoLists(list1, list2.next);
        }
        return answer;
    }

}
