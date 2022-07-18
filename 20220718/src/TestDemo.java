import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}


public class TestDemo {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    // dp[i] = dp[i-1] + dp[i-2]
    public int numWays(int n) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 1;
        for (int i = 2; i <= n; i++) {
            n3 = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    private final int MOD = 1000000007;

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        for (int i = 2; i <= n; i++) {
            f3 = (f1 + f2) % MOD;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    // 2、循环 队列
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check2(root, root);
    }

    private boolean check2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }


    // 1、递归
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) { // 都为空
            return true;
        }
        if (p == null || q == null) { // 一个为空 一个不为空
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
