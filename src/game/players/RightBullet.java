package game.players;

public class RightBullet extends PlayerBullet {
    @Override
    public void run() {
        super.run();
        this.velocity.x = SPEED;
        this.velocity.y = 0;
    }
}
