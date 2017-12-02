import bases.GameObject;
import game.BackGround;
import game.enemies.Enemy;
import game.players.Player;
import game.scenes.ScenceLvl1;
import maps.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//import game.players.Sphere;
//import game.players.Sphere2;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;

    BackGround backGround = new BackGround();

    ScenceLvl1 scenceLvl1;


    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();

        scenceLvl1 = new ScenceLvl1();
        scenceLvl1.init();

    }

    public void render() {
        //1.Draw everything on back buffer
        backGround.render(backGraphics);
        GameObject.renderAll(backGraphics);
        //2. Call repaint
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }


    public void run() {
        GameObject.runAll();
        backGround.run();
    }

}
