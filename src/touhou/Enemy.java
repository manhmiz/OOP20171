package touhou;

import java.awt.*;
import java.awt.image.BufferedImage;

import bases.Utils;

public class Enemy {
    BufferedImage image;

    public int x1 = 50;
    public int x2 =300;
    public int x3 =50;
    public int x4 = 300;
    public int y1 =0;
    public int y2 = -100;
    int yTurn = 200;

    final int SPEED = 2;

    public Enemy(){
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }
    public void render(Graphics graphics){
        graphics.drawImage(image,x1,y1,null);
        graphics.drawImage(image,x2,y1,null);
        graphics.drawImage(image,x3,y2,null);
        graphics.drawImage(image,x4,y2,null);

    }
    public void run(){
        if (y1 != yTurn && y2 != yTurn){
            y1 += SPEED;
            y2 += SPEED;
        }
        if (y1 == yTurn && y2 != yTurn){
            y2 += SPEED;
            x1 -= SPEED;
            x2 += SPEED;
        }
        if (y2 == yTurn){
            x3 -=SPEED;
            x4 +=SPEED;
        }
    }
}
