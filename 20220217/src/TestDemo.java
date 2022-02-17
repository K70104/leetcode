import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

abstract class A {
    abstract void func();
}

class B extends A {

    @Override
    void func() {

    }
}

public class TestDemo {
    public static int lastStoneWeight(int[] stones) {
        // 大根堆
        PriorityQueue<Integer> pr = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int n : stones) {
            pr.offer(n);
        }
        // 拿出两个 不相等y-x入队列
        while(pr.size() > 1) {
            int num1 = pr.poll();
            int num2 = pr.poll();
            if(num1 != num2) {
                pr.offer(num1 - num2);
            }
        }
        return pr.isEmpty() ? 0 : pr.poll();
    }

    public static int lastStoneWeight1(int[] stones) {
        int n = stones.length;
        if(n <= 1) {
            return stones[0];
        }
        while(stones[n - 2] != 0) {
            Arrays.sort(stones);
            if(stones[n - 1] != stones[n - 2]) {
                stones[n - 1] = stones[n - 1] - stones[n - 2];
                stones[n - 2] = 0;
            } else {
                stones[n - 1] = 0;
                stones[n - 2] = 0;
            }
            Arrays.sort(stones); // stones[n - 2] != 0
        }
        return stones[n - 1];
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 每放一个元素 都得保证当前的堆 是大堆 或者是小堆
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);

        System.out.println(priorityQueue.poll()); // 1 ->默认是小堆
        System.out.println(priorityQueue.peek()); // 1 ->默认是小堆
    }

    public static void main1(String[] args) {
        // System.out.println(123);
        // int[] array = {3, 7, 2};
        int[] array =  {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(array));
    }
}
