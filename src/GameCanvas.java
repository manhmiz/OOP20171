import bases.GameObject;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;
import touhou.players.Player;
import touhou.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;

    BackGround backGround = new BackGround();
    Player player = new Player();



    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(384, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        GameObject.add(player);
        GameObject.add(new EnemySpawner());
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

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);


    }

    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }

    public void run() {
        GameObject.runAll();
        backGround.run();
    }

}
