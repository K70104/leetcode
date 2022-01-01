import java.awt.*;

public class TestDemo {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int cnt = 0;
        int s = x ^ y;
        while(s != 0) {
            s &= s - 1; // 取出最低位的 1
            cnt++;
        }
        return cnt;
    }

    public int hammingDistance2(int x, int y) {
        int cnt = 0;
        int s = x ^ y; // 统计不同位个数
        while(s != 0) {
            cnt += s & 1;
            s >>= 1;
        }
        return cnt;
    }

    public int hammingDistance1(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            cnt += (x & 1) ^ (y & 1); // x y 最低位判断相等
            x >>>= 1;
            y >>>= 1;
        }
        return cnt;
    }

    // 分组 4个8组
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 7; i >= 0; --i) {
            int ret = (num >> (4 * i)) & 15; // 正向转
            if(sb.length() > 0 || ret > 0) { // 零和正整数，可能出现前导零
                char c = ret < 10 ? (char)(ret + '0') : (char)(ret - 10 + 'a');
                sb.append(c);
            }
        }
        return sb.toString();
        /*while(num != 0) {
            int ret = num & 15; // 每4位
            char c = (char)(ret + '0');
            if(ret >= 10) {
                c = (char)(ret - 10 + 'a');
            }
            sb.append(c);
            num >>>= 4; // 无符号右移
        }
        return sb.reverse().toString();*/
    }

    // 位运算 %16 /16
    public String toHex1(int num2) {
        if(num2 == 0) {
            return "0";
        }
        long num = num2;
        if(num < 0) {
            num = (long)(Math.pow(2, 32) + num); // 负数 加2^32偏移量
        }
        StringBuilder sb = new StringBuilder();

        while(num != 0) {
            long ret = num % 16;
            char c  = (char)(ret + '0');
            if(ret >= 10) {
                c = (char)(ret - 10 + 'a'); // abcdef
            }
            sb.append(c);
            num /=  16;
        }
        /*String letter = "abcdef";
        while(num != 0) {
            int ret = (int)(num % 16);
            if(ret >= 10) {
                sb.append(letter.charAt(ret-10));
            } else {
                sb.append(ret);
            }
            num /= 16;
        }*/
        return sb.reverse().toString();
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n) {
            return new int[0][];
        }
        int[][] ans = new int[m][n];
        for(int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }

        /*for(int i = 0; i < original.length; i++) {
            ans[i / n][i % n] = original[i];
        }*/

        /*int k = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = original[k++];
            }
        }*/
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
