import java.util.Arrays;
import java.util.HashMap;

public class Test {
    // 最大值 m1，和次大值 m2，如果 m1 >= m2*2，同时记录 m1 下标
    public int dominantIndex(int[] nums) {
        int m1 = -1;
        int m2 = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > m1) {
                m2 = m1;
                m1 = nums[i];
                index = i;
            } else if(nums[i] > m2) {
                m2 = nums[i];
            }
        }
        return m1 > m2 * 2 ? index : -1;
    }

    public int dominantIndex1(int[] nums) {
        // 用array找max
        int[] array = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array);
        int max = array[array.length - 1];

        int index = 0; // 记录下标
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == max) {
                flag++;
                index = i;
            }else if(nums[i] * 2 > max) {
                return -1;
            }
            if(flag > 1) { // 不止一个最大数
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
