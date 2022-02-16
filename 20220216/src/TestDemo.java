import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo {
    // 最多只有一个，满足行最小，列最大
    // 找 所有行最小值 中的 最大值
    // [1,  10, 4,  2],
    // [9,  3,  8,  7],
    // [15, 16, 17, 12]

    public List<Integer> luckyNumbers1 (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m]; // 第 i 行的最小值
        Arrays.fill(minRow, Integer.MAX_VALUE);
        int[] maxCol = new int[n]; // 第 j 列的最大值
        // 遍历   记录行最小值，列最大值
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        // 再次遍历 同时满足即为答案
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }


    // 遍历矩阵,判断 matrix[i][j] 是否是它所在行的最小值和所在列的最大值
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean isMin = true;
                boolean isMax = true;
                // 判断行最小值
                for (int k = 0; k < n; k++) {
                    if(matrix[i][k] < matrix[i][j]) {
                        isMin = false;
                        break;
                    }
                }
                if(!isMin) {
                    continue;
                }
                // 判断列最大值
                for (int k = 0; k < m; k++) {
                    if(matrix[k][j] > matrix[i][j]) {
                        isMax = false;
                        break;
                    }
                }
                if(isMax) {
                    list.add(matrix[i][j]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
