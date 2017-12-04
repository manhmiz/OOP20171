package game.scenes.scenelvl1;

import bases.GameObject;
import bases.scenes.SceneManager;
import game.players.playerblue.PlayerBlue;
import game.scenes.scenelvl2.SceneLvl2Blue;

public class SceneLvl1Blue extends SceneLvl1{
    PlayerBlue playerBlue = new PlayerBlue();

    @Override
    public void init() {

        GameObject.add(playerBlue);
        super.init();
    }
}
