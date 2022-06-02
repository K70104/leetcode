import java.util.*;

class Rational {
    private long numerator; // 分子
    private long denominator; // 分母
    private long integer; // 带分数的整数部分
    private boolean negative; // 负数
    private boolean isZero; // 分母为 0
    private long totalNumerator; // 参与运算的分子：带分数的整数部分 + 原来分子

    // 截取 分子部分
    protected static long parseNumerator(String s) {
        return Long.parseLong(s.substring(0, s.indexOf('/')));
    }

    // 截取 分母部分
    protected static long parseDenominator(String s) {
        return Long.parseLong(s.substring(s.indexOf('/') + 1, s.length()));
    }

    // 判断化简 分子 分母
    protected Rational(long n, long d) {
        // 在输入的时候分母永远不可能为0，但是经过计算之后分母可能会为0
        if (0 == d) {
            isZero = true;
            return;
        }
        // If there is a negative sign, it must appear only in front of the numerator.
        if (n < 0) {
            negative = true;
        }
        // 在输入的时候，分母永远不可能小于0，但是经过计算之后分母也可能会小于0
        if (d < 0) {
            negative = !negative;
        }
        // 如果输入是假分数，需要将其调整为真分数 --> 5 / 3 --> 1 2/3
        integer =  n / d;
        numerator = n - integer * d;
        denominator = Math.abs(d);
        // 如果分数不是最简的形式，需要将其约分为最简的形式，比如：10 / 15
        // 在分子和分母的基础之上分别处以分子和分母的最大公约数
        if (numerator > 1 || numerator < -1) {
            long gcd = calcGCD(Math.abs(numerator), denominator); // 用整数
            if (gcd > 0) { // 有最大公约数
                numerator /= gcd;
                denominator /= gcd;
            }
        }
        // 用于计算的分子 如果是假分数，化成真分数计算
        totalNumerator = numerator + integer * denominator;
    }

    // 最大公约数 辗转相除法
    private long calcGCD(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }
        return calcGCD(n2, n1 % n2);
    }

    // 计算
    protected Rational Add(Rational r) { // 通分
        long n = totalNumerator * r.denominator + r.totalNumerator * denominator; // 分子
        long d = denominator * r.denominator; // 分母
        return new Rational(n, d); // 结果同样是最简加假分式
    }

    protected Rational Sub(Rational r) { // 通分
        long n = totalNumerator * r.denominator - r.totalNumerator * denominator;
        long d = denominator * r.denominator;
        return new Rational(n, d);
    }

    protected Rational Mul(Rational r) {
        long n = totalNumerator * r.totalNumerator;
        long d = denominator * r.denominator;
        return new Rational(n, d);
    }

    protected Rational Div(Rational r) {
        long n = totalNumerator * r.denominator;
        long d = denominator * r.totalNumerator;
        return new Rational(n, d);
    }

    // 判断输出形式
    public String toString() {
        if (isZero) { // 分母为 0 输出 Inf
            return "Inf";
        }
        if (integer == 0 && numerator == 0) { // 结果为 0
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (negative) { // 负数
            stringBuilder.append("(-");
        }
        // 输出 Rational：整数部分 + 分数部分
        // 整数部分
        if (0 != integer) {
            stringBuilder.append(Math.abs(integer));
            if (0 != numerator) { // 有分数 和整数之间有空格
                stringBuilder.append(" ");
            }
        }
        // 分数部分 可能没有
        if (0 != numerator) {
            stringBuilder.append(Math.abs(numerator) + "/" + denominator);
        }
        if (negative) {
            stringBuilder.append(")");
        }
        return new String(stringBuilder);
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 读取两个分数 分别截取出各自的 分子 和 分母
            String s = scanner.next(); //
            Rational r1 = new Rational(Rational.parseNumerator(s), Rational.parseDenominator(s));
            s = scanner.next(); //
            Rational r2 = new Rational(Rational.parseNumerator(s), Rational.parseDenominator(s));
            // 输出 两个分数 运算符 计算的结果
            // ——> 5/3   3/2
            // 1 2/3 + 1 1/2 = 3 1/6
            System.out.println(r1 + " + " + r2 + " = " + r1.Add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.Sub(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.Mul(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.Div(r2));
        }
    }
}