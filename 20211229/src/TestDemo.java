import java.util.HashMap;

public class TestDemo {
    // 3、d-c
    // nums[a]+nums[b]=nums[d]−nums[c]
    public int countQuadruplets(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int b = n - 3; b >= 1; --b) {
            // nums[d]−nums[c] 出现的次数
            for (int d = b + 2; d < n; d++) {
                map.put(nums[d] - nums[b + 1], map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                cnt += map.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return cnt;
    }

    // 2、哈希表
    public int countQuadruplets2(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = n - 2; i >= 2; --i) {
            map.put(nums[i + 1], map.getOrDefault(nums[i + 1],0) + 1);
            for (int a = 0; a < i; a++) {
                for (int b = a + 1; b < i; b++) {
                    cnt += map.getOrDefault(nums[a] + nums[b] + nums[i], 0);
                }
            }
        }
        return cnt;
    }

        //  1、暴力
    public int countQuadruplets1(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if(nums[i] + nums[j] + nums[k] == nums[l]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static int fun(int n) {
        if(n == 1) {
            return n;
        }
        return fun(n-1)*n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fun(n));
    }
}
