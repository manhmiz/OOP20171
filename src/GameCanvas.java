import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage backBuffer;
    Graphics backGraphics;

    int playerX = 182;
    int playerY = 500;
    int backgroundY = -2500;

    boolean rightPressed;
    boolean leftPressed;
    boolean downPressed;
    boolean upPressed;

    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 350;
    final int TOP = 0;
    final int BOTTOM = 530;


    public GameCanvas() {
        //1. Create back buffer
        backBuffer = new BufferedImage(384, 600, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBuffer.getGraphics();
        //2.Load BackGround
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render() {
        //1.Draw everything on back buffer
        backGraphics.drawImage(background, 0, backgroundY, null);
        backGraphics.drawImage(player, playerX, playerY, null);
        //2. Call repaint
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }

    public void run() {

        int vx = 0;
        int vy = 0;

        if (rightPressed) {
                vx += SPEED;
        }
        if (leftPressed) {
                vx -= SPEED;
        }
        if (upPressed) {
                vy -= SPEED;
        }
        if (downPressed) {
                vy += SPEED;
        }

        playerX += vx;
        playerY += vy;

        playerX = (int)clamp(playerX, LEFT, RIGHT);
        playerY = (int)clamp(playerY, TOP, BOTTOM);

    }
    private float clamp(float value, float min, float max){
        if (value < min){
            return min;
        }
        if (value > max){
            return max;
        }
        return value;
    }
}
