package game.enemies;

public class RightBullet extends EnemyBullet{
    @Override
    public void run() {
        super.run();
        this.velocity.x = SPEED;
        this.velocity.y = 0;
    }
}
