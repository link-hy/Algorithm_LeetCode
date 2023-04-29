
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

//双栈
class Solution0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        Deque<ListNode> ListA=new LinkedList<>();
        Deque<ListNode> ListB=new LinkedList<>();
        ListNode ans = null;
        while (headA!=null){
            ListA.push(headA);
            headA=headA.next;
        }
        while (headB!=null){
            ListB.push(headB);
            headB=headB.next;
        }
        while (ListA.peek()==ListB.peek()){
            ans=ListA.pop();//保存最后一个相等的节点，交点
            ListB.pop();
            if(!ListA.isEmpty()||!ListB.isEmpty())
                break;
        }
        return ans;
    }
}


/*
//长度
public class Solution0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA,pointB = headB;
        int lengthA=getListLength(headA);
        int lengthB=getListLength(headB);
        int diffn=0;
        if(lengthA>lengthB){
            diffn=lengthA-lengthB;
            while (diffn>0)
                pointA=pointA.next;
        }
        if(lengthA<lengthB){
            diffn=lengthB-lengthA;
            while (diffn>0)
                pointB=pointB.next;
        }

        while (pointA!=pointB){
            pointA=pointA.next;
            pointB=pointB.next;
        }

        return pointA;
    }

    private int getListLength(ListNode headA) {
        int len=0;
        while(headA!=null){
            len++;
            headA=headA.next;
        }
        return len;
    }
}*/
