package game.enemies;

public class UpBullet extends EnemyBullet{
    @Override
    public void run() {
        super.run();
        this.velocity.y = -SPEED;
        this.velocity.x = 0;
    }
}
