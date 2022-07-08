

public class TestDemo {
    // ASCII码的字符个数为128个，用两个64位，8字节的long变量，
    // 二进制位 1 表示出现过，0 表示没有出现过
    public boolean isUnique(String astr) {
        long low = 0;
        long high = 0;
        for (char c : astr.toCharArray()) {
            if (c > 64) {
                long index = 1L << (c - 64);
                if ((high & index) != 0) { // 出现过
                    return false;
                }
                high |= index; // 标记为出现
            } else {
                long index = 1L << c;
                if ((low & index) != 0) {
                    return false;
                }
                low |= index;
            }
        }
        return true;
    }

    // 移动两步不需要代价 奇到奇 偶到偶 统计较小的移动
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int n : position) {
            if ((n & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
