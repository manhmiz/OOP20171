package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject{

    final int SPEED = 10;
    public BoxCollider boxCollider;

    public PlayerSpell()
    {

        image = Utils.loadImage("assets/images/player-bullets/a/0.png");
        boxCollider = new BoxCollider(20,20);
    }


    public void run() {
        this.position.subtractBy(0,SPEED);
        boxCollider.position.set(this.position);
        Enemy enemy = GameObject.collideWidth(this.boxCollider);
        if (enemy != null){
            enemy.getHit();
            this.isActive = false;
        }
    }
}
