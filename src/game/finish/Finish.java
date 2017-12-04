package game.finish;

import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;
import bases.renderers.ImageRenderer;

public class Finish extends GameObject implements PhysicsBody{
    BoxCollider boxCollider = new BoxCollider(19,19);
    public Finish(){
        super();
        this.renderer = new ImageRenderer("assets/images/platforms/finish.png");
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
