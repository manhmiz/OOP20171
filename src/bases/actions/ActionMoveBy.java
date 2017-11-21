package bases.actions;

import bases.FrameCounter;
import bases.GameObject;
import bases.physics.Vector2d;

public class ActionMoveBy implements Action {
    Vector2d velocity;
    FrameCounter frameCounter;

    public ActionMoveBy(Vector2d velocity, int frameCount){
        this.velocity = velocity;
        this.frameCounter = new FrameCounter(frameCount);
    }

    @Override
    public boolean run(GameObject owner) {
        if (frameCounter.run()){
            return true;
        } else {
            owner.position.addUP(velocity);
            return false;
        }
    }

    @Override
    public void reset() {
        frameCounter.reset();
    }
}
