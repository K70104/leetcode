import java.util.*;

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int start;
    public int end;
    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    // 4、二分搜索树
    TreeNode root;

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new TreeNode(start, end);
            return true;
        }
        TreeNode cur = root;
        while (true) { //
            if (end <= cur.start) { // 左子树
                if (cur.left == null) {
                    cur.left = new TreeNode(start, end);
                    return true;
                }
                cur = cur.left;
            } else if (start >= cur.end) { // 右子树
                if (cur.right == null) {
                    cur.right = new TreeNode(start, end);
                    return true;
                }
                cur = cur.right;
            } else {
                return false;
            }
        }
    }
}

class MyCalendar3 {
    // 3、TreeMap
    TreeMap<Integer, Integer> map = null;

    public MyCalendar3() {
        map = new TreeMap<>();
//        map.put(-1, -1);
//        map.put((int)1e9+1, (int)1e9+1);
    }

    public boolean book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, end);
            return true;
        }
//        Integer right = map.ceilingKey(start); //
//        Integer left = map.floorKey(start);
//        if (start < map.get(left) || right < end) {
//            return false;
//        }
        Map.Entry<Integer, Integer> right = map.ceilingEntry(start);
        Map.Entry<Integer, Integer> left = map.floorEntry(start);
        if (right != null && right.getKey() < end || left != null && left.getValue() > start) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

class MyCalendar2 {
    // 2、二分查找
    // TreeSet 可排序，找两个区间之间是否可插入
    // 对于给定的区间[start, end)，我们每次查找起点大于等于end的第一个区间[1,71)，
    // 同时紧挨着[1,r1)的前一个区间为[2, r2)，此时如果满足r2 ≤start < end≤h1，则该区间可以预订。
    // https://www.jb51.net/article/113733.htm
    TreeSet<int[]> set = null;

    public MyCalendar2() {
        set = new TreeSet<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    public boolean book(int start, int end) {
        if (set.isEmpty()) {
            set.add(new int[]{start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] ceiling = set.ceiling(tmp); // 返回大于等于e的最小元素
        if (ceiling == set.first() || set.lower(tmp)[1] <= start) {
            set.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}

class MyCalendar1 {
    // 1、遍历检查
    // 对于两个区间 [s1, e1) 和 [s2, e2)，
    // 如果二者没有交集，则此时应当满足 s1 > e2 或者 s2 > e1，
    // 这就意味着如果满足 s1 < e2 并且 s2 < e1，则两者会产生交集
    List<int[]> list = null;

    public MyCalendar1() {
        list = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] time : list) {
            // 没有交集：start > time[1] || end < time[0]
            if (start < time[1] && end > time[0]) { // 区间重复 不能添加日程
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        System.out.println(123);
    }
}
