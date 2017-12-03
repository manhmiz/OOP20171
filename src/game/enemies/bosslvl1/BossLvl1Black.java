package game.enemies.bosslvl1;

import bases.scenes.SceneManager;
import game.enemies.Enemy;
import game.scenes.scenelvl1.SceneLvl1Black;
import game.scenes.scenelvl2.SceneLvl2Black;

public class BossLvl1Black extends Enemy{
    @Override
    public void getHit() {
        super.getHit();
        SceneManager.changeScene(new SceneLvl2Black());
    }
}
