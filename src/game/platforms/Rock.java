package game.platforms;

import bases.GameObject;
import bases.renderers.ImageRenderer;

public class Rock extends GameObject{
    public Rock(){
        this.renderer = new ImageRenderer("assets/images/platforms/rock.png");
    }
}
