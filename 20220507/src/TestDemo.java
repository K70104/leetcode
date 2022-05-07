import java.util.*;

public class TestDemo {
    public static void main(String[] args) {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        int count = new TestDemo().minMutation(start, end, bank);
        System.out.println(count);
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> gene = new HashSet<String>(); // 检测是否在基因库 bank 中
        Set<String> visited = new HashSet<String>(); // 判断是否遍历过
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String b : bank) { // 基因库加入 gene
            gene.add(b);
        }
        if (start.equals(end)) { // start 和 end 相等，直接返回 0
            return 0;
        }
        if (!gene.contains(end)) { // end 不在 bank 中，无法实现目标变化，返回 -1
            return -1;
        }
        Queue<String> queue = new LinkedList<>(); // 可能变换的基因序列
        queue.offer(start);
        visited.add(start);
        int count = 1; // 返回的次数
        while (!queue.isEmpty()) {
            int sz = queue.size(); // 每次拿出队列所有
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // 变化一次最多可能会生成 3×8=24 种不同的基因序列
                for (int j = 0; j < 8; j++) { // 遍历每个序列的字符
                    for (int k = 0; k < 4; k++) { // 尝试 A C G T
                        if (cur.charAt(j) != keys[k]) {
                            StringBuilder stringBuilder = new StringBuilder(cur);
                            stringBuilder.setCharAt(j, keys[k]); // j 的位置改成 keys[k]
                            String next = stringBuilder.toString();
                            if (!visited.contains(next) && gene.contains(next)) { // 合法且未遍历过
                                if (next.equals(end)) { // 此次变化变成了 end，返回次数
                                    return count;
                                }
                                queue.offer(next); // 合法且未遍历过 加入队列
                                visited.add(next); // 标记已被遍历过
                            }
                        }
                    }
                }
            }
            count++; // 一次基因变化
        }
        return -1; // 队列中所有的元素都已经遍历完成还无法变成 end，则此时无法实现目标变化，返回 -1
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
