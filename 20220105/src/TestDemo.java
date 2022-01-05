import java.util.Arrays;
import java.util.HashSet;

public class TestDemo {
    public String modifyString(String s) {
        char[] array = s.toCharArray();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            // if(!Character.isLetter(array[i])) { // 不是字母
            if(array[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ch++) { // 用 a b c 判断
                    if((i > 0 && array[i - 1] == ch) || (i < len - 1 && array[i + 1] == ch)) {
                        continue; // 判断前 判断后
                    }
                    array[i] = ch;
                    break;
                }
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
