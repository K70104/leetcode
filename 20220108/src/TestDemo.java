import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class TestDemo {
    public boolean possibleToStamp(int[][] grid, int x, int y) {
        if(x > y) {
            int ret = x;
            x = y;
            y = ret;
        }
        int len = grid.length;
        int cnt = 0;
        for (int[] ret : grid) {
            for (int sum : ret) {
                if(sum == 1) {
                    cnt = 0;
                }
            }
        }
        return true;
    }

    public int longestPalindrome(String[] words) {
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        for(String str : words) {
            set.add(str);
        }
        for(int i = 0; i < words.length; i++) {
            String str = words[i];
            StringBuilder ret = new StringBuilder();
            ret.append(str).reverse();
            if(set.contains(ret)) {
                cnt += 2 * str.length();
                set.remove(str);
                set.remove(ret);
            }
            if(str.charAt(0) == str.charAt(1)) {
                cnt += 2;
                set.remove(str);
            }
        }
        return cnt;
    }

    // 5961. 链表最大孪生和
    // 左右指针
    public int pairSum(ListNode head) {
        // 求长度
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        // val加入array
        int[] array = new int[size + 1];
        cur = head;
        for(int i = 0; i < size; i++) {
            array[i] = cur.val;
            cur = cur.next;
        }
        // 求最大
        int left = 0;
        int right = size - 1;
        int max = 0; // 最大值
        while(left < right) {
            max = Math.max(max, array[left++] + array[right--]);
        }
        return max;
    }

    // 5960. 将标题首字母大写
    public String capitalizeTitle(String title) {
        String[] ret = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++) {
            if(ret[i].length() <= 2) { // 小于2
                ret[i] = ret[i].toLowerCase();
            }else {
                String str = ret[i].toLowerCase(); // 全转小写
                // 字符数组 首字母大写
                char[] ch = str.toCharArray();
                ch[0] = Character.toUpperCase(ch[0]);
                ret[i] = new String(ch);
            }
            sb.append(ret[i]);
            if(i < ret.length - 1) { // 最后一个不加空格
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 如果二进制码字的第i位和i+1位相同，则对应的格雷码的第i位为0，否则为1
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1 << n; i++) { // 2^n
            list.add((i >> 1) ^ i);
        }
        return list;
    }

    /*
    1位格雷码有两个码字
    (n+1)位格雷码中的前2^n个码字等于n位格雷码的码字，按顺序书写，加前缀0
    (n+1)位格雷码中的后2^n个码字等于n位格雷码的码字，按逆序书写，加前缀1
    n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
     */
    // n 位的格雷码序列 等于 (n-1) 位的格雷码序列 并上 (n-1) 位的格雷码序列倒序前面加1的结果
    // 3位的格雷码 [000, 001, 011, 010] | [110, 111, 101, 100]
    public List<Integer> grayCode1(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if(n < 1) {
            return list;
        }
        int head = 1;
        for (int i = 0; i < n; i++) {
            // 逆序 每一层
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            // 每一层 左移一位
            head <<= 1;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
