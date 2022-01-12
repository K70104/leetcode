

public class TestDemo {
    // 赋初始值的时候，已经满足second > first了，现在找第三个数third
    // (1) 如果third比second大，那就是找到了，直接返回true
    // (2) 如果third比second小，但是比first大，那就把second的值设为third，然后继续遍历找thrid
    // (3) 如果third比first还小，那就把first的值设为third，然后继续遍历找thrid
    // （这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if(num > second) {
                return true;
            } else if (num >first) { // 比second小 比first大
                second  = num;
            } else {
                first = num; // 比first小
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2,8,9,1,4,5};
        System.out.println(increasingTriplet(array));
    }

    public boolean increasingTriplet1(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return false;
        }
        // leftMin[i] 表示 nums[0] 到 nums[i] 中的最小值，
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }
        // rightMax[i] 表示 nums[i] 到 nums[n−1] 中的最大值。
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        // 查找是否存在一个下标 i 满足 leftMin[i−1] < nums[i] < rightMax[i + 1]
        for (int i = 1; i < n - 1; i++) {
            if(leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
