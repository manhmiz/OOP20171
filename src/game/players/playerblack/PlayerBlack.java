package game.players.playerblack;

import game.players.Player;

public class PlayerBlack extends Player {

    public BlackCastBullet castBullet;
    public BlackAnimator animator;

    public PlayerBlack(){
        this.castBullet = new BlackCastBullet();
        HP = 15;

        animator = new BlackAnimator();
        this.renderer = animator;
    }

    @Override
    public void run() {
        super.run();
        animator.run();
        this.castBullet.run(this);
    }

    @Override
    public void getHit() {
        super.getHit();
    }
}
