package game;

import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGround {
    BufferedImage image;
    int x;
    int y;

    public BackGround() {

        image = Utils.loadImage("assets/images/background/0.png");
    }

    public void render(Graphics graphics){
        graphics.drawImage(image,x,y,null);
    }
    public void run() {
    }

}
