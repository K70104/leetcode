

public class TestDemo {
    // O(logn) 二分查找
    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if(mid % 2 == 0) { // 偶数
                if(nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else { // 奇数
                if(nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }

    // 用异或来进行统一，因为 偶数异或1 等于 加1，奇数异或1 等于 减1
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

    // O(n) 每两个遍历
    public int singleNonDuplicate1(int[] nums) {
        for(int i = 0; i < nums.length - 1; i += 2) {
            if(nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int maxNumberOfBalloons(String text) {
        // 此单词每个字符次数
        int[] times = new int[5];
        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(ch == 'b') {
                times[0]++;
            } else if (ch == 'a') {
                times[1]++;
            } else if (ch == 'l') {
                times[2]++;
            } else if (ch == 'o') {
                times[3]++;
            } else if(ch == 'n'){
                times[4]++;
            }
        }
        // 'l' 'o' 有两次
        times[2] /= 2;
        times[3] /= 2;

        int min = times[0];
        for (int i = 0; i < 5; i++) {
            min = Math.min(min, times[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
