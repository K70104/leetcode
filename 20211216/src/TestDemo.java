import java.util.Arrays;

public class TestDemo {
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }
        if(num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    // 循环
    public int addDigits2(int num) {
        while(num >= 10) {
            int sum = 0;
            while(num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    // 递归
    public int addDigits1(int num) {
        if(num < 10) {
            return num;
        }
        int sum = 0;
        while(num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    public boolean canWinNim(int n) {
        if(n % 4 == 0) {
            return false;
        }
        return true;
    }

    public static long reverseBits(long n) {
        long num = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // 如果最低位是1 就可以颠倒或给num
            num |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(1220225471));
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

    public int hammingWeight1(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) { // 用1<<i 判断每一位
                cnt++;
            }
        }
        return cnt;
    }

    // 判断是否为最大 22 的幂的约数
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (1 << 30) % n == 0;
    }

    // 一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1
    // 将 n 的二进制表示中最低位的那个 1 提取出来，再判断剩余的数值是否为 0
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    public boolean isUgly(int n) {
        if(n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while(n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public static void main1(String[] args) {
        for (int i = 31; i >=0; --i) {
            System.out.print(i+" ");
        }
    }
}
