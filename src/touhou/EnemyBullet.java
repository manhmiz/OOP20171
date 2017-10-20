package touhou;

import bases.GameObject;
import bases.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject{


    final int SPEED = 3;


    public EnemyBullet() {
        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
    }


    public void run() {
        y += SPEED;
    }

}
