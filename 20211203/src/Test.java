import java.util.*;

class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message);
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();
        int num5 = scanner.nextInt();
        scanner.close();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        list.add(num5);
        System.out.print("普通for循环:");

        //write your code here......
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

        System.out.println();
        System.out.print("增强for循环:");

        //write your code here......
        for (int x : list) {
            System.out.print(x+" ");
        }

        System.out.println();
        System.out.print("迭代器遍历:");

        //write your code here......
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }

        System.out.println();
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        HashSet<Character> hs = new HashSet<>();

        //write your code here......
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if(!hs.contains(str)) {
                hs.add(str.charAt(i));
            }
        }

        for (char c:hs) {
            System.out.print(c);
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();

        //write your code here......
        try {
            if(score > 0 && score <=  100) {
                System.out.println(score);
            }else {
                throw new ScoreException("分数不合法");
            }
        }catch (ScoreException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
