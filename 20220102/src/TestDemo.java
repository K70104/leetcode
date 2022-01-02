import java.util.HashMap;

public class TestDemo {
    // 滑动窗口
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        int len = nums.length;
        int left1 = 0, left2 = 0, right = 0, sum1 = 0, sum2 = 0;
        while(right < len) {
            sum1 += nums[right];
            while(left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while(left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            cnt += left2 - left1;
            right++;
        }
        return cnt;
    }

    // 滑动窗口  本题只有0/1
    public int numSubarraysWithSum4(int[] nums, int goal) {
        int cnt = 0;
        int len = nums.length;
        for(int left = 0; left < len; left++) {
            if(nums[left] > goal) {
                continue;
            }
            int sum = nums[left];
            if(sum == goal) { // 单个数
                cnt++;
            }
            int right = left + 1;
            while(right < len && sum <= goal) {
                sum += nums[right];
                if(sum == goal) {
                    cnt++;
                    if(right + 1 < len && nums[right + 1] != 0) {
                        break; // 下一个为1 大于goal 提前结束本次循环
                    }
                }
                right++; //
            }
        }
        return cnt;
    }

    // 数组
    public int numSubarraysWithSum3(int[] nums, int goal) {
        int cnt = 0;
        int sum = 0;
        int[] array = new int[nums.length + 1];
        for(int i : nums) {
            array[sum]++;
            sum += i;
            if(sum - goal >= 0) {
                cnt += array[sum - goal];
            }
        }
        return cnt;
    }

    // 哈希表 前缀和
    public int numSubarraysWithSum5(int[] nums, int goal) {
        int cnt = 0;
        int prevsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        /*map.put(0, 1); // 前缀和为0
        for(int num : nums) {
            prevsum += num; // [0,0,0,0,0] 0 -->15
            cnt += map.getOrDefault(prevsum - goal, 0);
            map.put(prevsum, map.getOrDefault(prevsum, 0) + 1);
        }*/
        for(int num : nums) {
            map.put(prevsum, map.getOrDefault(prevsum, 0) + 1);
            prevsum += num;
            cnt += map.getOrDefault(prevsum - goal, 0);
        }
        return cnt;
    }

    // 双循环
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = nums[i];
            if(sum == goal) {
                cnt++;
            }
            for(int j = i + 1; j < n; j++) {
                sum += nums[j];
                if(sum == goal) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0, 1};
        numSubarraysWithSum(array, 2);
    }

    // https://leetcode.com/problems/elimination-game/discuss/87119/JAVA%3A-Easiest-solution-O(logN)-with-explanation
    public int lastRemaining(int n) {
        int head = 1; // n为1时 head就是最后一个数
        int step = 1;
        boolean left = true;
        while(n > 1) {
            // 从左移除（奇数->从右移除）
            if(left || n % 2 == 1) {
                head += step;
            }
            step *= 2; // 步长
            left = !left; // 反向
            n /= 2; // 减少一半
        }
        return head;
    }

    public static int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        //细节，这里需要预存前缀和为 0 的情况，会漏掉前几位就满足的情况
        //例如输入[1,1,0]，k = 2 如果没有这行代码，则会返回0,漏掉了1+1=2，和1+1+0=2的情况
        //输入：[3,1,1,0] k = 2时则不会漏掉
        //因为presum[3] - presum[0]表示前面 3 位的和，所以需要map.put(0,1),垫下底
        map.put(0, 1);
        int count = 0;
        int presum = 0;
        for (int x : nums) {
            presum += x;
            if (map.containsKey(presum - k)) {
                count += map.get(presum - k);//获取次数
            }
            map.put(presum,map.getOrDefault(presum,0) + 1);
        }
        return count;
    }

    public static void main3(String[] args) {
        int[] array = {1, 1, 0, 3};
        System.out.println(subarraySum(array, 2));
    }

    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = nums[i];
            for(int j = i + 1; j < n; j++) {
                if(sum == goal) {
                    cnt++;
                }
                sum += nums[j];
            }
        }
        return cnt;
    }

    public static void main2(String[] args) {
        int[] array = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(array, 2));
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
