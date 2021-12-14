import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class TestDemo {
    public boolean isUnique(String astr) {
        int[] array = new int[128];
        for (int i = 0; i < astr.length(); i++) {
            if (array[astr.charAt(i)] != 0) {
                return false;
            }
            array[astr.charAt(i)]++;
        }
        return true;
    }

    public boolean isUnique1(String astr) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < astr.length(); i++) {
            if(map.containsKey(astr.charAt(i))) {
                return false;
            }
            map.put(astr.charAt(i), i);
        }
        return true;
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        // 转字符数组 排序
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        // 字符串比较
        return new String(chars1).equals(new String(chars2));
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
    }

    public boolean isFlipedString(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1).reverse();
        return sb.toString().equals(s2);
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main3(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    public static int cntEveryBIt(int n) {
        int cnt = 0;
        while(n > 0) {
            /*if((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;*/
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = cntEveryBIt(i);
        }
        return ans;
    }

    public static void main2(String[] args) {
        int[] ret = countBits(5);
        System.out.println(Arrays.toString(ret));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        // 全是9
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main1(String[] args) {
        System.out.println("11");
    }
}
