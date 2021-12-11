import java.util.HashMap;

public class Test {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Boolean>  map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if(map.containsKey(c)) {
                map.put(c, false); // 重复 置为false
            }else {
                map.put(c, true); // 第一次出现
            }
        }
        for (int i = 0; i < chars.length; i++) {
            // 根据指定的k 查找对应的v 为true返回
            if(map.get(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar1(String str) {
        int[] times = new int[123];
        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            // 遍历字符串 返回下标
            if(times[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int maxProfit (int[] prices) {
        // write code here
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int maxProfit1 (int[] prices) {
        // write code here

        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                if(i == j) continue;
                int sub = prices[j] - prices[i];
                if(max < sub) {
                    max = sub;
                }
            }
        }
        return max;
    }

    public boolean isPalindrome2(int x) {
        int tmp = x;
        int comp = x;
        while(x != 0) {
            comp += x % 10;
            x /= 10;
        }
        if(tmp == comp) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome1(int x) {
        StringBuilder sb = new StringBuilder(x+"").reverse();
        if(sb.toString().equals(x+"")) {
            return true;
        }
        return false;
    }

    public static int reverse(int x) {
        int res = 0;
        while(x != 0) {
            // 判断未来 下一次的范围 否则x==0 直接返回超范围的res
            if(res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10) {
                return 0;
            }
            res = res*10 + x%10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        int ret = reverse(x);
        System.out.println(ret);
    }
}
