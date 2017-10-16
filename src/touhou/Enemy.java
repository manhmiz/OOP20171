package touhou;

import java.awt.*;
import java.awt.image.BufferedImage;

import bases.Utils;

public class Enemy {
    BufferedImage enemy;

    int x1 = 50;
    int x2 =300;
    int x3 =50;
    int x4 = 300;
    int y1 =0;
    int y2 = -100;
    int yTurn = 200;

    final int SPEED = 2;

    public Enemy(){
        enemy = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }
    public void render(Graphics graphics){
        graphics.drawImage(enemy,x1,y1,null);
        graphics.drawImage(enemy,x2,y1,null);
        graphics.drawImage(enemy,x3,y2,null);
        graphics.drawImage(enemy,x4,y2,null);

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
