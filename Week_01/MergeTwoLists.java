/**
 * 合并两个有序链表
 * leetcode -- 21
 **/
public class MergeTwoLists {

    /**
     * simple solution
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        ListNode totalList = new ListNode();
        merge(totalList,l1,l2);
        return totalList;
    }

    private static ListNode merge(ListNode l,ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return null;
        }
        if(l2==null){
            l.val=l1.val;
            if(l1.next!=null){
                l.next = new ListNode();
            }
            return merge(l.next,l1.next,null);
        }
        if(l1==null){
            l.val=l2.val;
            if(l2.next!=null){
                l.next = new ListNode();
            }
            return merge(l.next,null,l2.next);
        }
        if(l1.val <= l2.val){
            l.val = l1.val;
            l.next = new ListNode();
            return merge(l.next,l1.next,l2);
        }else{
            l.val = l2.val;
            l.next = new ListNode();
            return merge(l.next,l1,l2.next);
        }
    }

    /**
     * better solution
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * better solution
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = createListNode(1,2,4);
        ListNode l2 = createListNode(1,3,4);
        printListNode(l1);
        printListNode(l2);
        //bad solution
        ListNode listNode = mergeTwoLists(l1, l2);
        printListNode(listNode);
        //better solution
        ListNode listNode1 = mergeTwoLists1(l1, l2);
        printListNode(listNode1);
        //better solution
        ListNode l11 = createListNode(1,2,4);
        ListNode l22 = createListNode(1,3,4);
        ListNode listNode2 = mergeTwoLists2(l11, l22);
        printListNode(listNode2);
    }

    /**
     * create ListNode
     * @param nums
     * @return
     */
    static ListNode createListNode(Integer... nums){
        ListNode listNode = new ListNode(nums[0]);
        ListNode temp = listNode;
        for(int i=1;i<nums.length;++i){
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return listNode;
    }

    /**
     * print ListNode
     * @param listNode
     */
    static void printListNode(ListNode listNode){
        ListNode temp = listNode;
        while (temp!=null){
            System.out.print(temp.val);
            if(temp.next!=null){
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}