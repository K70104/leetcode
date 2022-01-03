

public class TestDemo {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 当前年份之前的天数
        int days = 0;
        for(int i = 1971; i < year; i++) {
            days += isRun(i) ? 366 : 365; // 闰年
        }
        // 当前月份之前的天数
        for(int i = 0; i < month; i++) {
            days += monthDays[i];
            if(month == 2) { // 当前年
                days += isRun(year) ? 1 : 0;
            }
        }
        // 当前月份的天数
        days += day;
        return weeks[(days + 3) % 7];
    }

    public static boolean isRun(int year) {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    // 1970年12月31日->星期四，算出输入的日期距离1970年12月31日有几天，再加上3后对7求余
    /* 求输入的日期距离 19701970 年 1212 月 3131 日的天数，可以分为三部分分别计算后求和：
    （1）输入年份之前的年份的天数贡献；
    （2）输入年份中，输入月份之前的月份的天数贡献；
    （3）输入月份中的天数贡献。
        例如，如果输入是 21002100 年 1212 月 3131 日，即可分为三部分分别计算后求和：
    （1）19711971 年 11 月 11 到 20992099 年 1212 月 3131 日之间所有的天数；
    （2）21002100 年 11 月 11 日到 21002100 年 1111 月 3131 日之间所有的天数；
    （3）21002100 年 1212 月 11 日到 21002100 年 1212 月 3131 日之间所有的天数。*/
    public String dayOfTheWeek1(int day, int month, int year) {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 当前年份之前的天数
        int days  = 365 * (year - 1971) + (year - 1969) / 4; // 加闰年
        // 当前月份之前的天数
        for(int i = 0; i < month - 1; i++) {
            days += monthDays[i];
        }
        if((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        // 当前月份的天数
        days += day;
        return weeks[(days + 3) % 7];
    }

    public static void main(String[] args) {
        System.out.println(123);
    }
}
