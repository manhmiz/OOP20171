package touhou.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject implements PhysicsBody{

    final int SPEED = 10;
    public BoxCollider boxCollider;


    public PlayerSpell()
    {
        image = Utils.loadImage("assets/images/player-bullets/a/1.png");
        boxCollider = new BoxCollider(20,20);

    }


    public void run() {
        this.position.subtractBy(0, SPEED);
        boxCollider.position.set(this.position);
        Enemy enemy = GameObject.collideWith(boxCollider, Enemy.class);
        if (enemy != null) {
            enemy.getHit();
        }
        deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if (position.y < 0){
            this.isActive = false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
