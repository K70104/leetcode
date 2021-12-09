import java.util.Arrays;

class ListNode {
    protected int val;
    protected ListNode next;
}

public class Test {
    public ListNode head;

    public boolean judge (String str) {
        // write code here
        StringBuffer sb = new StringBuffer(str).reverse();
        return str.equals(sb);
    }

    public boolean judge1 (String str) {
        // write code here
        if(str.length() == 0) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public String solve (String str) {
        // write code here
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); ++i) {
            chars[i] = str.charAt(str.length()-1-i);
        }
        return new String(chars);
    }

    public String solve2(String str) {
        // write code here
        char[] chars = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String str = "hello";
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        for(int x : arr) {
            System.out.print(x +" ");
        }
    }

    public String solve1 (String str) {
        // write code here
        return new StringBuffer(str).reverse().toString();
    }

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null || k < 0) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(k-1 != 0) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public boolean isPail (ListNode head) {
        // write code here
        if(head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        // 判断
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

}
