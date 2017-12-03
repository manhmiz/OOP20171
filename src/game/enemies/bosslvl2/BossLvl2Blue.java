package game.enemies.bosslvl2;

import bases.scenes.SceneManager;
import game.enemies.Enemy;
import game.scenes.GameWinScene;

public class BossLvl2Blue extends Enemy{
    @Override
    public void getHit() {
        super.getHit();
        SceneManager.changeScene(new GameWinScene());
    }
}
