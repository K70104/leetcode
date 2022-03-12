import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class TestDemo {

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        Node node1 = new Node(0, list);

        postorder(node1);
        System.out.println(123);
    }

    public static void post(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }
        for(Node node : root.children) {
            post(node, list);
        }
        list.add(root.val);
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        post(root, list);
        return list;
    }

    public static void main1(String[] args) {
        System.out.println(123);
    }
}
