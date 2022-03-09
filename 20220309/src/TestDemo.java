
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class TestDemo {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;

        ListNode cur = head;
        int val = 0;
        while(cur != null) {
            if(cur != head && cur.val == 0) { // 第一个头节点不加入
                tmp.next = new ListNode(val);
                tmp = tmp.next;
                val = 0; // 下一个
            } else {
                val += cur.val;
            }
            cur = cur.next;
        }

        return newHead.next;
    }
    
    public int finalValueAfterOperations(String[] operations) {
        // 三个符号 中间一定是 + 或 -
        int x = 0;
        for(int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
