import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int first = s.length(); // first 如果还是 len，没有出现第一次的字符
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v != -1) {
                if (v < first) { // 第一个出现的
                    first = v;
                }
            }
        }
        return first == s.length() ? ' ' : s.charAt(first);
    }

    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid; // mid 小，right 到 mid 的位置，mid 可能会是最小
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1; // mid 大，丢弃左边
            } else {
                right--; // 重复元素
            }
        }
        return numbers[left];
    }

    public int missingNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= i; // 0 - n-1
            n ^= nums[i];
        }
        return n ^ nums.length; // n
    }

    // 二分查找
    // rightIdx - leftIdx
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int leftIdx = binarySearch(nums, target);
        int rightIdx = binarySearch(nums, target + 1);
        return rightIdx - leftIdx;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {2,2,2,0,1};
        int t = minArray(array);
        System.out.println(t);
    }
}
