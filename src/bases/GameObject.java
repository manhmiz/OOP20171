package bases;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public float x;
    public float y;
    public BufferedImage image;

    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newgameObjects = new Vector<>();
    public static void runAll(){
        for (GameObject gameObject: gameObjects){
            gameObject.run();
        }

        gameObjects.addAll(newgameObjects);
        newgameObjects.clear();
    }

    public static void renderAll(Graphics graphics){
        for (GameObject gameObject: gameObjects){
            gameObject.render(graphics);
        }
    }
    public static void add(GameObject gameObject){
        newgameObjects.add(gameObject);
    }

    public GameObject(){

    }

    public void run(){
    }

    public void render(Graphics graphics){
        if (image != null){
            graphics.drawImage(image,(int)x,(int)y,null);
        }
    }

}
