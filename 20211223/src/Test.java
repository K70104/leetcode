import java.util.*;

public class Test {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        String letter = "AABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 从第二个开始

        while(columnNumber > 26) {
            int num = columnNumber / 26;
            sb.append(letter.charAt(num));
            columnNumber %= 26;
        }
        if(columnNumber <= 26) { // 小于26 只有个字符
            sb.append(letter.charAt(columnNumber));
        }
        return sb.toString();
    }

    // 摩尔投票算法
    // 找3/n，最多只有两个。相同->加一，不相同->抵消
    public List<Integer> majorityElement(int[] nums) {
        // 初始化两个候选人和机票
        int cand1 = 0;
        int cand2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        //
        for(int num : nums) {
            if(vote1 > 0 && num == cand1) { // 该元素是第一个元素 机票加一
                vote1++;
            } else if (vote2 > 0 && num == cand2) { // 该元素是第二个元素 机票加一
                vote2++;
            } else if (vote1 == 0) { // 第一个元素
                cand1 = num;
                vote1++;
            } else if (vote2 == 0) { // 第二个元素
                cand2 = num;
                vote2++;
            } else { // 三个都不相等 都抵消
                vote1--;
                vote2--;
            }
        }
        // 判断机票是否 > len/3
        int cnt1 = 0 ;
        int cnt2 = 0 ;
        for(int num : nums) {
            if(vote1 > 0 && num == cand1) {
                cnt1++;
            }
            if(vote2 > 0 && num == cand2) {
                cnt2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if(vote1 > 0 && cnt1 > nums.length / 3) {
            list.add(cand1);
        }
        if(vote2 > 0 && cnt2 > nums.length / 3) {
            list.add(cand2);
        }
        return list;
    }

    // 哈希表 记录次数
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int n : nums) {
            set.put(n, set.getOrDefault(n, 0) + 1);
        }
        for (int n : set.keySet()) {
            if(set.get(n) > nums.length / 3) {
                list.add(n);
            }
        }
        return list;
    }

    // 循环遍历次数 哈希去重
    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        if(nums.length <= 2) {
            list.add(nums[0]);
            if(nums.length == 2) {
                if(nums[0] != nums[1]) { // 避免重复
                    list.add(nums[1]);
                }
            }
            return list;
        }
        Arrays.sort(nums);
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if(cnt > nums.length / 3) { // >
                if(set.add(nums[i])) {
                    list.add(nums[i]); // 避免重复
                }
                cnt = 1;
            }
        }
        return list;
    }
}
