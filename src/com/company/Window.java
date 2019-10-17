package com.company;

import javax.swing.*;

public class Window implements Runnable {

    private JFrame frame;
    private Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
    }

    //инициализация окна программы
    private void initFrame() {
        frame = new JFrame();//создаем фрэйи
        frame.getContentPane().setLayout(null);//расположение на всю форму
        frame.setSize(Config.SIZE * Config.WIDTH, Config.SIZE * Config.HEIGHT);// устанавливаем размеры окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//выход из программы при закрытии
        frame.setLocationRelativeTo(null);//
        frame.setVisible(true);// делаем окно видимым
        frame.setTitle("Life Game");//задаем заголовок окна
    }

    private void initBoxes() {
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
    }
}
