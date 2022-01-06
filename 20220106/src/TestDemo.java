import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    class Solution {
        /*
        递推：
        一行一行地计算，计算到需要的那一行，返回
        第一行只有一个数：1
        首尾：都是1。中间的数：获取上一行的两个数相加
        计算完一行加入C，计算到rowIndex，返回C的rowIndex
         */
        public List<Integer> getRow1(int rowIndex) {
            List<List<Integer>> C  = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                    }
                }
                C.add(row);
            }
            return C.get(rowIndex);
        }

        // 只需要上一行 每次更新即可
        public List<Integer> getRow2(int rowIndex) {
            List<Integer> prev = new ArrayList<>();
            for(int i = 0; i <= rowIndex; i++) {
                List<Integer> cur = new ArrayList<>();
                for(int j = 0; j <= i; j++) {
                    if(j == 0 || j == i) {
                        cur.add(1);
                    } else {
                        cur.add(prev.get(j - 1) + prev.get(j));
                    }
                }
                prev = cur;
            }
            return prev;
        }

        // 从后往前加 每次加给j
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int i = 1; i <= rowIndex; i++) {
                row.add(0);
                for(int j = i; j > 0; j--) {
                    row.set(j, row.get(j - 1) + row.get(j)); // j的位置更新
                }
            }
            return row;
        }
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        getRow(4);
    }

    /*
    一行一行地计算，计算到需要的那一行，返回
    第一行只有一个数：1
    首尾：都是1。中间的数：获取上一行的两个数相加
    计算完一行加入C，计算到rowIndex，返回C的rowIndex
     */
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> C  = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0) { // 进位不为0
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        /*if() { // 进位 不为0 放个位数
            sb.append(carry);
        }*/
        return sb.reverse().toString();
    }

    // 先将 a 和 b 转化成十进制数，求和后再转化为二进制数
    // 如果字符串超过 33 位，不能转化为 Integer
    // 如果字符串超过 65 位，不能转化为 Long
    // 如果字符串超过 500000001 位，不能转化为 BigInteger
    /*public String addBinary1(String a, String b) {
        return Integer.toBinaryString(
             Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }*/

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
