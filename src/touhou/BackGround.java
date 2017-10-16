package touhou;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround {
    BufferedImage image;
    int x;
    int y = -2600;

    final int TOP = 0;
    final int BOTTOM = -2500;

    public BackGround() {
        image = Utils.loadImage("assets/images/background/0.png");
    }

    public void render(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
    }

    public void run() {
        y += 10;
        y = (int)clamp(y, BOTTOM, TOP);
    }

    private float clamp(float value, float min, float max) {
        if (value > max) {
            return min;
        }
        return value;
    }
}
