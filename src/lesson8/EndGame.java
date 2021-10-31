package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGame extends JFrame {
    private int var;

    public EndGame(int var, int size, int dotW) {
        this.var = var;
        setTitle("End Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 700, 600, 300);
        setLayout(null);
        JLabel label = new JLabel();
        label.setBounds(100, 50, 600, 50);
        Font font = new Font("Arial", Font.BOLD, 32);
        label.setFont(font);
        switch (var) {
            case 1:
                label.setText("Ничья");
                break;
            case 2:
                label.setText("Вы победили");
                label.setForeground(Color.GREEN);
                break;
            case 3:
                label.setText("Победил компьютер");
                label.setForeground(Color.RED);
                break;
            default:
                break;
        }
        add(label);
        JButton butMenu = new JButton("Menu");
        butMenu.setBounds(50, 150, 100, 50);
        butMenu.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                         new Menu();
                                          dispose();
                                      }
                                  }
        );
        add(butMenu);
        JButton butNewGame = new JButton("New game");
        butNewGame.setBounds(250, 150, 100, 50);
        butNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicTacToe(size, dotW);
                dispose();
            }
        });
        add(butNewGame);
        JButton butExit = new JButton("Exit");
        butExit.setBounds(450, 150, 100, 50);
        butExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(butExit);
        setVisible(true);
    }
}
