import java.util.Arrays;

public class TestDemo {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
