package game.platforms;

import bases.GameObject;
import bases.renderers.ImageRenderer;

public class Tree extends GameObject{
    public Tree(){
        this.renderer = new ImageRenderer("assets/images/platforms/tree2.png");
    }
}
