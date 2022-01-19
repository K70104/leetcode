import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class TestDemo {
    // 存3002的时候删除1，因为1不在[2,3002]之间，而100，3001，3002都是在[2,3002]之间，返回siz为3；
    /*Queue<Integer> que;

    public RecentCounter() {
        que = new LinkedList();
    }

    public int ping(int t) {
        que.offer(t);
        while(que.peek() < t - 3000) {
            que.poll();
        }
        return que.size();
    }*/

    // 双指针 逆序遍历
    // 定义 skip 意为需要跳过的字符数量，skip ！= 0 跳过当前字符
    // 直到两字符串能够各自确定一个字符，然后将这两个字符进行比较
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skip1 = 0;
        int skip2 = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0) {
                if(s.charAt(i) == '#') { // 需要跳过的字符+1
                    skip1++;
                    i--;
                } else if(skip1 > 0) { // 跳过
                    skip1--;
                    i--;
                } else {
                    break; // 不需要删的字符 出去比较是否相等
                }
            }
            while(j >= 0) {
                if(t.charAt(i) == '#') {
                    skip2++;
                    j--;
                } else if(skip2 > 0) {
                    skip2--;
                    j--;
                } else {
                    break;
                }
            }
            if(i >= 0 && j >= 0) {
                if(s.charAt(i) != t.charAt(j)) { // 字符不相等
                    return false;
                }
            } else {
                if(i >= 0 || j >= 0) { // 有一个遍历完
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

        // 重构字符串
    // 退格符和应当被删除的字符都去除 比较两字符串是否相等
    public static boolean backspaceCompare2(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            }  else {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1); // 删除最后一个下标的元素
                }
            }
        }
        return sb.toString();
    }

        // 如果相等，返回 true ；否则，返回 false
    // 注意：如果对空文本输入退格字符，文本继续为空
    public static boolean backspaceCompare1(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int len = Math.max(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if(i < s.length()) {
                if(s.charAt(i) != '#') {
                    stack1.push(s.charAt(i));
                } else if (s.charAt(i) == '#' && !stack1.empty()) { // 退格 栈不为空
                    stack1.pop();
                }
            }
            if(i < t.length()) {
                if(t.charAt(i) != '#') {
                    stack2.push(t.charAt(i));
                } else if (t.charAt(i) == '#' && !stack2.empty()){
                    stack2.pop();
                }
            }
        }
        if(stack1.size() != stack2.size()) {
            return false;
        }
        int size = stack1.size(); //
        for (int i = 0; i < size; i++) {
            if(stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bbcd";
        backspaceCompare(s, t);
    }

    // 整数 x - 表示本回合新获得分数 x
    // "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
    // "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
    // "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
    // ops = ["5","2","C","D","+"]
    // 输出：30
    public int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String str = ops[i];
            if(str.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.peek(); // 前第二个
                stack.push(num1); // 重新加入
                stack.push(num1 + num2);
                ans += stack.peek();

            } else if (str.equals("D")) {
                stack.push(stack.peek() * 2);
                ans += stack.peek();

            } else if (str.equals("C")) {
                int ret = stack.pop();
                ans -= ret;

            } else {
                // 是数字 -> 转数字 入栈
                stack.push(Integer.parseInt(str));
                ans += stack.peek();
            }
        }
        return ans;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if(!isOperation(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(str) {
                    case "+":
                        stack.add(num2 + num1);
                        break;
                    case "-":
                        stack.add(num2 - num1);
                        break;
                    case "*":
                        stack.add(num2 * num1);
                        break;
                    case "/":
                        stack.add(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static boolean isOperation(String str) {
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            return true;
        }
        return false;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
