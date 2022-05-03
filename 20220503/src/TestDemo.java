import java.util.*;

// public
class ClassD {// ClassD 为外部类，可以没有 public , 且只能带上 public， 不可以使用 protected,private 等其他

    // public， protected
    private static final class E {// E 为成员内部类, 可以加上 public，protected，private， 等和 static final
    }

    public static void main(String[] args) {
        class G {// 局部内部类
        }
    }

    public void test() {
        final class H {// 局部内部类 ， 不可以加上 static 和 public，protected，private 等, 可以带上 final
        }
    }
}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 尾部插入
    public void appendTail(int value) {
        stack1.push(value);
    }

    // 头部删除
    public int deleteHead() {
        if (stack1.empty() && stack2.empty()) {
            return - 1;
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.empty()) {
            if (x <= minStack.peek()) { // 小于等于
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (!minStack.empty()) {
            if (top == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

public class TestDemo {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // 以标志符分成两部分 标志符 和 内容串
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                // 判断是数字日志还是字母日志 比较内容串的第一个即可
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (isDigit1 && isDigit2) { // 都是数字
                    return 0;
                } else if (!isDigit1 && !isDigit2) { // 都是字母
                    int cmp = split1[1].compareTo(split2[1]); // 比较内容串 split1>split2 返回>0，等于返回0，小于返回<1
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]); // 内容串一样 比较标志符
                } else { // 有一个是字母
                    return isDigit1 ? 1 : -1; // split1 是数字，split1>split2，返回 1，split2 是字母，放前面
                }
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] s = {"def", "geh", "abc"};
        Arrays.sort(s, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(Arrays.toString(s)); // [abc, def, geh]
        Arrays.sort(s, (s1, s2) -> {
            return s2.compareTo(s1);
        });
        System.out.println(Arrays.toString(s)); // [geh, def, abc]
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.contains(1);
        collection.size();
        collection.isEmpty();
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
