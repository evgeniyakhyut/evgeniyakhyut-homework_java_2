package ru.gb.jtwo.alesson.online;

import java.awt.*;

public class Background extends Sprite {
    String directionR = "up";
    String directionG = "up";
    String directionB = "up";
    int r = (int) (Math.random() * 255);
    int g = (int) (Math.random() * 255);
    int b = (int) (Math.random() * 255);
    Color color = new Color(r, g, b);

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        int stepR = (int) (Math.random() * 100);
        int stepG = (int) (Math.random() * 100);
        int stepB = (int) (Math.random() * 100);

        if (directionR == "up") {
            r = (int) (r + deltaTime * stepR);
        } else {
            r = (int) (r - deltaTime * stepR);
        }

        if (r >= 255) {
            directionR = "down";
            r = 255;
        } else if (r <= 0) {
            directionR = "up";
            r = 0;
        }

        if (directionG == "up") {
            g = (int) (g + deltaTime * stepG);
        } else {
            g = (int) (g - deltaTime * stepG);
        }

        if (g >= 255) {
            directionG = "down";
            g = 255;
        } else if (g <= 0) {
            directionG = "up";
            g = 0;
        }

        if (directionB == "up") {
            b = (int) (b + deltaTime * stepB);
        } else {
            b = (int) (b - deltaTime * stepB);
        }

        if (b >= 255) {
            directionB = "down";
            b  = 255;
        } else if (b <= 0) {
            directionB = "up";
            b = 0;
        }

        color = new Color (r, g, b);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}