class ListNode142{
    int val;
    ListNode142 next;
    public ListNode142() {
    }
    public ListNode142(int val) {
        this.val = val;
    }
    public ListNode142(int val, ListNode142 nextNode) {
        this.val = val;
        this.next = nextNode;
    }
}

class Solution142 {
    public static ListNode142 detectCycle(ListNode142 head) {
        ListNode142 fast=head,slow=head;
        while(true){
            if(fast==null||fast.next==null){ //不存在环，fast当然率先 null
                break;
            }

            fast=fast.next.next;// 2
            slow=slow.next;

            if(fast==slow){// fast、slow 相遇
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}


/*
//HashSet
class Solution142 {
    public static ListNode142 detectCycle(ListNode142 head) {
        Set<ListNode142> NodeSet=new HashSet<>();
        ListNode142 p=head;
        while(!NodeSet.contains(p) && p!=null){
            NodeSet.add(p);
            p=p.next;
        }
        return p;
    }
}
*/
