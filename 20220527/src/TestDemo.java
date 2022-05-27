import java.util.*;

public class TestDemo {
    // 从左到右遍历数组 words，当遍历到 word1 时，如果已经遍历的单词中存在 word2，
    // 为了计算最短距离，应该取最后一个已经遍历到的 word2 所在的下标，计算和当前下标的距离。
    public int findClosest1(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = words.length; // 设为最长距离
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i; // 更新最后一次的位置
                if (index1 != -1 && index2 != -1) {
                    distance = Math.min(distance, Math.abs(index1 - index2));
                    if (distance == 1) {
                        return 1; // 最短距离
                    }
                }
            } else if (word.equals(word2)) {
                index2 = i;
                if (index1 != -1 && index2 != -1) {
                    distance = Math.min(distance, Math.abs(index1 - index2));
                    if (distance == 1) {
                        return 1; // 最短距离
                    }
                }
            }

        }
        return distance;
    }

    // 循环记录：全部记录 最后输出后 8 个
    // 16 个字符：最后一个/ 后的文件名截取后 16 个
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>(); // val 记录次数
        List<String> list = new ArrayList<>(); // list 按顺序保存
        while (scanner.hasNextLine()) { //
            String s = scanner.nextLine();
            String[] strings = s.split("\\\\");
            String path = strings[strings.length - 1]; // 最后一个 / 后的 文件名 + 行号
            String[] strings1 = path.split(" "); // 分开 判断文件名长度
            String f = strings1[0]; // 文件名
            if (f.length() > 16) {
                f = f.substring(f.length() - 16, f.length());
                String n = strings1[1]; // 行号
                path = f + " " + n;
            }
            if (!map.containsKey(path)) { // 没有 加入 list
                list.add(path);
            }
            map.put(path, map.getOrDefault(path, 0) + 1); // 更新次数
        }
        // 输出 list 最后 8 个
        int index = 0;
        if (list.size() > 8) {
            index = list.size() - 8;
        }
        for (int i = index; i < list.size(); i++) {
            int val = map.get(list.get(i)); // map 中找 list.get(i) 的个数 val
            System.out.println(list.get(i) + " " + val);
        }
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
