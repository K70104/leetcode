import java.util.HashMap;
import java.util.HashSet;

class ListNode {
    public int val;
    public ListNode next;
}

public class TestDemo {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) { // 不够构成ransomNote
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) { // 记录字符 和次数
            int cnt = map.getOrDefault(magazine.charAt(i), 0) + 1;
            map.put(magazine.charAt(i), cnt);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int cnt = 0;
            if(!map.containsKey(ransomNote.charAt(i))) {
                return false; // 找不到字符
            }else {
                cnt = map.get(ransomNote.charAt(i)) - 1;
                map.put(ransomNote.charAt(i), cnt); // 次数减一
            }
            if(cnt == 0) { // 没有次数 移除该字符
                map.remove(ransomNote.charAt(i), 0);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flg = canConstruct("aa", "aab");
        System.out.println(flg);
    }

    public static int guess(int k) {
        int num = 10;
        if(k > num)
            return 1;
        if(k < num)
            return -1;
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left < right) { // 当区间左右端点相同时，则说明我们找到了答案，退出循环
            int pick = (left + right) / 2;
            // The number I picked is higher than your guess ...
            if(guess(pick) > 0) {
                left = pick + 1;
            }else if (guess(pick) < 0) {
                right = pick - 1;
            }
        }
        return left;
    }

    // 二分
    public static boolean isPerfectSquare(int num) {
        long left = 0;
        long right = num / 2;
        long mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return true;
    }

    public static void main2(String[] args) {
        System.out.println(isPerfectSquare(255));
    }

    // 暴力
    public boolean isPerfectSquare2(int num) {
        for(long i = 1; i <= num; i++) {
            long x = i * i;
            if(x == num) {
                return true;
            }else if (x > num) { // i*i > num
                return false;
            }
        }
        return false;
    }

    // 减
    public boolean isPerfectSquare1(int num) {
        // 平方数 =1+3+5+...+(2∗n−1)
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    // 迭代
    /*public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        tmp.next = head;
        while(tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next; // 1
            ListNode node2 = tmp.next.next; // 2
            tmp.next = node2; // newHead: 2
            node1.next = node2.next; // 1-3
            node2.next = node1; // 2-1-3
            tmp = node1; // 下一组
        }
        return newHead.next;
    }*/

    // 递归
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next; // 1 2 3 4  保存2
        head.next = swapPairs1(newHead.next); // 交换下一组4-3  把head指向4：1-4
        newHead.next = head; // 2指向1
        return newHead;
    }

    // 法官：被信任 n-1 && 信任别人 0
    public int findJudge1(int n, int[][] trust) {
        int[][] array = new int[n+1][2];
        for (int[] k : trust) {
            array[k[0]][0]++; // k[0] 信任别人
            array[k[1]][1]++; // k[1] 被信任
        }
        for (int i = 1; i <= n; i++) {
            if(array[i][1] == n - 1 && array[i][0] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int findJudge(int n, int[][] trust) {
        int[] array = new int[n+1];
        for (int[] k : trust) {
            array[k[0]]--; // k[0] 信任别人
            array[k[1]]++; // k[1] 被信任
        }
        for (int i = 1; i <= n; i++) {
            if(array[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        System.out.println(12);
    }
}
