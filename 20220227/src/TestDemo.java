import java.util.*;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {

    /**
     * 前序遍历
     * @param root
     */
    public void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }



    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode root) {
        if(root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 节点个数
     * @param root
     * @return
     */
    public int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    /**
     * 叶子结点个数
     * @param root
     * @return
     */
    public int getLeafNodeCount(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    /**
     * 第 k 层节点个数
     * @param root
     * @param k
     * @return
     */
    public int getKLevelNodeCount(TreeNode root, int k) {
        if(root == null || k < 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    /**
     * 查找节点
     * @param root
     * @param val
     * @return
     */
    TreeNode find(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left, val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right, val);
        if(ret != null) {
            return ret;
        }
        return null;
    }


    /**
     * 层序遍历
     * @param root
     */
    public void levelOrder(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    public List<Integer> list = new ArrayList<>();
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.right);
        list.add(root.val);
        inOrder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);

        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;

        for (int val : list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }

        return dummy.right;
    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : array) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println(map);
    }
}
