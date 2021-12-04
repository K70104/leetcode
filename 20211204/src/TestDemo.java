import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class TestDemo {
    public ListNode head;

    // 反转链表 遍历
    public int[] reversePrint(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        int size = 0; // 计算链表长度
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
            size++;
        }
        int[] array = new int[size];
        cur = prev;
        for (int i = 0; i < size; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }
        return array;
    }

    // ArrayList
    public int[] reversePrint1(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        // 获取链表长度
        int size = list.size();
        // 遍历放到数组里
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size-i-1); // 减一
        }
        return array;
    }

    public int getDecimalValue(ListNode head) {
        if(head == null) {
            return 0;
        }
        ListNode cur = head;
        int sum = 0;
        while(cur != null) {
            sum = sum * 2 + cur.val;
            cur = cur.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        //

    }
}
