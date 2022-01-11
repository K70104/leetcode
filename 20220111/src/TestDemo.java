import java.util.Arrays;

public class TestDemo {
    // 在原数组更改
    public static int[] buildArray(int[] nums) {
        // 范围 [0, 999]  用%1000取原值
        // 最终值 原数值
        for(int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }

    public int[] buildArray1(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 5, 3, 4};
        int[] ret = buildArray(array);
        System.out.println(Arrays.toString(ret)); // [0, 1, 2, 4, 5, 3]
    }

    public int minCount(int[] coins) {
        int cnt = 0;
        for(int n : coins) {
            // cnt += n / 2;
            // if(n % 2 != 0) {
            //     cnt += 1;
            // }
            cnt += n / 2 + n % 2;
        }
        return cnt;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
