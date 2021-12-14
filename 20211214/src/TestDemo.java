import java.util.*;

public class TestDemo {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0) {
                return digits;
            }
        }
        // 全是9
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {

    }
}
