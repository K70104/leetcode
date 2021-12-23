import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestDemo {
    // 摩尔投票算法
    // 多数元素的次数>n/2 其余<n/2 相减>=1
    public int majorityElement(int[] nums) {
        int cand = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == cand) {
                cnt++;
            } else if(--cnt == 0) { // 更新
                cand = nums[i];
                cnt = 1;
            }
        }
        return cand;
    }

    // 排序 后半位置
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 遍历 次数超过len
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                cnt++;
            }else {
                cnt = 0;
            }
            if(cnt >= (nums.length / 2)) {
                return nums[i];
            }
        }
        return nums[0];
    }

    // list  没有-加入 有-删除
    public int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums) {
            if(list.contains(n)) {
                list.remove(Integer.valueOf(n)); //
            }else {
                list.add(n);
            }
        }
        return list.get(0);
    }

    // 哈希 存储次数
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)  {
            int cnt = map.getOrDefault(n, 0) + 1;
            map.put(n, cnt);
        }
        for(int i : map.keySet()) {
            if(map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 按位异或
    public int singleNumber1(int[] nums) {
        int single = nums[0];
        for(int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    // 删除头尾空白字符串
    // 最后一次" "前
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    // 最后一个单词 到前面的空格长度
    public int lengthOfLastWord1(String s) {
        int index = s.length() - 1;
        while(s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while(index >= 0 &&s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

    // lastIndexOf 从后向前找子串
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int val = map.get(s.charAt(i));
            if(i < n && val < map.get(s.charAt(i-1))) {
                ans -= val;
            }else {
                ans += val;
            }
        }
        return ans;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
