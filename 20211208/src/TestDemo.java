import java.sql.SQLOutput;
import java.util.Scanner;

class Base1 {

    private int x;
    private int y;

    public Base1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void calculate() {
        System.out.println(getX() * getY());
    }

}

class Sub1 extends Base1 {

    //write your code here......
    protected Sub1(int x, int y) {
        super(x, y);
    }

    public void calculate() {
        if(getY() == 0) {
            System.out.println("Error");
        } else {
            System.out.println(getX() / getY());
        }
    }
}

class First {
    public String toString() {
        return "First";
    }
}

class Second {
    public String toString() {
        return "Second";
    }
}

class Third {
    public String toString() {
        return "Third";
    }
}

public class TestDemo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String className = scanner.next();
            // print就是需要你定义的方法
            print(Class.forName(className).newInstance());
        }
    }

    //write your code here......
    public static void print(Object obj) {
        System.out.println(obj.getClass().getName());
    }


    public static void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, 0, nums.length-1);
    }

    // 超出时间限制
    public static void rotate1(int[] nums, int k) {
        while(k != 0) {
            int tmp = nums[nums.length-1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i+1] = nums[i];
            }
            nums[0] = tmp;
            k--;
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[7];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        rotate(nums, 3);
        for (int x : nums) {
            System.out.print(x+" ");
        }
    }

    public int missingNumber(int[] nums) {
        int x = 0;
        for(int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        for(int i = 0; i < nums.length + 1; i++) {
            x ^= i;
        }
        return x;
    }

    public int missingNumber1(int[] nums) {
        int sum1 = 0;
        for(int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        int sum2 = 0;
        for(int i = 0; i < nums.length + 1; i++) {
            sum2 += i;
        }
        return sum2 -sum1;
    }
}
