package touhou.enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject{

    FrameCounter frameCounter = new FrameCounter(120);
    Random random = new Random();
    @Override
    public void run(){
        if (frameCounter.run()){
            frameCounter.reset();
            spawm();
        }
    }

    private void spawm() {
        Enemy enemy = new Enemy();
        enemy.position.y = 10;
        enemy.position.x = random.nextInt(384);
        GameObject.add(enemy);
    }
}
