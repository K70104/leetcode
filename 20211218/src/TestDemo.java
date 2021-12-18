import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TestDemo {
    // 哈希  数字的个数
    public int[] intersect(int[] nums1, int[] nums2) {
        // 较短数组放到哈希表 较长数组遍历取交集
        if(nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) { // 放nums1 数和个数
            int cnt = map.getOrDefault(n, 0) + 1;
            map.put(n, cnt);
        }
        int[] array = new int[nums1.length];
        int index = 0;
        for (int n : nums2) {
            int cnt = map.getOrDefault(n, 0);
            if(cnt > 0) { // 有重复
                array[index++] = n;
                cnt--; // 减少一次
                if(cnt > 0) {
                    map.put(n, cnt); // 修改key
                }else {
                    map.remove(n); // 次数为0 没有n的交集了
                }
            }
        }
        return Arrays.copyOfRange(array, 0, index);
    }

    // 指针
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0; // 要返回的数组的范围
        int index1 = 0; // nums1
        int index2 = 0; // nums2
        int[] array = new int[nums1.length];
        while(index1 < nums1.length && index2 < nums2.length) {
            int x = nums1[index1];
            int y = nums2[index2];
            if(x == y) {
                array[index++] = x;
                index1++;
                index2++;
            } else if (x < y) { // x != y 指向较小数的指针右移
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(array, 0, index);
    }

    // 排序 双指针
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0; // 要返回的数组的范围
        int index1 = 0; // nums1
        int index2 = 0; // nums2
        int[] array = new int[nums1.length];
        while(index1 < nums1.length && index2 < nums2.length) { // 一个遍历完 停止
            int x = nums1[index1];
            int y = nums2[index2];
            if(x == y) {
                if(index == 0 || x != array[index - 1]) { // 保证唯一性
                    array[index++] = x;
                }
                index1++;
                index2++;
            } else if (x < y) { // x != y 指向较小数的指针右移
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(array, 0, index);
    }
    // 哈希
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length];
        HashSet<Integer> set = new HashSet<>(); // 放nums1
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int k = 0; // 记录要返回的范围
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) { // 有重复 放到array 删除
                array[k++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(array, 0, k);
    }

    // 如果是'X' 就设为',' 判断行列
    public int countBattleships(char[][] board) {
        int cnt = 0;
        int row = board.length; // 行
        int col = board[0].length; // 列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'X') {
                    board[i][j] = ',';
                    for (int k = i+1; k < row && board[i][j] == 'X'; k++) {
                        board[k][j] = ',';
                    }
                    for (int k = j+1; k < col && board[i][j] == 'X'; k++) {
                        board[i][k] = ',';
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 345.反转字符串中的元音字母  https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
    /*public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        String str = "aeiouAEIOU";
        char[] newS = s.toCharArray();
        while(l < r) {
            if(str.contains(s.charAt(l)+"") && str.contains(s.charAt(r)+"")) {
                char ch = newS[l];
                newS[l] = newS[r];
                newS[r] = ch;
                ++l;
                --r;
            }
            if(!str.contains(s.charAt(l)+"")) {
                ++l;
            }
            if(!str.contains(s.charAt(r)+"")) {
                --r;
            }
        }
        return new String(newS);
    }*/


    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        String str = "aeiouAEIOU";
        char[] newS = s.toCharArray();
        while(l < r) {
            if(str.contains(s.charAt(l)+"")) {
                if(str.contains(s.charAt(r)+"")) {
                    char ch = newS[l];
                    newS[l] = newS[r];
                    newS[r] = ch;
                    ++l;
                    --r;
                }else {
                    r--;
                }
            }else {
                l++;
            }
        }
        return new String(newS);
    }

    public static void main(String[] args) {

    }
}
