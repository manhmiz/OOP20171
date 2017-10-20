package touhou;

import java.awt.*;
import java.awt.image.BufferedImage;

import bases.GameObject;
import bases.Utils;

public class Enemy extends GameObject{

    final int yTurn = 200;

    final int SPEED = 2;

    public Enemy(){
        x = 50;
        y = 0;
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }


    public void run() {
        if (y != yTurn ) {
            y += SPEED;
        }else x += SPEED;

    }
}
