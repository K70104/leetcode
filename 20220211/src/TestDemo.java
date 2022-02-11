import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 滑动窗口最右边的值就是窗口内的最大值，滑动窗口最左边的值就是窗口内的最小值
// 因此，我们要寻找的就是已经排序的数组中，所有大小为 k 的滑动窗口中，最右端数字 - 最左端数字 的最小结果
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i + k - 1 < nums.length; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }

    // 滑动窗口：通过两个指针截取固定长度的数组
    public int minimumDifference1(int[] nums, int k) {
        //   先将数组进行排序
        Arrays.sort(nums);
        // 截取一定长度的数组
        int left=0;
        int right=k-1;
        // 创建一个变量保存最小的差值
        int min = Integer.MAX_VALUE;
        while(right < nums.length) {
            min = Math.min(min, nums[right] - nums[left]);
            left++;
            right = left + k - 1;
        }
        return min;
    }
}

public class TestDemo {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        return min;
    }

    // 更相减损法
    int gcd(int a, int b) {
        while(true) {
            if(a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            } else {
                return a;
            }
        }
    }

    // 欧几里得算法
    int gcd1(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
        // int c = a % b;
        // while(c != 0) {
        //     a = b;
        //     b = c;
        //     c = a % b;
        // }
        // return b;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                if(gcd(i, j) == 1) {
                    list.add(i + "/" + j);
                }
            }
        }
        return list;
    }
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            ans += map.getOrDefault(n + k, 0) + map.getOrDefault(n - k, 0);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return ans;
    }

    public int countKDifference1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
