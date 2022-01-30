import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo {
    // 每一场比赛中，输的队伍无法晋级，且不会再参加后续的比赛。
    // 由于最后只决出一个获胜队伍，因此就有 n-1 个无法晋级的队伍，也就是会有 n−1 场比赛。
    public int numberOfMatches(int n) {
        return n - 1;
    }

    public int numberOfMatches1(int n) {
        int ans = 0;
        while(n > 1) {
            ans += n / 2;
            if(n % 2 != 0) {
                n = n / 2 + 1;
            }else {
                n = n / 2;
            }
        }
        return ans;
    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
         HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            map.put(words1[i], map.getOrDefault(words1[i], 0) + 1);
        }
        for (int i = 0; i < words2.length; i++) {
            map.put(words2[i], map.getOrDefault(words2[i], 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> ret : map.entrySet ()) {
            if(ret.getValue() == 1) {
                list.add(ret.getKey());
            }
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
