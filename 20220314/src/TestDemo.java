import java.util.*;

public class TestDemo {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                if(i + j < minIndexSum) {
                    list.clear();
                    list.add(list2[i]);
                    minIndexSum = i + j;
                } else if (i + j == minIndexSum) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] list1 = {"KFC","Shogun",  "Tapioca Express", "Burger King"};
        String[] list2 = {"Shogun", "KFC","The Grill at Torrey Pines", "Hungry Hunter Steakhouse"};
        String[] tmp = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(tmp));
    }

    public static void main1(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bit");

        String[] tmpString = list.toArray(new String[0]);

        Integer[] tmpInt = list.toArray(new Integer[0]);

        List<Integer> list2 = new ArrayList<>();

        int[] array = {1,2,3};
        int a = Integer.valueOf("123");
        System.out.println(a);
        String str = "123456";
        char[] tmp = str.toCharArray();
        System.out.println("tmp : " + Arrays.toString(tmp));

        System.out.println(123);
    }
}
