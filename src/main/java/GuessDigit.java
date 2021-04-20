import java.util.Scanner;

public class GuessDigit {

    static int getRandomDigit() {
        return (int) (Math.random() * 10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int guess = getRandomDigit();
        System.out.println("0..9");
        System.out.println("У тебя 3 попытки");
        int tryCount = 3;
        for (int i = 0; i < tryCount; i++) {
            System.out.println("Попытка " + (i + 1) + ": ");
            int current = in.nextInt();
            if (current < guess) {
                System.out.println("Больше");
            }
            else if (current > guess) {
                System.out.println("Меньше");
            }
            else {
                System.out.println("Да");
                break;
            }
        }
    }
}
