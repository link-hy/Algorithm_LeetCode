package code;

import java.util.Deque;
import java.util.LinkedList;

public class c19 {
    public static void main(String[] args) {
        int[] nums={1};
        int n=1;
        //creat ListNode
        ListNode19 head=new ListNode19(nums[0]);
        ListNode19 q=head;
        for (int i = 1; i < nums.length; i++) {
            ListNode19 p=new ListNode19(nums[i]);
            q.next=p;
            q=p;
        }

        q=Solution19.removeNthFromEnd(head,n);
        while (q!=null){
            System.out.print(q.val+" ——> ");
            q=q.next;
        }
        System.out.println("end");

    }
}
class ListNode19{
    int val;
    ListNode19 next;
    public ListNode19() {
    }
    public ListNode19(int val) {
        this.val = val;
    }
    public ListNode19(int val, ListNode19 nextNode) {
        this.val = val;
        this.next = nextNode;
    }
}
/*
//双指针
class Solution19 {
    public static ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 fastNode=head,slowNode=new ListNode19();
        slowNode.next=head;
        head=slowNode;
        for(int i=0;i<n;i++){
            fastNode=fastNode.next;
        }
        while(fastNode!=null){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
        }
        // delect slowNode `s next Node
        if(slowNode.next!=null) {
            slowNode.next = slowNode.next.next;
        }else{
            slowNode.next=null;
        }
        return head.next;
    }
}*/

//栈
class Solution19 {
    public static ListNode19 removeNthFromEnd(ListNode19 head, int n) {
        ListNode19 dummy = new ListNode19(0, head);
        Deque<ListNode19> nodeStack = new LinkedList<ListNode19>();
        ListNode19 cur = dummy;
        while (cur != null) {//全部入栈
            nodeStack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {//出栈n个节点，后n
            nodeStack.pop();
        }
        ListNode19 prev = nodeStack.peek();//get 倒数第n个前一个
        prev.next = prev.next.next;

        return dummy.next;
    }
}
