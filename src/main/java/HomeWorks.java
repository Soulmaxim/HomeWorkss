/**
 * Created by Soul on 29.03.2021.
 */
public class HomeWorks {
    static boolean inRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }
    static void printIfPositive(int num) {
        System.out.print(num + " is ");
        if (num >= 0) System.out.println("positive");
        else System.out.println("negative");
    }
    static boolean isPositive(int num) {
        return num < 0;
    }
    static void printNumTimes(String str, int num) {
        if (num <= 0)
        {
            System.out.println("Incorrect amount");
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }
    static boolean isLeap(int year) {
        if (year <= 0)
        {
            System.out.println("Incorrect year");
            return false;
        }
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        System.out.println(inRange(12, 6));
        System.out.println(inRange(12, 13));
        System.out.println();

        printIfPositive(5);
        printIfPositive(-5);
        System.out.println();

        System.out.println(isPositive(5));
        System.out.println(isPositive(-5));
        System.out.println();

        printNumTimes("some text", 3);
        printNumTimes("some text", -3);
        System.out.println();

        System.out.println(isLeap(2020));
        System.out.println(isLeap(2000));
        System.out.println(isLeap(2100));
        System.out.println(isLeap(-1));
    }
}