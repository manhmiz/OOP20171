package game.platforms;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;

public class Water extends GameObject implements PhysicsBody{
    BoxCollider boxCollider;
    public Water(){
        this.renderer = new ImageRenderer("assets/images/platforms/water.png");
        this.boxCollider = new BoxCollider(19,19);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
