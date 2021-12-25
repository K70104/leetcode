import java.util.Arrays;

public class TestDemo {
    // 位运算
    public int[] singleNumber(int[] nums) {
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum ^= nums[i];
        }
        // 取最低位 1  防溢出
        int lsb = sum == Integer.MIN_VALUE ? sum : sum & (-sum);
        int type1 = 0;
        int type2 = 0;
        // 为 0 为 1 分成两组
        for(int n : nums) {
            if((lsb & n) != 0) {
                type1 ^= n;
            }else {
                type2 ^= n;
            }
        }
        return new int[]{type1, type2};
    }

    public int[] singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int ret = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; i++) {
            ret ^= nums[i];
        }
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if((nums[i] ^ nums[j]) == ret) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
