import java.util.*;

public class TestDemo {
    // 哈希
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set  = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if(!set.contains(n)) {
                set.add(n);
            }else {
                list.add(n); // 重复
            }
        }
        return list;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length < 2) {
            return list;
        }
        if(nums.length == 2) {
            if(nums[0] == nums[1]) {
                list.add(nums[0]);
            }
            return list;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i-1] == nums[i] && nums[i] != nums[i+1]) {
                list.add(nums[i]);
            }
        }
        // [1,1,2,3,4,5,7,9,10,10] 最后两个相等
        if(nums[nums.length-1] == nums[nums.length-2]) {
            list.add(nums[nums.length-1]);
        }
        return list;
    }

    // 加长度
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            int len = nums.length;
            nums[(n-1) % nums.length] += nums.length; // 下标 加len
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 2*nums.length && nums[i] < 3*nums.length+1) {
                list.add(i+1);
            }
        }
        return list;
    }

    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long total = mid * (mid + 1) / 2;
            if(total == n) {
                return (int)mid;
            }
            if(total > n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int)right;
    }

    // 该下标对应的字符不为空格；
    // 该下标为初始下标或者该下标的前下标对应的字符为空格；
    public int countSegments1(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                cnt++;
            }
        }
        return cnt;
    }

    public int countSegments(String s) {
        int cnt = 0;
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals(" ")) {
                cnt++;
            }
        }
        return cnt;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0) {
            int x = i-- >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j-- >= 0 ? num2.charAt(i) - '0' : 0;
            int result = x + y + carry;
            sb.append(result % 10);
            carry = result / 10; // 进位
        }
        sb.reverse(); // 逆置
        return sb.toString();
    }

    public int dayOfYear(String date) {
        String[] strings = date.split("-");
        int year = Integer.parseInt(strings[0]);
        int month = Integer.parseInt(strings[1]);
        int day = Integer.parseInt(strings[2]);
        int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year % 4 == 0 && (year & 100) != 0 || year % 4== 0) {
            amount[1]++;
        }
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += amount[i];
        }
        return ans + day;
    }

    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE;
        long b = Long.MIN_VALUE;
        long c = Long.MIN_VALUE;
        for (long n : nums) {
            if(n > a) {
                c = b;
                b = a;
                a = n;
            } else if (a > n && n > b) {
                c = b;
                b = n;
            } else if (b > n && n > c) {
                c = n;
            }
        }
        return c == Long.MIN_VALUE ? (int)a : (int)c;
    }

    public int thirdMax2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
            if(set.size() > 3) { // 超过3个 删除最小
                set.remove(set.first());
            }
        }
        // 有序集合大小为3，最小值就是第三大的数；不足3，返回最大值。
        return set.size() == 3 ? set.first() : set.last();
    }

    // 排序 逆置 找第三
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        reverse(nums);
        for (int i = 0, diff =  1; i < nums.length - 1; i++) {
            if(nums[i] != nums[i+1] && ++diff == 3) {
                return nums[i+1];
            }
        }
        return nums[0];
    }

    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
