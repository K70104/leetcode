import java.util.*;

public class TestDemo {
    // word 的每个字母需要映射到 pattern 的对应字母，并且 pattern 的每个字母也需要映射到 word 的对应字母
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word.length() == pattern.length() && match(word, pattern) && match(pattern, word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            char y = pattern.charAt(i);
            if (!map.containsKey(x)) { // 没有 x，放入 x 和对应的 y
                map.put(x, y);
            } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
