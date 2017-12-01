package game.platforms;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;

public class Brick extends GameObject implements PhysicsBody{
    BoxCollider boxCollider = new BoxCollider(19,19);
    public Brick(){
        super();
        this.renderer = new ImageRenderer("assets/images/platforms/brick.png");
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
    }

    public void getHit() {
            this.isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
//        return null;
    }
}
