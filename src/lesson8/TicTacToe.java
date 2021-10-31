package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe extends JFrame {

    private static int size;
    private static int dotWins;
    private static final char DOT_EMPTY = ' ';
    private static final char DOT_X = 'X';
    private static final char DOT_0 = 'O';
    private static char[][] map;
    private static Random rand = new Random();
    private static int bestX;
    private static int bestY;
    private boolean flag = true;

    public TicTacToe(int size, int dotWins) {
        this.size = size;
        this.dotWins = dotWins;
        initMap();
        setTitle("Tic tac toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 600, 600);
        setLayout(new GridLayout(size, dotWins));

        JButton[][] jmap = new JButton[size][size];
        Font font = new Font("Arial", Font.BOLD, 32);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                add(jmap[i][j] = new JButton(String.valueOf(map[i][j])));
                jmap[i][j].setFont(font);
                int finalI = i;
                int finalJ = j;
                jmap[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (map[finalI][finalJ] == DOT_EMPTY && flag) {
                            flag = false;
                            map[finalI][finalJ] = DOT_X;
                            jmap[finalI][finalJ].setText(String.valueOf(DOT_X));
                            flag = continueGame();
                            jmap[bestX][bestY].setText(String.valueOf(DOT_0));
                        }
                    }
                });
            }
        setVisible(true);

    }


    private boolean continueGame() {
        if (isMapFull()) {
            EndGame eg = new EndGame(1, size, dotWins);
            dispose();
            return (false);

        }
        if (checkWin(DOT_X)) {
            EndGame eg = new EndGame(2, size, dotWins);
            dispose();
            return (false);

        }
        aiTurn();
        if (isMapFull()) {
            EndGame eg = new EndGame(1, size, dotWins);
            dispose();
            return (false);
        }
        if (checkWin(DOT_0)) {
            EndGame eg = new EndGame(3, size, dotWins);
             dispose();
            return (false);
        }
        return true;
    }

    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++)
            Arrays.fill(map[i], DOT_EMPTY);
    }

    private static void printMap() {
        for (int i = 0; i <= size; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < size; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    private static boolean noFreeCell(int x, int y) {
        return map[y][x] != DOT_EMPTY;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    private static boolean checkWin(char symbol) {
        int check1, check2, check3, check4;
        //Проверка победы по строкам и столбцам
        for (int i = 0; i < size; i++) {
            check1 = 0;
            check2 = 0;
            for (int j = 0; j < size; j++) {
                //Проверка победы по строкам
                if (map[i][j] == symbol) {
                    check1++;
                    if (check1 == dotWins)
                        return true;
                } else
                    check1 = 0;
                //Проверка победы по столбцам
                if (map[j][i] == symbol) {
                    check2++;
                    if (check2 == dotWins)
                        return true;
                } else
                    check2 = 0;
            }
        }
        //Проверка победы по диагоналям
        for (int i = 0; i <= size - dotWins; i++) {
            check1 = 0;
            check2 = 0;
            check3 = 0;
            check4 = 0;
            for (int j = 0; j < size - i; j++) {

                //Проверка победы по прямым диагоналям от главной в правую сторону
                if (map[i + j][j] == symbol) {
                    check1++;
                    if (check1 == dotWins)
                        return true;
                } else
                    check1 = 0;

                //Проверка победы по прямым диагоналям от главной вниз
                //К сожалению главные диагонали проверяются дважды
                if (map[j][j + i] == symbol) {
                    check2++;
                    if (check2 == dotWins)
                        return true;
                } else
                    check2 = 0;

                //Проверка победы по обратной диагонали от главной в правую сторону
                if (map[size - 1 - j - i][j] == symbol) {
                    check3++;
                    if (check3 == dotWins)
                        return true;
                } else
                    check3 = 0;

                //Проверка победы по обратной диагонали от главной вверх
                if (map[size - 1 - j][j + i] == symbol) {
                    check4++;
                    if (check4 == dotWins)
                        return true;
                } else
                    check4 = 0;
            }
        }
        return false;
    }

    private static void aiTurn() {
        if (searchBestMove())
            map[bestX][bestY] = DOT_0;
        else
            randomMove();
    }

    // В этом методе расписан поиск лучшего хода. Возвращает true если ход найден и false если нет
    // Координаты лучшего хода хранятся в полях bestX и bestY
    private static boolean searchBestMove() {
        if (searchOneTurnWin(DOT_0))
            return true;
        if (searchOneTurnWin(DOT_X))
            return true;
        if (searchTwoTurnWin(DOT_0))
            return true;
        return searchTwoTurnWin(DOT_X);
    }

    // метод проверяет есть ли победа если поставить symb по координатам x-y
    // перед вызовом обязательна проверка на то что координаты x-y пусты.
    private static boolean oneTurnWin(int x, int y, char symb) {
        map[x][y] = symb;
        if (checkWin(symb)) {
            map[x][y] = DOT_EMPTY;
            return true;
        } else {
            map[x][y] = DOT_EMPTY;
            return false;
        }
    }

    // метод перебирает все возможные ходы и проверяет есть ли победа в один ход
    private static boolean searchOneTurnWin(char symb) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] == DOT_EMPTY && oneTurnWin(i, j, symb)) {
                    bestX = i;
                    bestY = j;
                    return true;
                }
        return false;
    }

    //Проверка победы в два хода по координатам x-y. Для этого после первого хода должно быть как минимум 2 выигрывающих в 1 ход продолжения.
    //Соперник не сможет заблокировать оба.
    private static boolean twoTurnWin(int x, int y, char symb) {
        int check = 0;
        map[x][y] = symb;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY && oneTurnWin(i, j, symb)) {
                    check++;
                    if (check == 2) {
                        map[x][y] = DOT_EMPTY;
                        return true;
                    }
                }
            }
        map[x][y] = DOT_EMPTY;
        return false;
    }


    // Перебор всех возможных ходов. Поиск победы в 2 хода.
    private static boolean searchTwoTurnWin(char symb) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] == DOT_EMPTY && twoTurnWin(i, j, symb)) {
                    bestX = i;
                    bestY = j;
                    return true;
                }
        return false;
    }

    // метод делает случайный ход ИИ
    private static void randomMove() {
        int x;
        int y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (noFreeCell(x, y));
        map[y][x] = DOT_0;
        bestX = y;
        bestY = x;
    }
}