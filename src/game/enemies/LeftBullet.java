package game.enemies;

public class LeftBullet extends EnemyBullet{
    @Override
    public void run() {
        super.run();
        this.velocity.x = -SPEED;
        this.velocity.y = 0;
    }
}
