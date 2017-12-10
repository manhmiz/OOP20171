package game.players.playerblue;

import bases.Utils;
import bases.renderers.Animation;
import game.players.PlayerAnimator;

public class BlueAnimator extends PlayerAnimator{

    public BlueAnimator(){

        leftAnimation = new Animation(Utils.loadImage("assets/images/player/blue_left.png"));
        rightAnimation = new Animation(Utils.loadImage("assets/images/player/blue_right.png"));
        upAnimation = new Animation(Utils.loadImage("assets/images/player/blue_up.png"));
        downAnimation = new Animation(Utils.loadImage("assets/images/player/blue_down.png"));

        currentAnimation = upAnimation;
    }
}
