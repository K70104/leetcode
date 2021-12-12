import java.util.Arrays;

public class TestDemo {
    // 快慢指针
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while(fast < len) {
            if(nums[fast] != nums[fast-1]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public int removeDuplicates1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length -1;
        for (int i = 0; i < len; i++) {
            if(nums[i] == nums[i+1]) { // 一样
                // 往前放
                for (int j = i; j < len; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                len--;
            }
        }
        return len+1;
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public String toLowerCase1(String s) {
        return s.toLowerCase();
    }

    public int sqrt (int x) {
        // write code here
        double mul = Math.sqrt(x);
        return (int)Math.floor(mul);
    }

    public static void main(String[] args) {
        double d = 100.675;
        double e = 100.500;

        System.out.println(Math.round(d)); // 101
        System.out.println(Math.round(e)); // 101

        System.out.println(Math.floor(d)); // 100.0
        System.out.println(Math.floor(e)); // 100.0
    }

    public static void main1(String[] args) {
        String str = "abc";
        int b = Integer.parseInt("444", 8);
        System.out.println(b);
    }
}
