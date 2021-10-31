package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    public Menu() throws HeadlessException {
        final int[] size = {3};
        final int[] dotW = {3};

        setTitle("Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 600, 600);
        setLayout(null);
        JLabel ttt = new JLabel("Tic Tac Toe");
        ttt.setBounds(180, 70, 600, 50);
        Font font1 = new Font("Arial", Font.BOLD, 42);
        ttt.setFont(font1);
        add(ttt);

        JLabel lSize = new JLabel("Size");
        lSize.setBounds(120, 200, 200, 50);
        Font font2 = new Font("Arial", Font.BOLD, 28);
        lSize.setFont(font2);
        add(lSize);

        JLabel lDotWins = new JLabel("Dot Wins");
        lDotWins.setBounds(350, 200, 200, 50);
        lDotWins.setFont(font2);
        add(lDotWins);

        JLabel numSize = new JLabel(String.valueOf(size[0]));
        numSize.setBounds(140, 250, 50, 50);
        numSize.setFont(font2);
        add(numSize);

        JButton incrSize = new JButton(">");
        incrSize.setBounds(190, 250, 50, 50);
        incrSize.setFont(font2);
        incrSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (size[0]<10)
                {size[0]++;
              numSize.setText(String.valueOf(size[0]));}
            }
        });
        add(incrSize);

        JButton decrSize = new JButton("<");
        decrSize.setBounds(70, 250, 50, 50);
        decrSize.setFont(font2);
        decrSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (size[0]>3 && size[0]>dotW[0])
                { size[0]--;
                numSize.setText(String.valueOf(size[0]));}
            }
        });
        add(decrSize);

        JLabel numDot = new JLabel(String.valueOf(dotW[0]));
        numDot.setBounds(400, 250, 30, 50);
        numDot.setFont(font2);
        add(numDot);

        JButton incrDotW = new JButton(">");
        incrDotW.setBounds(440, 250, 50, 50);
        incrDotW.setFont(font2);
        incrDotW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dotW[0]<5 && dotW[0]<size[0])
                {dotW[0]++;
                    numDot.setText(String.valueOf(dotW[0]));}
            }
        });
        add(incrDotW);

        JButton decrDotW = new JButton("<");
        decrDotW.setBounds(330, 250, 50, 50);
        decrDotW.setFont(font2);
        decrDotW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dotW[0]>3)
                { dotW[0]--;
                    numDot.setText(String.valueOf(dotW[0]));}
            }
        });
        add(decrDotW);


        JButton butExit = new JButton("Exit");
        butExit.setBounds(400, 450, 100, 50);
        butExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(butExit);

        JButton butStart = new JButton("New game");
        butStart.setBounds(100, 450, 100, 50);
        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicTacToe(size[0], dotW[0]);
               dispose();
            }
        });
        add(butStart);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }

}
