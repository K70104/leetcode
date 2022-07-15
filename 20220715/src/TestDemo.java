import java.util.*;


class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public void TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 是不是相同的树
        if (isSameTree(A, B)) {
            return true;
        }
        // A 的左子树或右子树是不是 B
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 是否为相同的树
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 先判断 root2 为空，返回 true
        // 另一棵树的子树 https://leetcode.cn/problems/subtree-of-another-tree/submissions/
        // 测试用例：
        // [10,12,6,8,3,11]
        // [10,12,6,8]
        // 此题判断子结构为 true。(572 题另一棵树的子树)为 false。画图即可看出
        if (root2 == null) {
            return true;
        }
        // 一个为空 一个不为空
        if (root1 == null && root2 != null || root1 != null && root2 == null) {
            return false;
        }
        // 或都不为空 -> 判断 val
        if (root1.val != root2.val) {
            return false;
        }
        // 左树与右树是否相同
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    // 双端队列 + boolean 判断当前是不是从右向左
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>(); // 普通队列 找每一层
        queue.offer(root);
        boolean flg = false;
        while (!queue.isEmpty()) {
            int size = queue.size(); // 每一层
            Deque<Integer> deque = new LinkedList<>(); // 双端队列 用 flg 分左右加入
            while (size != 0) {
                TreeNode cur = queue.poll();
                if (flg) { // 从右到左
                    deque.addFirst(cur.val);
                } else { // 从左到右
                    deque.addLast(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            list.add(new ArrayList<>(deque)); // 加入此层
            flg = !flg; // 下一行打印相反
        }
        return list;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list; // root 为空
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 一层 List<Integer>
            List<Integer> ret = new ArrayList<>();
            while (size != 0) {
                TreeNode cur = queue.poll();
                ret.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            list.add(ret);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
