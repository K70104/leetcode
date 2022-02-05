import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0; // maxLen
        int cnt = 0;
        for(int x[] : rectangles) {
            int min = Math.min(x[0], x[1]); // 每组中的最小边长

            if(min > maxLen) {
                cnt = 1; // 更新最大边长数
            }
            if(min == maxLen) {
                cnt++;
            }

            maxLen = Math.max(min, maxLen);
        }
        return cnt;
    }

    // 获取1-k的数列  从大到小找
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int f1 = 1;
        int f2 = 1;
        while (f1 + f2 <= k) {
            int f3 = f1 + f2;
            list.add(f3);
            f1 = f2;
            f2 = f3;
        }

        int ans = 0;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            int num = list.get(i);

            // ans += k / num;
            // k %= num;

            // 斐波那契数字为：1，1，2，3，5，8，13
            // k = 19
            // 输出：3
            // 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19
            if(k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
