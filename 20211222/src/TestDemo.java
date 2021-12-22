import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestDemo {
    // 加 n 找小于n的
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            int k = (n - 1) / nums.length;
            nums[k] += n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= nums.length) {
                list.add(i+1);
            }
        }
        return list;
    }

    // 用哈希表检查 1-n 中的每一个数是否出现
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i+1)) {
                list.add(i+1);
            }
        }
        return list;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for(int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] sorted = new int[m+n];
        int i = 0;
        while(p1 < m || p2 < n) {
            if(p1 == m) {
                sorted[i++] = nums2[p2++];
            } else if(p2 == n) {
                sorted[i++] = nums1[p1++];
            } else if(nums1[p1] < nums2[p2]) {
                sorted[i++] = nums1[p1++];
            } else {
                sorted[i++] = nums2[p2++];
            }
        }
        i = 0;
        for(int k : sorted) {
            nums1[i++] = k;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3, nums2, 3);
    }

    public int repeatedStringMatch(String a, String b) {
        for(int i = 0; i < b.length(); ++i) {
            if(!a.contains(b.charAt(i)+"")) {
                return -1;
            }
        }
        int cnt = 1;
        while(!a.contains(b)) {
            a += a;
            cnt++;
        }
        return cnt;
    }

    public static void main1(String[] args) {
        System.out.println(111);
    }
}
