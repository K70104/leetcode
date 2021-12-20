import java.util.*;

public class TestDemo {


    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                answer.add("FizzBuzz");
            }else if(i % 3 == 0) {
                answer.add("Fizz");
            }else if(i % 5 == 0) {
                answer.add("Buzz");
            }else {
                answer.add(i+"");
            }
        }
        return answer;
    }

    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        long n = num < 0 ? (long)num + (1L << 32) : num;
        StringBuilder sb = new StringBuilder();
        String letter = "abcdef";
        while(num != 0) {
            int ret = num % 16;
            if(ret >= 10) {
                sb.append(letter.charAt(ret-10));
            } else {
                sb.append(num);
            }
            num /= 16;
        }
        return sb.reverse().toString();
    }

    public char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < ss.length; i++) {
            if(ss[i] != tt[i]) {
                return tt[i];
            }
        }
        return tt[tt.length-1];
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int cnt = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), cnt);
        }
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) { // 找次数为1
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
