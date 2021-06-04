import java.util.ArrayList;
import java.util.Scanner;

public class Zuma {
    static int getRandomDigit() {
        return (int) (Math.random() * 10);
    }

    static void process(ArrayList<Integer> zuma) {
        int count = 1;
        for (int i = 0; i < zuma.size() - 1; i++) {
            if (zuma.get(i).equals(zuma.get(i + 1))) {
                count++;
                if (i == zuma.size() - 2) {
                    if (count >= 3) {
                        int pos = i - count + 2;
                        for (int j = 0; j < count; j++) {
                            zuma.remove(pos);
                        }
                        i = 0;
                    }
                    count = 0;
                }
            }
            else {
                if (count >= 3) {
                    int pos = i - count + 1;
                    for (int j = 0; j < count; j++) {
                        zuma.remove(pos);
                    }
                    i = 0;
                }
                count = 1;
            }
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> zuma = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            zuma.add(i);
        }
        while (true) {
            System.out.println(zuma);
            int current = getRandomDigit();
            System.out.println("You have " + current);
            System.out.println("Input shot index");
            int index = in.nextInt();
            zuma.add(index, current);
            System.out.println(zuma);
            process(zuma);
            if (zuma.size() == 0) {
                System.out.println("You win");
                break;
            }
        }
    }
}
