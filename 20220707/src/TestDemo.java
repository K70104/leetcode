import java.util.*;

class Trie {
    Map<Character, Trie> children = new HashMap<>();
}

public class TestDemo {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // putIfAbsent() 方法会先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中。
                // 如果所指定的 key 已经在 HashMap 中存在，返回和这个 key 值对应的 value, 如果所指定的 key 不在 HashMap 中存在，则返回 null。
                // 注意：如果指定 key 之前已经和一个 null 值相关联了 ，则该方法也返回 null。
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String findRoot(String word, Trie trie) {
        StringBuffer root = new StringBuffer();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }

    // 1、每个单词，由短至长遍历它所有的前缀，在 set 中找能否替换
    public static String replaceWords1(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(); // 前缀字典
        for (String s : dictionary) {
            set.add(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flg = true; // 默认没有前缀
            for (int j = 1; j < word.length(); j++) {
                if (set.contains(word.substring(0, j))) { // 有前缀
                    ans.append(word.substring(0, j) + " ");
                    flg = false;
                    break;
                }
            }
            if (flg) { // 没有前缀 就是原来的词
                ans.append(word + " ");
            }
        }
        return ans.substring(0, ans.length() - 1).toString(); // 最后一个没有空格 0 - len-1
    }

    public static void main(String[] args) {
        String[] ss = new String[]{"cat", "bat", "rat"};
        List<String> dictionary = new ArrayList<>();
        Collections.addAll(dictionary, ss);
        String sentence = "the cattle was rattled by the battery";
        String ans = replaceWords1(dictionary, sentence);
        System.out.println(ans);
        System.out.println(123);
    }
}
