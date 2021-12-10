import java.util.Arrays;

public class TestDemo {
    public void merge(int A[], int m, int B[], int n) {
        int[] ret = new int[m+n];
        int i = 0; // 记录A数组下标
        int j = 0; // 记录B数组下标
        int k = 0; // 记录存放ret的下标
        while(i < m && j < n) {
            if(A[i] < B[j]) {
                ret[k++] = A[i++];
            }else {
                ret[k++] = B[j++];
            }
        }
        // A没放完
        while(i < m) {
            ret[k++] = A[i++];
        }
        // B没放完
        while(j < n) {
            ret[k++] = B[j++];
        }
        // 把ret拷贝到A中
        k = 0;
        while(k < ret.length) {
            A[k++] = ret[k++];
        }
    }

    // 1、合并 排序
    public void merge1(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[m++] =  B[i];
        }
        Arrays.sort(A);
    }

    public int jumpFloor(int target) {
        if(target <= 2) {
            return target;
        }else {
            return jumpFloor(target-1) + jumpFloor(target-2);
        }
    }

    public static void main(String[] args) {

    }
}
