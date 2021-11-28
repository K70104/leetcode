

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public ListNode head;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        // 找要删的前一个节点
        while (n - 1 != 0) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            n--;
        }
        // 要删的是head
        if (fast == null) {
            head = head.next;
            return head;
        }
        // 要删的是头节点的下一个
        if (fast.next == null) {
            head.next = head.next.next;
            return head;
        }
        //
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
