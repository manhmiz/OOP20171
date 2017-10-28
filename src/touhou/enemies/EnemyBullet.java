package touhou.enemies;

import bases.GameObject;
import bases.ImageRenderer;
import bases.physics.BoxCollider;
import touhou.players.Player;

public class EnemyBullet extends GameObject {

    final int SPEED = 3;
    public BoxCollider boxCollider;

    public EnemyBullet() {

//        image = Utils.loadImage("assets/images/enemies/bullets/blue.png");
        this.renderer = new ImageRenderer("assets/images/enemies/bullets/blue.png");
        boxCollider = new BoxCollider(10,10);
    }

    public void run() {

        position.addUP(0, SPEED);
        boxCollider.position.set(this.position);
        Player player = GameObject.collideWith(this.boxCollider, Player.class);
        if (player != null){
         player.getHit();
         this.isActive = false;
        }
        deactiveIfNeeded();
    }
    private void deactiveIfNeeded() {
        if (position.y > 600){
            this.isActive = false;
        }
    }
}
