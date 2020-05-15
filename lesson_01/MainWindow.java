package ru.gb.jtwo.alesson.online;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainWindow extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];
    Background b = new Background();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        MainCanvas canvas = new MainCanvas(this);
        initApplication();
        add(canvas);
        setTitle("Circles");
        setVisible(true);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    addNewBall();
                }
                if (e.getButton() == 3) {
                    deleteLastBall();
                }
            }
        });
    }

    private void addNewBall() {
        Sprite [] newSprites = new Sprite[sprites.length + 1];

        for (int i = 0; i < sprites.length; i++) {
            newSprites[i] = sprites[i];
        }

        newSprites[sprites.length] = new Ball();
        sprites = newSprites;
    }

    private void deleteLastBall() {
        if (sprites.length == 0) {
            return;
        }

        Sprite [] newSprites = new Sprite[sprites.length - 1];

        for (int i = 0; i < newSprites.length; i++) {
            newSprites[i] = sprites[i];
        }
        sprites = newSprites;
    }


    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }


    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        b.update(canvas, deltaTime);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        b.render(canvas, g);
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

//    private static void method1(Animal a) {
//        a.name = "Barsik";
//    }
//
//    private static void sum(int a, int b) {
//
//    }
//
//    private static void typecastExample() {
//        Cat c = new Cat("Barsik");
//        Bird b = new Bird("Chijik");
//
//        Animal[] zoo = {c, b};
//
//        for (int i = 0; i < zoo.length; i++) {
//            zoo[i].walk();
//
//            if (zoo[i] instanceof Bird) {
//                ( (Bird) zoo[i] ).fly();
//            }
//        }
//    }
}
