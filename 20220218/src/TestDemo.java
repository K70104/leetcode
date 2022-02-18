import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    // 顶点数目为 N，中心顶点的度为 N-1
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] e : edges) {
            map.put(e[0], map.getOrDefault(e[0], 0) + 1);
            map.put(e[1], map.getOrDefault(e[1], 0) + 1);
        }
        int size = map.size();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == size) {
                return entry.getKey();
            }
        }
        /*for (int key : map.keySet()) {
            if(map.get(key) == size - 1) { // 根据k找v
                return key;
            }
        }*/
        return -1;
    }

    public int findCenter1(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
