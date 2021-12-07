import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class Base {
    private int x;
    private int y;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int calculate() {
        if (avg() == 0) {
            return 0;
        } else {
            return sum() / avg();
        }
    }

    /**
     * 返回x和y的和
     */
    public abstract int sum();

    /**
     * 返回x和y的平均值
     */
    public abstract int avg();
}

class Sub extends Base {
    //write your code here......
    public int sum() {
        return super.getX() + super.getY();
    }
    public int avg() {
        return sum() / 2;
    }
}

public class Test {
    public static void main(String[] args) {
        String string = "H e l l o ! n o w c o d e r";
        Scanner scanner= new Scanner(System.in);
        String word = scanner.next();
        scanner.close();
        System.out.println(check(string, word));
    }

    public static int check(String str, String word) {
        //write your code here......
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return Collections.frequency(list, word.charAt(0));
    }

    public static int check2(String str, String word) {
        //write your code here......
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == word.charAt(0)) {
                cnt++;
            }
        }
        return cnt;
    }


    public static int check1(String str, String word) {
        //write your code here......
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String s = new String(ch+"");
            if(s.equals(word)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        //write your code here......
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            cnt++;
            if(cnt % 3 == 0 && i != 0)  {
                sb.append(",");
            }
        }
        System.out.println(sb.reverse());
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        //write your code here......
        StringBuffer sb = new StringBuffer(str);
        for (int i = str.length() - 3; i >= 0; i -= 3) {
            sb.insert(i, ",");
        }
        System.out.println(sb);
    }

    public static void main1(String[] args) {
        // Sub是需要你定义的子类
        Base base = new Sub();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            base.setX(x);
            base.setY(y);
            System.out.println(base.calculate());
        }
    }
}

