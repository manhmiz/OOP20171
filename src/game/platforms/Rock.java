package game.platforms;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;

public class Rock extends GameObject implements PhysicsBody{
    BoxCollider boxCollider;
    public Rock(){
        this.renderer = new ImageRenderer("assets/images/platforms/rock2.png");
        boxCollider = new BoxCollider(19,19);
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
