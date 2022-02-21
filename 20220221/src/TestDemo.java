import java.util.*;

// 入栈时，入到不为空的队列，都为空就指定一个
// 出栈时，在不为空的队列，出 size - 1 个元素，剩下的一个就是要出栈的元素
class MyStack {

    public Queue<Integer> qu1;
    public Queue<Integer> qu2;

    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x) {
        if(empty()) {
            qu1.offer(x);
        } else if (!qu1.isEmpty()) {
            qu1.offer(x);
        } else {
            qu2.offer(x);
        }
    }

    public int pop() {
        if(empty()) return -1;
        if(!qu1.isEmpty()) {
            int size = qu1.size();
            for (int i = 0; i < size - 1; i++) {
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        }
        if(!qu2.isEmpty()) {
            int size = qu2.size();
            for (int i = 0; i < size - 1; i++) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
        return -1;
    }

    public int top() {
        if(empty()) return -1;
        if(!qu1.isEmpty()) {
            int val = -1;
            int size = qu1.size();
            for (int i = 0; i < size; i++) {
                val = qu1.poll();
                qu2.offer(val);
            }
            return val;
        }
        if(!qu2.isEmpty()) {
            int val = -1;
            int size = qu2.size();
            for (int i = 0; i < size; i++) {
                val = qu2.poll();
                qu1.offer(val);
            }
            return val;
        }
        return -1;
    }

    public boolean empty() {
        return qu1.isEmpty() && qu2.isEmpty();
    }
}

public class TestDemo {
    public int sqrt (int x) {
        if(x == 1) return 1;
        int left = 1;
        int right = x / 2; //
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(x / mid > mid) { //不用x > mid * mid 防溢出
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }

    // 2、根据平方数的性质——连续n个奇数相加的结果一定是平方数
    public int sqrt2 (int x) {
        if(x < 0) return 0;
        int i = 1;
        int ans = 0;
        while(x >= 0) {
            x -= i;
            i += 2;
            ans++;
        }
        return ans -1;
    }

    public int sqrt1 (int x) {
        // write code here
        double mul = Math.sqrt(x);
        return (int)Math.floor(mul);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             if(ch == '(' || ch == '{' || ch == '[') {
                 stack.push(ch);
             } else {
                 if(stack.empty()) {
                     return false;
                 }
                 char top =stack.peek();
                 if (top == '(' && ch == ')' || top == '[' && ch == ']' || top == '{' && ch == '}') {
                     stack.pop();
                 }else {
                     return false;
                 }
             }
        }
        return stack.empty();
    }

    // 单调栈 + map
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>(); // 从小到大
        Map<Integer, Integer> map = new HashMap<>(); // 记录映射关系
        for (int i = nums2.length - 1; i >= 0; i--) { // 从后往前 记录nums2中向左第一个最大值
            int num = nums2[i];
            while(!stack.isEmpty() && num >= stack.peek()) {
                stack.pop(); // 比栈顶大或等于 出栈 判断下一个
            }
            // 空-> 右边无比之大的数 存储-1    不为空 -> 存储
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num); // 入栈
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]); // 数组元素不重复 通过map找到当前数据对应的第一个最大值
        }
        return ans;
    }

    // 暴力算法 O(n*m)
    // 找在nums2中的位置->j  往后找第一个大的k  判断是否<n  若存在加入数组
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int j = 0;
            while(j < n && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while(k < n && nums2[k] < nums1[i]) {
                k++;
            }
            ans[i] = k < n ? nums2[k] : -1;
        }
        return ans;
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int index = 0;
        for(int j = 1; j <= n && index < target.length; j++) {
            if(j == target[index]) { // 一个匹配 到 下一个元素
                list.add("Push");
                index++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
