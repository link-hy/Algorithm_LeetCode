package code;

public class c24 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};

        //creat ListNode
        ListNode24 head=new ListNode24(nums[0]);
        ListNode24 q=head;
        for (int i = 1; i < nums.length; i++) {
            ListNode24 p=new ListNode24(nums[i]);
            q.next=p;
            q=p;
        }

        q=Solution24.swapPairs(head);
        while (q!=null){
            System.out.print(q.val+" ——> ");
            q=q.next;
        }
        System.out.println("end");

    }
}

class Solution24 {
    public static ListNode24 swapPairs(ListNode24 head) {
        if(head==null||head.next==null)
            return head;
        ListNode24 pre,p,q;
        p=head;
        head=head.next;
        q=head;

        p.next=q.next;
        q.next=p;

        pre=p;
        p=p.next;
        if(p!=null)//其实就结束了
            q=p.next;

        while(true){
            if(p==null||p.next==null)
                break;

            pre.next=q;
            p.next=q.next;
            q.next=p;

            pre=p;
            p=p.next;
            if(p!=null)//其实就结束了
                q=p.next;
        }
        return head;
    }
}

/*
//递归
class Solution24 {
    public static ListNode24 swapPairs(ListNode24 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode24 newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}*/



class ListNode24{
    int val;
    ListNode24 next;
    public ListNode24() {
    }
    public ListNode24(int val) {
        this.val = val;
    }
    public ListNode24(int val, ListNode24 nextNode) {
        this.val = val;
        this.next = nextNode;
    }
}

