import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo {
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : words) { // 统计单词次数
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int ans = 0; // 最长回文串长度
        boolean mid = false; // 是否含有中心单词
        for(String str : map.keySet()) {
            StringBuilder sb = new StringBuilder(str).reverse(); // 反转
            String rev = sb.toString();
            // 1、两个字符相同的单词 成对选择该单词
            if (str.charAt(0) == str.charAt(1)) {
                if(map.get(str) % 2 != 0) { // 中心单词
                    mid = true;
                }
                ans += map.get(str) / 2 * 4;
            } else if(map.containsKey(rev)) { // 2、两个字符不同的单词 成对选择反转单词
                int cnt = Math.min(map.get(str), map.get(rev));
                ans += cnt * 4;
                map.put(str, map.get(str) - cnt);
                map.put(rev, map.get(rev) - cnt);
            }
        }
        if(mid) {
            ans += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"lc","cl","gg"};
        System.out.println(longestPalindrome(words));
    }

    // 1.不断的读入字符直到遇到.就结束
    // 2.需要2个标记 A和B 默认为0 读入一个字符的时候 若不是空格 A= A+1 若是空格 就A-B得出长度输出 然后 B=A
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] ret = str.split(" ");
        int flag = 1;
        for (int i = 0; i < ret.length; i++) {
            if (ret[i].equals("")) {
                continue;
            }
            if(i != ret.length - 1){
                if(flag == 1) {
                    System.out.print(ret[i].length());
                    flag = 0;
                }else {
                    System.out.print(" ");
                    System.out.print(ret[i].length());
                }
            }
            if(i == ret.length - 1 && !ret[i].equals(".")) { // 最后一个 不是点 减一
                System.out.print(" ");
                System.out.print(ret[i].length() - 1);
            }
        }
    }

    public static void main1(String[] args){
        System.out.println(123);
    }
}
