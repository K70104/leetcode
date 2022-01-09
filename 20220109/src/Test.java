import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public ListNode head;

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
}

public class Test {
    // 取val值
    public int pairSum1(ListNode head) {
        if(head == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        // 将 val 加入 list
        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        // 遍历一半
        int max = 0;
        for(int i = 0; i < list.size() / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(list.size() - 1 - i));
        }
        return max;
    }

    // 快慢指针反转链表
    public int pairSum(ListNode head) {
        if(head == null) {
            return 0;
        }
        // 找中间节点
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
        // 求最大和
        int maxSum = 0;
        while(head != slow) {
            maxSum = Math.max(maxSum, head.val + slow.val);
            head = head.next;
            slow = slow.next;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(4);
        listNode.addLast(2);
        listNode.addLast(2);
        listNode.addLast(3);
        System.out.println(pairSum(listNode));
    }

    public String capitalizeTitle1(String title) {
        String[] ret = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++) {
            if(ret[i].length() <= 2) {
                ret[i] = ret[i].toLowerCase();
            }else {
                String str = ret[i].toLowerCase(); // 全转小写
                // 字符数组 首字母大写
                char[] ch = str.toCharArray();
                ch[0] = Character.toUpperCase(ch[0]);
                ret[i] = new String(ch);
            }
            sb.append(ret[i]);
            if(i < ret.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String capitalizeTitle(String title) {
        String[] ret = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++) {
            if(ret[i].length() <= 2) {
                ret[i] = ret[i].toLowerCase();
                sb.append(ret[i]);
            }else {
                sb.append(Character.toUpperCase(ret[i].charAt(0)));
                sb.append(ret[i].substring(1).toLowerCase());
            }
            if(i < ret.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        // 字符 时间 都初识为第一个
        char ans = keysPressed.charAt(0);
        int time = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int nextTime = releaseTimes[i] - releaseTimes[i - 1]; // 下一个持续时间
            if (time < nextTime) {
                // 下一个持续时间更长 更新字符与时间
                ans = keysPressed.charAt(i);
                time = nextTime;
            } else if (time == nextTime && ans < keysPressed.charAt(i)) {
                // 时间相同 比较字符大小是否需要更新 c>b
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}
