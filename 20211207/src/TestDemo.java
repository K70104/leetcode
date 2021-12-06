import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Data {

    private int x;
    private int y;

    protected Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    protected int getY() {
        return y;
    }

}

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Data data = new Data(x, y);
            System.out.println(data.getX() + data.getY());
        }
    }

    public static void main8(String[] args) {
        int[][]  arr = {{11,33,55},{22,44,66,88},{131,214,315,146},{928,827,726,625},{424,525}};
        int sum=add(arr);
        System.out.println(sum);
    }

    public static int add(int[][] arr) {
        int sum=0;

        //write your code here......
        for (int[] array : arr) {
            for (int x : array) {
                sum += x;
            }
        }

        return sum;
    }

    public static void main7(String[] args) {
        int[] arr = new int[6];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length / 2; i++) { // 前一半 与 后一半 交换
            int tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main6(String[] args) {
        int[] arr = new int[6];

        // ArrayList<Integer>
        ArrayList<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            list.add(arr[i]);
        }
        System.out.println(Arrays.toString(arr));

        // Collections逆置
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void maxMain() {
        int[] ary = new int[6];
        int max = 0;
        int min = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < ary.length ; i++) {
            ary[i] = scanner.nextInt();
            if(i == 0) {
                max = ary[i];
                min = ary[i];
            }
            if(max < ary[i]) {
                max = ary[i];
            }
            if(min > ary[i]) {
                min = ary[i];
            }
        }
        //write your code here......

        System.out.println(max+" "+min);
    }

    public static void cntNum(int num) {
        if(num < 0) {
            System.out.println(num);
            return;
        }
        int cnt = 0;
        while(num != 0) {
            num /= 10;
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main4(String[] args) {
        TestDemo main = new TestDemo();
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(main.isPrimeNumber(number));
    }

    public Boolean isPrimeNumber(int number) {

        //write your code here......
        for (int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main3(String[] args) {
        Scanner scan = new Scanner(System.in);

        //write your code here......
        int n = 0;
        int sum = 0;
        int flag = 0;
        while(scan.hasNext()) {
            n = scan.nextInt();
            if(n < 0) {
                break;
            }
            sum += n;
            flag++;
        }
        double avg = sum * 1.0 / flag;
        System.out.println(String.format("%.2f",avg));

        //输出格式为：System.out.println(String.format("%.2f",avg));
    }

    public static void main2(String[] args) {
        Scanner scanner=new Scanner(System.in);
        float h=scanner.nextFloat();
        int n =scanner.nextInt();

        //write your code here......
        int sum = 0;
        while(n != 0) {
            sum += h;
            h /= 2;
            n--;
        }
        System.out.println(String.format("%.3f", h)+" "+String.format("%.3f", sum));
    }


    public static void main1(String[] args) {
        Scanner console = new Scanner(System.in);
        int m = console.nextInt();
        int n = console.nextInt();
        int result = getCM(m, n);
        System.out.println(result);
    }

    public static int getCM(int m, int n){
        //write your code here......
        int m1 = m;
        int n1 = n;
        int k = m % n;
        while(k != 0) {
            m = n;
            n = k;
            k = m % n;
        }
        return n1*m1/n;
    }
}
