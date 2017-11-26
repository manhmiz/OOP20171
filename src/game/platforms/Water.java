package game.platforms;

import bases.GameObject;
import bases.renderers.ImageRenderer;

public class Water extends GameObject{
    public Water(){
        this.renderer = new ImageRenderer("assets/images/platforms/water.png");
    }
}
