import bases.GameObject;
import touhou.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;

    BackGround backGround = new BackGround();
    Player player = new Player();
    Enemy enemy = new Enemy();
    EnemyBullet bullet = new EnemyBullet();



    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(384, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        GameObject.add(backGround);
        GameObject.add(player);
        GameObject.add(enemy);
        GameObject.add(bullet);
    }

    public void render() {
        //1.Draw everything on back buffer

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
    }

}
