import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();

        //write your code here......
        String[] arr = str1.split(" ");
        if(arr.length != 6) {
            System.out.println("您输入的数据不合理");
        }  else {
            String str = arr[0]+"-"+arr[1]+"-"+arr[2]+" "+arr[3]+":"+arr[4]+":"+arr[5];
            Date date = sdf.parse(str);
            System.out.println("北京时间为：" + sdf.format(date.getTime()));
            System.out.println("纽约时间为：" + sdf.format(date.getTime() - (long)(12*60*60*1000)));
        }
    }

    public static void main6(String[] args) {
        Scanner console = new Scanner(System.in);
        int year = console.nextInt();

        //write your code here......
        Calendar calendar = Calendar.getInstance();
        for (int month = 1; month <= 12; month++) {
            calendar.set(year, month, 0);
            System.out.println(year+"年"+month+"月:"+
                    calendar.get(calendar.DAY_OF_MONTH)+"天");
        }
    }

    public static void main5(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double num = scanner.nextDouble();
        // 绝对值，平方根，对数，正弦值
        //write your code here......
        System.out.println(Math.abs(num));
        System.out.println(Math.sqrt(num));
        System.out.println(Math.log(num));
        System.out.println(Math.sin(num));
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int seed = scanner.nextInt();
            Random random = new Random(seed);

            //write your code here......
            System.out.println(random.nextInt(6)+1);
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //write your code here......
        StringBuffer sb = new StringBuffer();
        sb.append(num % 2);
        while((num/=2) > 0) {
            sb.insert(0, num%2);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //write your code here......
        System.out.println(Integer.toBinaryString(num));
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //write your code here......
        ArrayList<Integer> list = new ArrayList();
        if(num == 0) {
            System.out.println(num);
        }else {
            while (num > 0) {
                list.add(num % 2);
                num /= 2;
            }
            ListIterator<Integer> it = list.listIterator(list.size());
            while (it.hasPrevious()) {
                System.out.print(it.previous());
            }
        }
    }
}
