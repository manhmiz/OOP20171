package game.enemies.bosslvl1;

import bases.scenes.SceneManager;
import game.enemies.Enemy;
import game.scenes.scenelvl2.SceneLvl2;
import game.scenes.scenelvl2.SceneLvl2Blue;

public class BossLvl1Blue extends Enemy {
    @Override
    public void getHit() {
        super.getHit();
        SceneManager.changeScene(new SceneLvl2Blue());
    }
}
