import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.*;
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class TestDemo {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        Node node = head;
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            //Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            //node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while(node != null){
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null) {
            Node temp = node.next; // 保留
            node.next = node.next.next; // 遍历每一个 交替还原 原链表 克隆链表
            node = temp; // 还原下一个
        }
        return cloneHead;
    }


    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 第一次遍历 存储老节点与新节点的映射关系
        while(cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        // 第二次遍历 修改新节点的next 和random
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新节点的head
        return map.get(head);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(queue.poll());

        Stack<Integer> stack = new Stack<>();
        // stack.pop();
    }

    public static void main3(String[] args) {
        String filePath = "f:/test.txt";
        String str = "hello";
        System.out.println(countStr(filePath, str));
    }

    private static int countStr(String filePath, String str) {
        // 获取文件内容
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader reader = new FileReader(filePath)) {
            while (true) {
                char[] buffer = new char[1024];
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
                String s = new String(buffer, 0, len);
                stringBuilder.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(stringBuilder);
        // 统计次数
        int count = 0;
        while (stringBuilder.length() >= str.length()) {
            int index = stringBuilder.indexOf(str);
            if (index > -1) { // 有这个字符串
                stringBuilder = stringBuilder.delete(index, index + str.length());
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main2(String[] args) {
        Date date= new Date();
        System.out.println(date.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-mm-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date)); // 2022-18-04 07:18:15
    }

    public static void main1(String[] args) {
        System.out.println(123);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        System.out.println(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("world");
        System.out.println("===========");
        stringBuilder = stringBuilder2;
        System.out.println(stringBuilder);
        System.out.println(stringBuilder2);

        System.out.println("你好!abc".length());
    }
}
