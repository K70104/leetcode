import java.util.HashSet;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class TestDemo {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            tmp.next = l1;
        }
        if(l2 != null) {
            tmp.next = l2;
        }
        return newHead.next;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(set.contains(cur.val)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.val);
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
