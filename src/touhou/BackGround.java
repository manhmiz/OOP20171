package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround {
    BufferedImage image;
    int x;
    int y = -2500;

    final int TOP = 0;
    final int BOTTOM = -2500;
    final int SPEED = 10;

    public BackGround() {

        image = Utils.loadImage("assets/images/background/0.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image,x,y,null);
    }
    public void run() {
        y += SPEED;
        y = (int) clamp(y, BOTTOM, TOP);
    }

    private float clamp(float value, float min, float max) {
        if (value > max) {
            return min;
        }
        return value;
    }
}
