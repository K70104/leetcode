

class ListNode {
    public int val;
    public ListNode next;
}

public class TestDemo {

    class Solution {
        public void deleteNode(ListNode node) {
            // node下一个节点：cur
            // 把node变成cur
            ListNode cur = node.next;
            node.val = cur.val;
            node.next = cur.next;
        }
    }

    // 判断回文链表
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

    public static void main(String[] args) {

    }
}
