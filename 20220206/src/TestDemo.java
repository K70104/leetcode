import java.util.HashMap;

public class TestDemo {
    // 哈希表记录次数
    public int sumOfUnique1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int ans = 0;
        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                ans += entry.getKey();
            }
        }
        return ans;
    }

    // 一次遍历  没有出现加起来 出现过就减 同时设为2
    public int sumOfUnique2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int n : nums) {
            if(!map.containsKey(n)) {
                ans += n; // 没有此值
                map.put(n, 1); // 同时加入哈希表
            } else if(map.get(n) == 1) {
                ans -= n; // 出现过一次 表示加过了 需要减掉
                map.put(n, 2); // 同时设为2
            }
        }
        return ans;
    }

    // 数组
    public int sumOfUnique(int[] nums) {
        int[] cnts = new int[101];
        int ans = 0;
        for(int n : nums) {
            if(++cnts[n] == 1) {
                ans += n;
            } else if (cnts[n] == 2) {
                ans -= n;
            }
        }
        return ans;
    }

    public static int cntBinaryOfOne(int n) {
        int cnt = 0;
        while(n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(cntBinaryOfOne(-1));
    }
}
