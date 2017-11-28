package game.players;

import bases.GameObject;
import bases.Utils;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.Animation;
import bases.renderers.ImageRenderer;
import game.platforms.Brick;

import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject implements PhysicsBody{
    BoxCollider boxCollider;
    PlayerAnimator animator;
    final int SPEED = 4;
    public PlayerSpell(){
        boxCollider = new BoxCollider(5,5);
        BufferedImage[] images = new BufferedImage[]{Utils.loadImage("assets/images/player-bullets/bullet.png")};
        this.renderer = new Animation(images);

    }
    public void run(){
        boxCollider.position.set(this.position);

//        Brick brick = GameObject.collideWith(boxCollider, Brick.class);
//        if (brick != null){
//            this.isActive = false;
//        }
        animator = new PlayerAnimator();
        if (animator.equals(animator.leftAnimation)){
            this.position.subtractBy(this.SPEED,0);
            System.out.println("ban trai");
        }
        else if (animator.equals(animator.rightAnimation)){
            this.position.addUP(this.SPEED,0);
            System.out.println("ban phai");
        }
        else if (animator.equals(animator.upAnimation)){
            this.position.subtractBy(0,this.SPEED);
            System.out.println("ban len");
        }
        else if (animator.equals(animator.downAnimation)) {
            this.position.addUP(0, this.SPEED);
            System.out.println("ban xuong");
        }
    }
    @Override
    public BoxCollider getBoxCollider() {

        return this.boxCollider;
    }
}
