import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TestDemo {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> charsCnt = new HashMap<>();
        int len = chars.length();
        for (int i = 0; i < len; i++) { // 1、chars字符次数
            char c = chars.charAt(i);
            charsCnt.put(c, charsCnt.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (String word : words) { // 2、遍历words单词
            HashMap<Character, Integer> wordCnt = new HashMap<>();
            int wordLength = word.length(); // 每个单词长度
            for (int i = 0; i < wordLength; i++) {
                char c = word.charAt(i);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1); // 统计每个单词的字符次数
            }
            boolean isAns = true;
            for (int i = 0; i < wordLength; i++) {
                char c = word.charAt(i);
                if(charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) { // 小于
                    isAns = false;
                    break;
                }
            }
            if(isAns) {
                ans += word.length();
            }
        }
        /*for (int i = 0; i < words.length; i++) { // 2、遍历words单词
            HashMap<Character, Integer> wordCnt = new HashMap<>();
            for (int j = 0; j < words[i].length(); j++) { // 加入每个字符
                char c = words[i].charAt(j);
                wordCnt.put(c, wordCnt.getOrDefault(c, 0) + 1);
            }
            boolean isAns = true;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if(charsCnt.getOrDefault(c, 0) < wordCnt.getOrDefault(c, 0)) { // 字符小于
                    isAns = false;
                    break;
                }
            }
            if(isAns) {
                ans += words[i].length();
            }
        }*/
        return ans;
    }

    public static int countQuadruplets(int[] nums) {
        int[] cache = new int[201];
        int cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) { // a + b
                cache[nums[i - 1] + nums[j]]++;
            }
            for (int j = i + 1; j < nums.length; j++) { // d - c
                int diff = nums[j] - nums[i];
                cnt += diff >= 0 ? cache[diff] : 0;
            }
        }
        return cnt;
    }

    // 3、d-c
    // nums[a]+nums[b]=nums[d]−nums[c]
    public static int countQuadruplets3(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; --b) {
            // nums[d]−nums[c] 出现的次数
            for (int d = b + 2; d < n; d++) {
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                cnt += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return cnt;
    }

    /*public static int countQuadruplets3(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 1; d < n; d++) {
                map.put(nums[d]- nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                cnt += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return cnt;
    }*/

    // 2、哈希表
    public static int countQuadruplets2(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 2; i >= 2; --i) {
            map.put(nums[i + 1], map.getOrDefault(nums[i + 1],0) + 1);
            for (int a = 0; a < i; a++) {
                for (int b = a + 1; b < i; b++) {
                    cnt += map.getOrDefault(nums[a] + nums[b] + nums[i], 0);
                }
            }
        }
        return cnt;
    }

    /*public static int countQuadruplets2(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 2; i >= 2; i--) {
            map.put(nums[i + 1], map.getOrDefault(nums[i +1], 0) + 1);
            for (int a = 0; a < i; a++) {
                for (int b = a + 1; b < i; b++) {
                    cnt += map.getOrDefault(nums[a] + nums[b] + nums[i], 0);
                }
            }
        }
        return cnt;
    }*/


    public static void main(String[] args) {
        int[] nums = {1,2,3,6};
        countQuadruplets(nums);
    }

    // 循环取字符串
    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<>(); // 单词
        Map<Character, String> ch2str = new HashMap<>(); // 字符
        int i = 0; // i j 取str字符串
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p); // 遍历pattern字符
            if(i >= str.length()) {
                return false;
            }
            int j = i;
            while(j < str.length() && str.charAt(j) != ' ') { // 跳过空白字符
                j++;
            }
            String tmp = str.substring(i, j); // 返回子字符串 [i, j) 取str一个单词
            if(str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if(ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= str.length();
    }

    // 哈希表  记录字符对应字符串 字符串对应字符
    public static boolean wordPattern3(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<>(); // 单词
        Map<Character, String> ch2str = new HashMap<>(); // 字符
        String[] strings = str.split(" ");
        if(strings.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(str2ch.containsKey(strings[i]) && str2ch.get(strings[i]) != ch) {
                return false;
            }
            if(ch2str.containsKey(ch) && !strings[i].equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(strings[i], ch);
            ch2str.put(ch, strings[i]);
        }
        return true;
    }

    public static boolean wordPattern2(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>(); // 单词
        Map<Character, String> ch2str = new HashMap<Character, String>(); // 字符
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p); // 遍历pattern字符
            if (i >= str.length()) {
                return false;
            }
            int j = i;
            while (j < str.length() && str.charAt(j) != ' ') { // 跳过空字符
                j++;
            }
            String tmp = str.substring(i, j); // 返回子字符串 [i, j) 取str一个单词
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= str.length();
    }

    public static void main2(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        // wordPattern(pattern, str);
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
