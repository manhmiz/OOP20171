package touhou;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import bases.GameObject;
import bases.Utils;

public class Enemy extends GameObject{

    final int yTurn = 200;
    final int SPEED = 2;

    boolean bulletDisabled ;
    final int COOL_DOWN_TIME = 30;
    int coolDownTime;

    public Enemy(){
        x = 50;
        y = 0;
        image = Utils.loadImage("assets/images/enemies/level0/blue/0.png");
    }


    public void run() {
       move();
       shoot();
    }


    public void move(){
        if (y != yTurn ) {
            y += SPEED;
        }else x += SPEED;

    }
    private void shoot() {
        if (bulletDisabled){
            coolDownTime++;
            if (coolDownTime >= COOL_DOWN_TIME){
                bulletDisabled = false;
                coolDownTime = 0;
            }
            return;
        }
            EnemyBullet newBullet = new EnemyBullet();
            newBullet.x = x;
            newBullet.y = y;
            GameObject.add(newBullet);
            bulletDisabled = true;


    }
}
