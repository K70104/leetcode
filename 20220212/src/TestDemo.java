import java.util.Arrays;
import java.util.HashMap;

public class TestDemo {
    // 3、哈希表
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // 如果相等，抵消为0
        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        // 判断
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }


    // 2、数组统计次数
    public boolean CheckPermutation2(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        // 数组记录两字符串的字符次数、
        int[] cnts1 = cntLetters(s1);
        int[] cnts2 = cntLetters(s2);
        for(int i = 0; i < 26; i++) {
            if(cnts1[i] != cnts2[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] cntLetters(String str) {
        int[] cnts = new int[26];
        for(int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i) - 'a']++;
        }
        return cnts;
    }


    // 1、转字符数组 排序
    public boolean CheckPermutation1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        // 字符串比较
        return new String(chars1).equals(new String(chars2));
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
