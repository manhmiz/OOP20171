package game.players;

public class DownBullet extends PlayerBullet{
    @Override
    public void run() {
        super.run();
        this.velocity.y = SPEED;
        this.velocity.x = 0;
    }
}
