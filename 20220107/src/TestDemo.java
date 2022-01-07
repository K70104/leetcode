import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestDemo {
    // 排序
    // a + b > c  找 c 前面符合条件的a b最大值
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; --i) {
            if(nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

    // 未中毒状态，加duration，更新中毒结束时间expired，本次中毒结束时间timeSeries[i]+duration
    // 中毒状态，本次中毒结束时间 - 上次中毒时间expired
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int anx = 0; // 每次中毒时间总和
        int expired = 0; // 中毒结束时间
        for(int i = 0; i < timeSeries.length; i++) {
            if(timeSeries[i] >= expired) { // 未中毒
                anx += duration;
            }else { // 中毒
                anx += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration; // 加每次中毒时间
        }
        return anx;
    }

    // 排序
    // 相邻判断重复 末位为max 最后一个0后为min
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) { // 大小王的数量
                joker++;
            } else if(nums[i] == nums[i + 1]) { // 有重复
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }

    // 除大小王 没有重复牌
    // max - min < 5
    public boolean isStraight1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0; //
        int min = 14; //
        for(int i = 0; i < 5; i++) {
            if(nums[i] == 0) { // 跳过大小王
                continue;
            }
            if(set.contains(nums[i])) { // 有重复
                return false;
            }
            set.add(nums[i]);
            max = Math.max(max, nums[i]); // 最大
            min = Math.min(min, nums[i]); // 最小
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 2, 2, 5};
        // isStraight(array);
    }

    public int getMaximumGenerated(int n) {
        if(n < 2) {
            return n;
        }
        int max = 1;
        int[] nums = new int[n + 1];
        // nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i / 2] +i % 2 * nums[i / 2 + 1]; // 奇数判断为0
            /*if(i % 2 == 0) { // 偶数->[i/2]
                nums[i] = nums[i / 2];
            }else { // 奇数->[i/2] + [i/2+1]
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }*/
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // 左括号加 右括号减 与左匹配
    public int maxDepth(String s) {
        int max = 0; // 嵌套深度
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                size++;
                max = Math.max(max, size);
            } else if(s.charAt(i) == ')') {
              size--;
            }
        }
        return max;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
