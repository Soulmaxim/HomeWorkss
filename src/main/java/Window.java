import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static final ImageIcon ICON_X = new ImageIcon("cross.gif");
    private static final ImageIcon ICON_0 = new ImageIcon("zero.gif");
    private static final ImageIcon ICON_DEFAULT = new ImageIcon("default.png");
    private static final ImageIcon ICON_TITLE = new ImageIcon("icon.png");
    private static int SIZE = 3;
    private static JButton[][] buttons = new JButton[3][3];

    private static void moveAI() {
        for (int i = 0; i < SIZE; i++) {            // проверяем можем ли комп выиграть
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].isEnabled()) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setIcon(ICON_0);
                    buttons[i][j].setDisabledIcon(ICON_0);
                    if (isWin()) return;
                    else {
                        buttons[i][j].setEnabled(true);
                        buttons[i][j].setIcon(ICON_DEFAULT);
                    }
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {            // проверяем можем ли игрок выиграть (если да, то ходим так, как сходил бы игрок)
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].isEnabled()) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setIcon(ICON_X);
                    buttons[i][j].setDisabledIcon(ICON_X);
                    if (isWin()) {
                        buttons[i][j].setIcon(ICON_0);
                        buttons[i][j].setDisabledIcon(ICON_0);
                        return;
                    }
                    else {
                        buttons[i][j].setEnabled(true);
                        buttons[i][j].setIcon(ICON_DEFAULT);
                    }
                }
            }
        }

        if (buttons[SIZE/2][SIZE/2].isEnabled()) {
            buttons[SIZE/2][SIZE/2].setEnabled(false);
            buttons[SIZE/2][SIZE/2].setIcon(ICON_0);
            buttons[SIZE/2][SIZE/2].setDisabledIcon(ICON_0);
            return;
        }
        if (buttons[0][0].getIcon() == ICON_X) {
            if (buttons[0][SIZE-1].isEnabled()) {
                buttons[0][SIZE-1].setEnabled(false);
                buttons[0][SIZE-1].setIcon(ICON_0);
                buttons[0][SIZE-1].setDisabledIcon(ICON_0);
                return;
            }
            if (buttons[SIZE-1][0].isEnabled()) {
                buttons[SIZE-1][0].setEnabled(false);
                buttons[SIZE-1][0].setIcon(ICON_0);
                buttons[SIZE-1][0].setDisabledIcon(ICON_0);
                return;
            }
        }
        if (buttons[0][SIZE-1].getIcon() == ICON_X) {
            if (buttons[0][0].isEnabled()) {
                buttons[0][0].setEnabled(false);
                buttons[0][0].setIcon(ICON_0);
                buttons[0][0].setDisabledIcon(ICON_0);
                return;
            }
            if (buttons[SIZE-1][SIZE-1].isEnabled()) {
                buttons[SIZE-1][SIZE-1].setEnabled(false);
                buttons[SIZE-1][SIZE-1].setIcon(ICON_0);
                buttons[SIZE-1][SIZE-1].setDisabledIcon(ICON_0);
                return;
            }
        }
        if (buttons[SIZE-1][0].getIcon() == ICON_X) {
            if (buttons[0][0].isEnabled()) {
                buttons[0][0].setEnabled(false);
                buttons[0][0].setIcon(ICON_0);
                buttons[0][0].setDisabledIcon(ICON_0);
                return;
            }
            if (buttons[SIZE-1][SIZE-1].isEnabled()) {
                buttons[SIZE-1][SIZE-1].setEnabled(false);
                buttons[SIZE-1][SIZE-1].setIcon(ICON_0);
                buttons[SIZE-1][SIZE-1].setDisabledIcon(ICON_0);
                return;
            }
        }
        if (buttons[SIZE-1][SIZE-1].getIcon() == ICON_X) {
            if (buttons[SIZE-1][0].isEnabled()) {
                buttons[SIZE-1][0].setEnabled(false);
                buttons[SIZE-1][0].setIcon(ICON_0);
                buttons[SIZE-1][0].setDisabledIcon(ICON_0);
                return;
            }
            if (buttons[0][SIZE-1].isEnabled()) {
                buttons[0][SIZE-1].setEnabled(false);
                buttons[0][SIZE-1].setIcon(ICON_0);
                buttons[0][SIZE-1].setDisabledIcon(ICON_0);
                return;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].isEnabled()) {
                    buttons[i][j].setEnabled(false);
                    buttons[i][j].setIcon(ICON_0);
                    buttons[i][j].setDisabledIcon(ICON_0);
                    return;
                }
            }

        }

    }

    private static boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].isEnabled()) return false;
            }
        }
        return true;
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
                if (buttons[j][i].getIcon() == ICON_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (buttons[j][i].getIcon() == ICON_0) chain0++;
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
                if (buttons[i][j].getIcon() == ICON_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (buttons[i][j].getIcon() == ICON_0) chain0++;
                else {
                    if (chain0 >= winChain) {
                        return true;
                    }
                    chain0 = 0;
                }
            }
            if ((chainX >= winChain) || (chain0 >= winChain)) return true;
        }
        if (SIZE == 3 && buttons[SIZE / 2][SIZE / 2].isEnabled()) return false;

        for (int shift = 0; shift < SIZE - 2; shift++) {
            chainX = 0;
            chain0 = 0;
            for (int j = SIZE - 1, index = 3 - winChain + shift; j >= 0; j--, index++) {
                if (index >= 0 && index < SIZE && buttons[j][index].getIcon() == ICON_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (index >= 0 && index < SIZE && buttons[j][index].getIcon() == ICON_0) chain0++;
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
                if (index >= 0 && index < SIZE && buttons[j][index].getIcon() == ICON_X) chainX++;
                else {
                    if (chainX >= winChain) {
                        return true;
                    }
                    chainX = 0;
                }
                if (index >= 0 && index < SIZE && buttons[j][index].getIcon() == ICON_0) chain0++;
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

    private static void startGame() {
        new Window();
    }

    public Window() {
        setSize(600, 600);
        setTitle("tic-tac-toe");
        setIconImage(ICON_TITLE.getImage());
        setLocation(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem item1 = new JMenuItem("New");
        JMenuItem item2 = new JMenuItem("Open (not work)");
        JMenuItem item3 = new JMenuItem("Save (not work)");
        JMenuItem item4 = new JMenuItem("Exit");
        item1.addActionListener(e -> {
            new Window();
            dispose();
        });
        item4.addActionListener(e -> dispose());
        file.add(item1);
        file.add(item2);
        file.addSeparator();
        file.add(item3);
        file.add(item4);
        file.addSeparator();
        JMenu view = new JMenu("View");
        JMenuItem item6 = new JMenuItem("Size (not work)");
        JMenuItem item7 = new JMenuItem("Background (not work)");
        view.add(item6);
        view.add(item7);
        menubar.add(file);
        menubar.add(view);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(menubar, BorderLayout.NORTH);

        JLabel label = new JLabel("Copyright (C) 2021");
        panel.add(label, BorderLayout.SOUTH);
        add(panel);

        JLabel result = new JLabel();
        System.out.println(result.getFont());
        result.setFont(new Font("Dialog", Font.PLAIN, 50));

        JLabel endDialog = new JLabel("Нажмите \"new\", чтобы начать сначала");

        JPanel fp = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(ICON_DEFAULT);
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addActionListener(e -> {
                    buttons[finalI][finalJ].setIcon(ICON_X);
                    buttons[finalI][finalJ].setEnabled(false);
                    buttons[finalI][finalJ].setDisabledIcon(ICON_X);
                    if (isWin()) {
                        fp.setVisible(false);
                        label.setVisible(false);
                        result.setText("Вы выиграли!");
                        panel.add(result, BorderLayout.CENTER);
                        panel.add(endDialog, BorderLayout.SOUTH);
                        return;
                    }
                    if (isDraw()) {
                        fp.setVisible(false);
                        label.setVisible(false);
                        result.setText("Ничья!");
                        panel.add(result, BorderLayout.CENTER);
                        panel.add(endDialog, BorderLayout.SOUTH);
                        return;
                    }
                    moveAI();
                    if (isWin()) {
                        fp.setVisible(false);
                        label.setVisible(false);
                        result.setText("Вы проиграли!");
                        panel.add(result, BorderLayout.CENTER);
                        panel.add(endDialog, BorderLayout.SOUTH);
                        return;
                    }
                });
                fp.add(buttons[i][j]);
            }
        }
        panel.add(fp, BorderLayout.CENTER);

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        startGame();

    }
}
