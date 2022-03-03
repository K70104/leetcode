import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestDemo {

    public static void reverseString(char[] array, int left, int right) {
        while(left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        // 1 2 3 4 5 6    7 8 9

        int len = array.length;

        if(n > len) {
            n %= len;
        }
        reverseString(array, 0, len - n - 1);

        reverseString(array, len - n, len - 1);

        reverseString(array, 0, len - 1);


        return new String(array);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        reverseLeftWords(s, 2);
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3};
        String str = "123";
        int a = Integer.parseInt(str);
        int b = Integer.valueOf(str);
        System.out.println(a + " " + b);

        String str2 = String.valueOf(a);
        System.out.println(str2);
    }

    public static void main3(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            String[] strings = str.split(" ");
            for(int i = 0; i < strings.length; i++) {
                set.add(strings[i]);
            }
        }
        System.out.println(set.size());
    }

    public static int fib(int n) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;
        while(f3 < n) {
            f3 = f1 + f2;
            if(f3 > n) {
                break;
            }
            f1 = f2;
            f2 = f3;
        }
        if(n - f2 > f3 - n) {
            return f3 - n;
        } else {
            return n - f2;
        }
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ret = fib(n);
        System.out.println(ret);
    }

    public int minNumberInRotateArray2(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int left= 0;
        int right = array.length - 1;
        int mid = 0;

        while(left < right) {
            if(right - left == 1) { // 相邻
                mid = right;
                break;
            }

            if(array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for(int i = left + 1; i < right; i++) {
                    if(result > array[i]) {
                        result = array[i];
                    }
                }
                return result;
            }

            mid = left + ((right - left) >>> 1);

            if(array[mid] >= array[left]) { // 在后半部分  3 4 5 1 2
                left = mid;
            } else { // array[mid] < array[left]  5 1 2 3 4
                right = mid;
            }
        }
        return array[mid];
    }


    public int minNumberInRotateArray1(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        // 3 4 5 1 2
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
