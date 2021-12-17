import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TestDemo {
    // 数学求和 n(n+1)/2
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumN = (1+n)*n/2; // 1-N 的和
        int sumNums = 0; // 数组的和
        for(int i = 0; i < n; ++i) {
            sumNums += nums[i];
        }
        return sumN - sumNums;
    }

    // 哈希
    public int missingNumber3(int[] nums) {
        Arrays.sort(nums); // 排序后判断加入的nums[i]是否是i
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if(!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }

    // 排序
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    // 按位异或 同为0 异为1
    public int missingNumber1(int[] nums) {
        int len = nums.length; // 长度就是最大值
        int ret = nums[0];
        for (int i = 1; i < len; i++) {
            ret ^= nums[i]; // 数组的每一位
            ret ^= i; // i
        }
        ret ^= len;
        return ret;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 哈希表  限定范围 只需要判断有重复直接返回true
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(0);
            }
        }
        return false;
    }

    // 排序 相邻比较相等
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // 哈希
    public boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int n : nums) {
            /*if(map.contains(n)) {
                return true;
            }
            map.add(n);*/

            // 如果 e 已经存在于 set 中，那么 add() 方法就会返回 false
            if(!map.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // System.out.println(numWaterBottles(5, 5));
    }

    public int numWaterBottles2(int numBottles, int numExchange) {
        return numBottles + (numBottles-1)/(numExchange-1);
    }

    public int numWaterBottles1(int numBottles, int numExchange) {
        int total = numBottles;
        while(numBottles >= numExchange) {
            total += numBottles / numExchange;
            // 加不够换剩下的
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return total;
    }
}
