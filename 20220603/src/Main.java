import java.util.*;

// 保存子树的前序 后序 遍历结果
class SubTree {
    String pre;
    String post;
    public SubTree(String pre, String post) {
        this.pre = pre;
        this.post = post;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder s1 = new StringBuilder(scanner.next());
            StringBuilder s2 = new StringBuilder(scanner.next());
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            // 1、s1,s2 补齐到 len2
            // 注意：s1 补 'a'，s2 补 'z' + 1，否则会少
            for (int i = s1.length(); i < len2; i++) {
                s1.append('a');
            }
            for (int i = s2.length(); i < len2; i++) {
                s2.append('z' + 1);
            }
            // 2、保存 s1,s2 对应位置字符相减的结果
            int[] array = new int[len2]; // 字符串 从下标0放入数组
            for (int i = 0 ; i < len2; i++) {
                array[i] = s2.charAt(i) - s1.charAt(i);
            }
            // 3、运算
            long ans = 0;
            for (int i = len1; i <= len2; i++) {
                for (int j = 0; j < i; j++) { // 计算时 是根据长度的增加 从最右边是0次方开始
                    ans += array[j] * Math.pow(26, i - j - 1);
                }
            }
            System.out.println((ans - 1) % 1000007);
        }
    }


    private static int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右

    private static void dfs(char[][] board, int n, int m, int x, int y, boolean[][] flag, int count) {
        if (flag[x][y]) { // 已遍历
            return;
        }
        if (board[x][y] == '#') { // 白棋
            return;
        }
        // 没有遍历 且为黑棋
        count++;
        flag[x][y] = true;
        // 递归遍历计算 四个方向
        for (int i = 0; i < 4; i++) {
            int nx =  direct[i][0] + x;
            int ny = direct[i][1] + y;
            if (nx >= 0 && nx < n && ny >=0 && ny < m) { // 没有越界
                dfs(board, n, m, nx, ny, flag, count);
            }
        }
    }

    public static void main5(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] board = new char[n][m];
            int x = 0, y = 0; // 起始所在的位置
            for (int i = 0; i < n ; i++) {
                String s = scanner.next();
                for (int j = 0; j < m; j++) {
                    board[i][j] = s.charAt(j);
                    if (s.charAt(j) == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            boolean[][] flag = new boolean[n][m]; // 标记已遍历过
            int count = 0;
            dfs(board, n, m, x, y, flag, count);
            System.out.println(count);
        }
    }



    private static double probability(int[][] map, int n, int m) {
        double[][] dp = new double[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i != 1 && j != 1) {
                    //              从上面来，它的右方有没有                从左面来，它的下方有没有
                    dp[i][j] = dp[i - 1][j] * (j == m ? 1.0 : 0.5) + dp[i][j - 1] * (i == n ? 1.0 : 0.5);
                }
                if (map[i][j] == 1) { // 是蘑菇
                    dp[i][j] = 0.0;
                }
            }
        }
        return dp[n][m];
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            // 在地图上设置 k 个蘑菇障碍
            int[][] map = new int[n + 1][m + 1];
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[x][y] = 1;
            }
            System.out.printf("%.2f\n", probability(map, n, m));
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Deque<String> stack = new LinkedList<>();
            int n = scanner.nextInt();
            scanner.nextLine(); //
            int total = 0;
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                String[] op = s.split(" ");
                if (op[1].equals("connect")) {
                    stack.push(op[1]);
                    total = Math.max(total, stack.size());
                } else {
                    stack.pop();
                }
            }
            System.out.println(total);
        }
    }



    // 计算 n 的阶乘
    private static long fac(int n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    // 计算组合
    private static long calcCom(int n, int m) {
        m = m < (n - m) ? m : (n - m); // C(n, m) = C(n, n-m)
        long r = 1;
        for (int i = n; i >= n - m + 1; i--) {
            r *= i;
        }
        return r / fac(m);
    }

    // 分离根节点有多少颗子树
    private static List<SubTree> calcSubTree(String pre, String post) {
        int subRootPreInx = 1; // 子树的根在前序遍历结果中的位置   根--->子树1--->子树2--->...--->子树n
        int postFirst = 0; // 后序遍历 : 子树1-->子树2-->...--->子树n-->根节点
        List<SubTree> list = new ArrayList<>();
        while (subRootPreInx < pre.length()) {
            char rootSub = pre.charAt(subRootPreInx); // 确认该颗子树的根节点 从前序遍历中找根
            int subRootPostInx = post.indexOf(rootSub); // 从后序遍历中找根的位置
            int subTreeNodeCount = subRootPostInx - postFirst + 1; // 该颗子树中总共有多少个节点
            SubTree subTree = new SubTree(
                    pre.substring(subRootPreInx, subRootPreInx + subTreeNodeCount),
                    post.substring(postFirst, postFirst + subTreeNodeCount)
            ); // 从前序遍历和后序遍历结果中分离出该棵子树的 前序和后序遍历结果
            list.add(subTree); // 保存 子树的 前序和后序遍历结果
            subRootPreInx += subTreeNodeCount; // 分离下一颗子树
            postFirst += subTreeNodeCount;
        }
        return list;
    }

    private static long calcPossibilitiesOfTree(int n, String pre, String post) {
        if (pre.isEmpty() || pre.length() == 1) { // 没有节点 或 只有一个节点
            return 1;
        }
        List<SubTree> subTree = calcSubTree(pre, post); // 分离根节点有多少颗子树
        long result = calcCom(n, subTree.size()); // 根节点子树 的可能性的 组合 结果
        for (SubTree e : subTree) { // 递归计算 根的子树 分别有多少种可能性
            result *= calcPossibilitiesOfTree(n, e.pre, e.post);
        }
        return result;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) { // An input line of 0 will terminate the input.
                break;
            }
            String pre = scanner.next();
            String post = scanner.next();
            long ret = calcPossibilitiesOfTree(n, pre, post);
            System.out.println(ret);
        }
    }
}