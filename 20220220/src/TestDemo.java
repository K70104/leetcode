import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class TestDemo {

    public ListNode deleteDuplication(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        ListNode cur = head;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    // 分离节点后合并
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next; // 连接单节点的尾

        ListNode odd = head; // 单数链表的头节点
        ListNode even = head.next; // 偶数链表的头节点
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead; //
        return head;
    }
    
    // 正确做法：与67题类似
    // https://leetcode-cn.com/problems/add-binary/
    // 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
    // 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;

        int carry = 0; // 进位
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = val1 + val2 + carry; // 还需加入的总值
            carry = val / 10; // 如果是10，此次节点val为0，进位1

            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return newHead.next;
    }



    // 修改为Long 还是有超出范围的情况
    public Long getSumOfVal(ListNode cur) {
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        String str = sb.reverse().toString();
        return Long.valueOf(str);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Long num1 = getSumOfVal(l1);
        Long num2 = getSumOfVal(l2);
        Long sum = num1 + num2; // 两链表 val 之和
        // 逆置和
        String str = String.valueOf(sum);
        StringBuilder sb = new StringBuilder(str).reverse();

        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead; // 连接每一个节点
        for (int i = 0; i < str.length(); i++) {
            ListNode node = new ListNode(sb.charAt(i) - '0');
            cur.next = node;
            cur = cur.next;
        }

        return newHead.next;
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    // 前缀和
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        int sum = 0; // 和
        ListNode cur = newHead;
        Map<Integer, ListNode> map = new HashMap<>();
        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        while(cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        //（从前面的一个sum处的节点指向后面的另一个sum处的节点的next）
        sum = 0;
        cur = newHead;
        while(cur != null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }

        return newHead.next;
    }

    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        while(start < bits.length - 1) {
            if(bits[start] == 0) {
                start++;
            } else {
                start += 2;
            }
        }
        return start == bits.length - 1;
    }

    public static void main(String[] args) {
        String[] strings = {"123", "243"};
        int year = Integer.parseInt(strings[0]);
        System.out.println(year);

        String str = "123";
            int a = Integer.parseInt(str, 10);
            System.out.println(a);
        String str2 = String.valueOf(a);
        System.out.println(str2);
    }

    public static void main1(String[] args) {
//        String str = "abc";
//        int a = Integer.parseInt(str);

        //System.out.println(a);
     /*   // str = String.valueOf(a);
        Integer integer = 0x7fffffff;
        System.out.println(integer);
        // 2147483647
        // 9999999991
        // 9223372036854775807
        Long l = 0x7fffffffffffffffL;
        l = Long.valueOf(str);
        System.out.println(l);
        System.out.println(123);*/
    }
}
