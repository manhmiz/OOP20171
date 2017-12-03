package game.players.playerblue;

import game.players.Player;

public class PlayerBlue extends Player {

    public BlueCastBullet castBullet;
    public BlueAnimator animator;

    public PlayerBlue(){
        this.castBullet = new BlueCastBullet();

        HP = 10;

        animator = new BlueAnimator();
        this.renderer = animator;
    }

    @Override
    public void run() {
        super.run();
        animator.run();
        this.castBullet.run(this);
    }

}
