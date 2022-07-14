import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    public void TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int[] array = new int[1000];
        int cnt = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size != 0) {
                TreeNode tmp = deque.pop();
                array[cnt++] = tmp.val;
                if (tmp.left != null) {
                    deque.offer(tmp.left);
                }
                if (tmp.right != null) {
                    deque.offer(tmp.right);
                }
                size--;
            }
        }
        return Arrays.copyOfRange(array, 0, cnt);
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
