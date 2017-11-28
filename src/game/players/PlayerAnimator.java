package game.players;

import bases.Utils;
import bases.physics.Vector2d;
import bases.renderers.Animation;
import bases.renderers.Renderer;

import java.awt.*;

public class PlayerAnimator implements Renderer{
    public Animation leftAnimation;
    public Animation rightAnimation;
    public Animation upAnimation;
    public Animation downAnimation;
    public Animation currentAnimation;

    public PlayerAnimator()
    {
     leftAnimation = new Animation(Utils.loadImage("assets/images/players/player_green_left.png"));
     rightAnimation = new Animation(Utils.loadImage("assets/images/players/player_green_right.png"));
     upAnimation = new Animation(Utils.loadImage("assets/images/players/player_green_up.png"));
     downAnimation = new Animation(Utils.loadImage("assets/images/players/player_green_down.png"));

     currentAnimation = upAnimation;
    }
    public void run(Player player){

        //Get player's velocity
        Vector2d velocity = player.velocity;
        //Based on velocity change animation
        if (velocity.x < 0) {
            currentAnimation = leftAnimation;
        }
        else if (velocity.x > 0){
            currentAnimation = rightAnimation;
        }
        else if (velocity.y < 0){
            currentAnimation = upAnimation;
        }
        else if (velocity.y >0){
            currentAnimation = downAnimation;
        }
    }
    @Override
    public void render(Graphics graphics, Vector2d position) {
        currentAnimation.render(graphics, position);
    }
}
