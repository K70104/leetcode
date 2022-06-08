import java.util.Scanner;

public class TestDemo {
    private static int longestAscStr(int n, int[] array) {
        int[] dp = new int[n]; // 保存以array[i]结尾的序列最长上升子序列元素的个数
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            //-求以array[i]结尾的序列的最长上升子序列的个数
            // 将array[i]与array [0 ]~array [i-1]比较
            // -array[i] >·array[j] : ·dp[i]·=Math.max (dp[i],dp[j+l)
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println(longestAscStr(n, array));
        }
    }
}