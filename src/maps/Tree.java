package maps;

import bases.GameObject;
import bases.Utils;
import bases.renderers.Animation;

import java.awt.*;

public class Tree extends GameObject{
    public Tree(){
        this.renderer = new Animation(Utils.loadImage("assets/maps/gach.tsx"));
    }
}
