package game.scenes.scenelvl4;

import bases.GameObject;
import game.players.playerblue.PlayerBlue;

public class SceneLvl4Blue extends SceneLvl4{
    PlayerBlue player = new PlayerBlue();
    @Override
    public void init() {

        GameObject.add(player);
        super.init();
    }
}