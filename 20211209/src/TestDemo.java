import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Customer implements Comparable<Customer>{
    private String name;
    private int consumption;

    public Customer(String name, int consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", consumption=" + consumption +
                '}';
    }

    //write your code here......
    @Override
    public int compareTo(Customer o) {
        return o.consumption - this.consumption;
    }

}


class Shape {

    private double s; // 周长

    public Shape(double s) {
        this.s = s;
    }

    public double getS() {
        return s;
    }

}

interface Area {
    double getArea(); // 面积
}

// 圆形
class Circle extends Shape implements Area {

    //write your code here......
    public Circle(double s) {
        super(s);
    }

    public double getArea() {
        return Math.PI * Math.pow(super.getS()/2/Math.PI, 2);
    }
}

// 方形
class Square extends Shape implements Area {

    //write your code here......
    public Square(double s) {
        super(s);
    }

    public double getArea() {
        return Math.pow(super.getS()/4, 2);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        //write your code here......
        for (int i = 0; i < arr.length - 1; i++) {
            int flg = 1;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flg = 0;
                }
            }
            if(flg == 1) {
                break;
            }
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
        }
    }

    public static void method(int start, int end) {
        int count=0;

        //write your code here......
        if(start > end) {
            start ^= end;
            end ^= start;
            start ^= end;
        }
        for(int i =start; i <= end; i++) {
            int flg = 1;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    flg = 0;
                    break;
                }
            }
            if(flg == 1) {
                count++;
            }
        }

        System.out.println(start+"到"+end+"之间有"+count+"个大于2的素数");
    }

    public static void main5(String[] args) {
        Scanner console = new Scanner(System.in);
        TestDemo main = new TestDemo();
        int number = console.nextInt();
        System.out.println(main.palindromeNumber(number));
    }

    // StringBuilder逆置
    public Boolean palindromeNumber(int number) {
        //write your code here......
        StringBuffer sb = new StringBuffer(number+"").reverse();
        if(sb.toString().equals(number+"")) {
            return true;
        }
        return false;
    }

    // 1、循环
    public Boolean palindromeNumber1(int number) {
        //write your code here......
        // 循环
        int tmp = 0;
        int numberCopy = number;
        while(number != 0) {
            tmp = tmp*10 + number%10;
            number/=10;
        }
        if(tmp == numberCopy) {
            return true;
        }
        return false;
    }

    public static void main3(String[] args) {
        int numbers = 0;
        int words = 0;
        int space = 0;
        int other = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //write your code here......
        for (int i = 0; i < str.length(); i++) {
            // 用char包装类中的判断字母的方法判断每一个字符
            if(Character.isDigit(str.charAt(i))) { // 判断数字
                numbers++;
            }else if(Character.isLetter(str.charAt(i))) { // 判断字母
                words++;
            }else if(Character.isWhitespace(str.charAt(i))) {
                space++;
            }else {
                other++;
            }
        }

        System.out.println("英文字母"+words+"数字"+numbers+"空格"+space+"其他"+other);
    }

    public static void main2(String[] args) {
        int numbers = 0;
        int words = 0;
        int space = 0;
        int other = 0;
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //write your code here......
        ArrayList<String> list = new ArrayList<>();
        list.add(list.toString());
        space = Collections.frequency(list, " ");

        System.out.println("英文字母"+words+"数字"+numbers+"空格"+space+"其他"+other);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer1 = new Customer("小明",scanner.nextInt());
        Customer customer2 = new Customer("小军",scanner.nextInt());
        Customer customer3 = new Customer("小红",scanner.nextInt());
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        //write your code here......
        Collections.sort(customers);

        System.out.println(customers);
    }
}
