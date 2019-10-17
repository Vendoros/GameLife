package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window implements Runnable {

    private JFrame frame;
    private Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
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
        for (int x = 0; x < Config.WIDTH; x++) {//выбираем конкретную
            for (int y = 0; y < Config.HEIGHT; y++) {//клетку на экране                   X X X
                for (int sx = -1; sx <= +1; sx++) {//проверяем все                        X * X
                    for (int sy = -1; sy <= +1; sy++) {// 9 ближайших ячеек ->            X X X
                        if (!(sx == 0 && sy == 0)) {// центральная клетка отсеевается
                            boxes[x][y].cell.addNear(boxes// добавляем в cell как соседнию клетку addNear
                                    [(x + sx + Config.WIDTH) % Config.WIDTH]
                                    [(y + sy + Config.HEIGHT) % Config.HEIGHT].cell);
                        }
                    }
                }
            }
        }
    }

    private void initTimer(){
        TimerListener t1 = new TimerListener();
        Timer timer = new Timer(Config.SLEEPMS, t1);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            flop = !flop;
            for (int x = 0; x < Config.WIDTH; x++) {//выбираем конкретную
                for (int y = 0; y < Config.HEIGHT; y++) {//клетку на экране
                    if(flop) {
                        boxes[x][y].prepare();
                    }else {
                        boxes[x][y].replays();
                    }
                }
            }
        }
    }
}
