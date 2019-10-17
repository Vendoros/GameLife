package com.company;

import javax.swing.*;

public class Window implements Runnable {

    JFrame frame;

    @Override
    public void run() {
        initFrame();
    }

    void initFrame(){
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Life Game");
    }
}
