package code;

public class c206 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};

        //creat ListNode
        ListNode206 head=new ListNode206(nums[0]);
        ListNode206 q=head;
        for (int i = 1; i < nums.length; i++) {
            ListNode206 p=new ListNode206(nums[i]);
            q.next=p;
            q=p;
        }

        q=Solution206.reverseList(head);
        while (q!=null){
            System.out.print(q.val+" ——> ");
            q=q.next;
        }
        System.out.println("end");
    }
}


class ListNode206{
    int val;
    ListNode206 next;
    public ListNode206() {
    }
    public ListNode206(int val) {
        this.val = val;
    }
    public ListNode206(int val, ListNode206 nextNode) {
        this.val = val;
        this.next = nextNode;
    }
}


class Solution206 {
    public static ListNode206 reverseList(ListNode206 head) {
        if(head==null||head.next==null)
            return head;

        ListNode206 p,tem;
        p=head.next;
        head.next=null;
        while(p!=null){
            tem=p.next;
            p.next=head;
            head=p;
            p=tem;
        }
        return head;
    }
}
