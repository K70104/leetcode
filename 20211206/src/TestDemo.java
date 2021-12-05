import java.util.Scanner;


public class TestDemo {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        //write your code here......
        while(true) {
            int num = scanner.nextInt();
            if(num >= 1 || num <= 10) {
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }

    public static void main5(String[] args) {
        long num = 0;
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            num = num*10 + 9;
            sum += num;
        }
        System.out.println(sum);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String emailMatcher="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";

        //write your code here......
        if(str.matches(emailMatcher)) {
            System.out.println("邮箱格式合法");
        }else {
            System.out.println("邮箱格式不合法");
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grade =scanner.next();

        //write your code here......
        if(grade.equals("A")) {
            System.out.println("优秀");
        }else if(grade.equals("B")) {
            System.out.println("良好");
        }else if(grade.equals("C")) {
            System.out.println("及格");
        }else if(grade.equals("D")) {
            System.out.println("不及格");
        }else {
            System.out.println("未知等级");
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        double weight = scanner.nextDouble();

        //write your code here......
        double bmi = weight / Math.pow(height, 2);
        if(bmi < 18.5) {
            System.out.println("偏瘦");
        }else if(bmi >= 18.5 && bmi < 20.9) {
            System.out.println("苗条");
        }else if(bmi >= 20.9 && bmi <= 24.9) {
            System.out.println("适中");
        }else {
            System.out.println("偏胖");
        }
    }

    public static void main1(String[] args) {
        Scanner console = new Scanner(System.in);
        int price = console.nextInt();
        int cost = 0;

        //write your code here......
        double discount = 0.0;
        if(price < 100) {
            discount = 1.0;
        }else if(price < 500) {
            discount = 0.9;
        }else if(price < 2000) {
            discount = 0.8;
        }else if(price < 5000) {
            discount = 0.7;
        }else if(price >= 5000) {
            discount = 0.6;
        }

        if(discount != 0.0) {
            cost = (int)(price*discount);
        }else {
            cost = price;
        }

        System.out.println(cost);
    }
}
