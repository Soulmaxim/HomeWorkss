import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameX0 {
    private static final char DEFAULT = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_0 = 'O';
    private static int SIZE = 3;
    private static char[][] MAP;

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + DEFAULT);
        }
        System.out.println();
        //System.out.println(" " + DEFAULT +" " + DEFAULT +" " + DEFAULT);
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int x, int y) {
        boolean isInMap = (x > 0) && (x <= SIZE) && (y > 0) && (y <= SIZE);
        return isInMap && (MAP[x - 1][y - 1] == DEFAULT);
    }

    private static void makeStep (int x, int y, char value) {
        MAP[x - 1][y - 1] = value;
    }

    private static void aiAwait() {
        int length = 5;
        System.out.print(" ");
        for (int i = 0; i < 2*length + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
        System.out.print("| ");
        for (int i = 0; i < length; i++) {
            System.out.print("* ");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("|");
    }

    private static void moveAI() {
        aiAwait();
        for (int i = 0; i < SIZE; i++) {            // проверяем можем ли комп выиграть
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) {
                    MAP[i][j] = DOT_0;
                    if (isWin()) return;
                    else MAP[i][j] = DEFAULT;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {            // проверяем можем ли игрок выиграть (если да, то ходим так, как сходил бы игрок)
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) {
                    MAP[i][j] = DOT_X;
                    if (isWin()) {
                        MAP[i][j] = DOT_0;
                        return;
                    }
                    else MAP[i][j] = DEFAULT;
                }
            }
        }

        if (MAP[SIZE/2][SIZE/2] == DEFAULT) {
            MAP[SIZE/2][SIZE/2] = DOT_0;
            return;
        }
        if (MAP[0][0] == DOT_X) {
            if (MAP[0][SIZE-1] == DEFAULT) {
                MAP[0][SIZE-1] = DOT_0;
                return;
            }
            if (MAP[SIZE-1][0] == DEFAULT) {
                MAP[SIZE-1][0] = DOT_0;
                return;
            }
        }
        if (MAP[0][SIZE-1] == DOT_X) {
            if (MAP[0][0] == DEFAULT) {
                MAP[0][0] = DOT_0;
                return;
            }
            if (MAP[SIZE-1][SIZE-1] == DEFAULT) {
                MAP[SIZE-1][SIZE-1] = DOT_0;
                return;
            }
        }
        if (MAP[SIZE-1][0] == DOT_X) {
            if (MAP[0][0] == DEFAULT) {
                MAP[0][0] = DOT_0;
                return;
            }
            if (MAP[SIZE-1][SIZE-1] == DEFAULT) {
                MAP[SIZE-1][SIZE-1] = DOT_0;
                return;
            }
        }
        if (MAP[SIZE-1][SIZE-1] == DOT_X) {
            if (MAP[SIZE-1][0] == DEFAULT) {
                MAP[SIZE-1][0] = DOT_0;
                return;
            }
            if (MAP[0][SIZE-1] == DEFAULT) {
                MAP[0][SIZE-1] = DOT_0;
                return;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DEFAULT) {
                    MAP[i][j] = DOT_0;
                    return;
                }
            }

        }

    }

    private static boolean isWin() {
        int winChain = 0;
        if (SIZE == 3) winChain = 3;
        if (SIZE == 5) winChain = 4;
        if (SIZE == 7) winChain = 5;
        boolean ifWin = true;
        char curSymbol;
        int chain0;
        int chainX;
        for (int i = 0; i < SIZE; i++) {
            chainX = 0;
            chain0 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[j][i] == DOT_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (MAP[j][i] == DOT_0) chain0++;
                else {
                    if (chain0 >= winChain) {
                        return true;
                    }
                    chain0 = 0;
                }
            }
            if ((chainX >= winChain) || (chain0 >= winChain)) return true;
        }

        for (int i = 0; i < SIZE; i++) {
            chainX = 0;
            chain0 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == DOT_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (MAP[i][j] == DOT_0) chain0++;
                else {
                    if (chain0 >= winChain) {
                        return true;
                    }
                    chain0 = 0;
                }
            }
            if ((chainX >= winChain) || (chain0 >= winChain)) return true;
        }
        if (SIZE == 3 && MAP[SIZE / 2][SIZE / 2] == DEFAULT) return false;

        for (int shift = 0; shift < SIZE - 2; shift++) {
            chainX = 0;
            chain0 = 0;
            for (int j = SIZE - 1, index = 3 - winChain + shift; j >= 0; j--, index++) {
                if (index >= 0 && index < SIZE && MAP[j][index] == DOT_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (index >= 0 && index < SIZE && MAP[j][index] == DOT_0) chain0++;
                else {
                    if (chain0 >= winChain) {
                        return true;
                    }
                    chain0 = 0;
                }
            }
            if ((chainX >= winChain) || (chain0 >= winChain)) return true;
        }

        for (int shift = 0; shift < SIZE - 2; shift++) {
            chainX = 0;
            chain0 = 0;
            for (int j = 0, index = 3 - winChain + shift; j < SIZE; j++, index++) {
                if (index >= 0 && index < SIZE && MAP[j][index] == DOT_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (index >= 0 && index < SIZE && MAP[j][index] == DOT_0) chain0++;
                else {
                    if (chain0 >= winChain) {
                        return true;
                    }
                    chain0 = 0;
                }
            }
            if ((chainX >= winChain) || (chain0 >= winChain)) return true;
        }
        return false;
    }

    private static void showStartGameDialog(Scanner in) {
        System.out.println("Это игра крестики-нолики");
        System.out.println("Какого размера поле Вы хотите?");
        System.out.println("1. 3x3");
        System.out.println("2. 5x5");
        System.out.println("3. 7x7");
        int variant;
        while (true) {
            System.out.print("Введите номер желаемого варианта: ");
            String values = in.nextLine();
            try {
                variant = Integer.parseInt(values);
                if (variant == 1 ) SIZE = 3;
                else if (variant == 2) SIZE = 5;
                else if (variant == 3) SIZE = 7;
                else{
                    System.out.println("Некорректный ввод");
                    continue;
                }
            }
            catch (NumberFormatException error) {
                System.out.println("Некорректный ввод");
                continue;
            }
            MAP = new char[SIZE][SIZE];
            break;
        }
        System.out.println("Вы выбрали поле размером " + SIZE + "x" + SIZE);
        System.out.println("Чтобы сделать ход введите 2 числа: номер строки и номер столбца");
        System.out.println("Например, \"2 1\" ");
    }

    private static void startGame() {
        Scanner in = new Scanner(System.in);
        showStartGameDialog(in);
        initMap();
        int counterOfPlayerMoves = 0;
        while(true) {
            printMap();
            System.out.println("Ваш ход: ");
            String[] values = in.nextLine().split(" ");
            if (values.length != 2) {
                System.out.println("Вы ввели некорректные данные. Введите ровно 2 числа");
                continue;
            }
            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if (isCellValid(x, y)) {
                    makeStep(x, y, DOT_X);
                    counterOfPlayerMoves++;
                    if (isWin()) {
                        printMap();
                        System.out.println("Вы выиграли!");
                        showEndGameDialog(in);
                        break;
                    }
                    if (counterOfPlayerMoves == (SIZE * SIZE / 2 + 1)) {
                        printMap();
                        System.out.println("Ничья!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                    System.out.println("\nХод компьютера: ");
                    moveAI();
                    if (isWin()) {
                        printMap();
                        System.out.println("Вы проиграли!");
                        showEndGameDialog(in);
                        break;
                    }
                }
                else {
                    System.out.println("Некорректный ход. Введите другие значения");
                }
            }
            catch (NumberFormatException error) {
                System.out.println("Вы ввели некорректные данные.\n Данные должны быть от 1 до 3");
            }
        }
    }

    private static void showEndGameDialog(Scanner in) {
        while (true) {
            System.out.println("Начать новую игру? y/n");
            String command = in.next();
            if (command.equals("y")) {
                System.out.println();
                startGame();
                return;
            }
            else if (command.equals("n")) {
                System.out.println("Игра завершена");
                return;
            }
        }
    }

    public static void main(String[] args) {
            startGame();
    }

}
