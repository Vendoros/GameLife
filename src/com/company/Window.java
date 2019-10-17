package com.company;

import javax.swing.*;

public class Window implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        initFrame();
    }

    private void initFrame() {
        frame = new JFrame();//создаем фрэйи
        frame.getContentPane().setLayout(null);//расположение на всю форму
        frame.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);// устанавливаем размеры окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//выход из программы при закрытии
        frame.setLocationRelativeTo(null);//
        frame.setVisible(true);// делаем окно видимым
        frame.setTitle("Life Game");//задаем заголовок окна
    }
}
