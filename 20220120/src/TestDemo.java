import org.omg.PortableInterceptor.INACTIVE;

import javax.transaction.TransactionRequiredException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class TestDemo {
    // 哈希表  x(x-1)/2
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getValue();
            cnt += x * (x - 1) / 2;
        }
        return cnt;
    }

    // 数组下标 相当于排列求和
    // 假设nums = [1,1,1,1]
    // 第一遍   temp是[0,0,0,0]   ans+=0   temp[0]++
    // 第二遍   temp是[1,0,0,0]   ans+=1   temp[0]++
    // 第三遍   temp=[2,0,0,0]    ans+=2   temp[0]++
    // 第四遍   temp=[3,0,0,0]   ans+=3    temp[0]++
    public int numIdenticalPairs2(int[] nums) {
        int cnt = 0;
        int[] counter = new int[101];
        for(int x : nums) {
            cnt += nums[x];
            nums[x]++;
        }
        return cnt;
    }

    // 暴力
    public int numIdenticalPairs1(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> queue = new LinkedList<>(); // 合并的队列
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merged);
        queue1.offer(root1);
        queue2.offer(root2);
        while(!queue2.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left;
            TreeNode right1 = node1.right, right2 = node2.right;

            if(left1 != null || left2 != null) {
                if(left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }

            if(right1 != null || right2 != null) {
                if(right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }

        return merged;
    }

    // 层序遍历
    // 每次拓展下一层的时候，将队列里的所有节点都拿出来进行拓展，
    // 保证每次拓展完的时候队列里存放的是当前层的所有节点
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0; // 拓展的次数
        while(!queue.isEmpty()) {
            int size = queue.size(); // 每一层全部取出
            TreeNode cur = queue.poll();
            while(size != 0) {
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


















    public static void main(String[] args) {
        System.out.println(123);
    }
}
