import java.util.*;

public class TestDemo {
    public boolean wordPattern(String pattern, String str) {
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

    // int i -- > java 自动装箱，转成 Integer
    // put 返回的是一个 Integer
    // 判断对象相等的话，相当于判断的是引用的地址，即使 Integer 包含的值相等，也不会相等

    // 如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value
    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if(map.put(words[i], i) != map.put(pattern.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    // map
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target- numbers[i]), i+1};
            }
            map.put(numbers[i], i + 1);
        }
        return new int[]{-1, -1};
    }

    // Unicode 哈希表
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if(map.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    // 记录字母次数
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if(table[t.charAt(i) - 'a'] < 0) { // 为负
                return false;
            }
        }
        return true;
    }

    // 转字符数组 排序
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] ret1 = s.toCharArray();
        char[] ret2 = t.toCharArray();
        Arrays.sort(ret1);
        Arrays.sort(ret2);
        return Arrays.equals(ret1, ret2);
    }

    // 双指针
    public int[] twoSum3(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while(low < high) {
            int ret = numbers[low] + numbers[high];
            if(ret == target) {
                return new int[]{low+1, high+1};
            }else if(ret < target) {
                low++;
            }else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    // 二分
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) { // 一个
            int left = i + 1;
            int right = numbers.length - 1;
            while(left <= right) {
                int mid = (right - left) / 2 + left;
                if(numbers[mid] == target - numbers[i]) { // 另一个
                    return new int[]{i+1, mid+1};
                }else if (numbers[mid] < target- numbers[i]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 暴力
    public int[] twoSum1(int[] numbers, int target) {
        int ret = 0;
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                ret = numbers[i] + numbers[j];
                if(ret == target) {
                    ans[0] = i+1;
                    ans[1] = j+1;
                    break;
                }
            }
        }
        return ans;
    }

    // 原字符串 指针 比较
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(left < right) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    // 字符数字拿出 1、函数判断
    public boolean isPalindrome1(String s) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) { // 同时判断字符数字
                ret.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder retReverse = new StringBuilder(ret).reverse();
        return retReverse.toString().equals(ret.toString());
    }

    // 字符数字拿出 1、双指针判断
    public boolean isPalindrome2(String s) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) { // 同时判断字符数字
                ret.append(Character.toLowerCase(ch));
            }
        }
        int len = ret.length();
        int left = 0;
        int right = len - 1;
        while(left < right) {
            if(ret.charAt(left++) != ret.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        // 第一行
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ret.add(list1); // 此时才把第一行的数据放到了ret中
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1); // 每行开始都是1
            List<Integer> preRow = ret.get(i-1); // 上一行
            for (int j = 1; j < i; j++) {
                int num = preRow.get(j) + preRow.get(j-1);
                list.add(num);
            }
            list.add(1); // 结尾都是1
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
