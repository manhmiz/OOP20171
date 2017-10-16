package touhou;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import bases.Utils;

public class Enemy {
    BufferedImage image;

    int x;
    int y1 = 50;
    int y2 = 350;

    ArrayList<Enemy> bullets = new ArrayList<>();
    public Enemy(){
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }
    public void render(Graphics graphics){
        graphics.drawImage(image,x,y1,null);
        graphics.drawImage(image,x,y2,null);
    }
    public void run(){

    }
}
