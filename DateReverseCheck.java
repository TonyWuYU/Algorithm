package com.xinanjingsai;

import java.util.Scanner;

/**
 * Created by yuwu on 2017/5/24.
 */
public class DateReverseCheck {
    private static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 29};
    private static String start;
    private static String end;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start = scanner.nextLine();
        end = scanner.nextLine();
        int startYear = Integer.parseInt(start.substring(0, 4));
        int endYear = Integer.parseInt(end.substring(0, 4));
        int ans = 0;
        for (int y = startYear; y <= endYear; y++) {
            String date = getString(y);
            if (checkDate(date)) {
                ans++;
            }
        }
        System.out.println(ans);
        scanner.close();
    }

    public static String getString(int year) {
        String s = Integer.toString(year);
        StringBuffer buffer = new StringBuffer(s);
        buffer = buffer.reverse();
        return s + buffer.toString();
    }

    public static boolean checkDate(String s) {
        int year = Integer.parseInt(s.substring(0, 4));
        int month = Integer.parseInt(s.substring(4, 6));
        int day = Integer.parseInt(s.substring(6));
        if (month < 1 || month > 12) {
            return false;
        }
        if (month == 2 && checkYear(year)) {
            month = 13;
        }
        if (day < 1 || day > days[month]) {
            return false;
        }
        if (s.compareTo(start) < 0 || s.compareTo(end) > 0) {
            return false;
        }
        return true;
    }

    public static boolean checkYear(int y) {
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            return true;
        }
        return false;
    }
}

