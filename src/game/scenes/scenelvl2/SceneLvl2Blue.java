package game.scenes.scenelvl2;

import bases.GameObject;
import game.players.playerblue.PlayerBlue;

public class SceneLvl2Blue extends SceneLvl2{
    PlayerBlue player = new PlayerBlue();
    @Override
    public void init() {

        GameObject.add(player);
        super.init();
    }
}
