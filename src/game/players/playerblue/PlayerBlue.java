package game.players.playerblue;

import bases.GameObject;
import bases.scenes.SceneManager;
import game.finish.FinishLvl1;
import game.finish.FinishLvl2;
import game.finish.FinishLvl3;
import game.finish.FinishLvl4;
import game.players.Player;
import game.scenes.GameWinScene;
import game.scenes.scenelvl2.SceneLvl2Black;
import game.scenes.scenelvl2.SceneLvl2Blue;
import game.scenes.scenelvl3.SceneLvl3Blue;
import game.scenes.scenelvl4.SceneLvl4Black;
import game.scenes.scenelvl4.SceneLvl4Blue;

public class PlayerBlue extends Player {

    public BlueCastBullet castBullet;
    public BlueAnimator animator;

    public PlayerBlue(){
        this.castBullet = new BlueCastBullet();
        HP = 10;

        animator = new BlueAnimator();
        this.renderer = animator;
    }

    @Override
    public void run() {
        super.run();
        animator.run();
        this.castBullet.run(this);

        goToNextLevel();
    }

    private void goToNextLevel() {
        FinishLvl1 finishLvl1 = GameObject.collideWith(this.boxCollider,FinishLvl1.class);
        if (finishLvl1 != null){
            SceneManager.changeScene(new SceneLvl2Blue());
        }
        FinishLvl2 finishLvl2 = GameObject.collideWith(this.boxCollider,FinishLvl2.class);
        if (finishLvl2 != null){
            SceneManager.changeScene(new SceneLvl3Blue());
        }
        FinishLvl3 finishLvl3 = GameObject.collideWith(this.boxCollider,FinishLvl3.class);
        if (finishLvl3 != null){
            SceneManager.changeScene(new SceneLvl4Blue());
        }
        FinishLvl4 finishLvl4 = GameObject.collideWith(this.boxCollider,FinishLvl4.class);
        if (finishLvl4 != null){
            SceneManager.changeScene(new GameWinScene());
        }
    }

}
