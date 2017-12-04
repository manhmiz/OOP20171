package game.scenes.scenelvl3;

import bases.GameObject;
import game.players.playerblue.PlayerBlue;

public class SceneLvl3Blue extends SceneLvl3{

    PlayerBlue player = new PlayerBlue();
    @Override
    public void init() {

        GameObject.add(player);
        super.init();
    }
}
