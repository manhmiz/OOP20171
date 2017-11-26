package maps;

import bases.GameObject;
import game.platforms.*;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    public void generate() {
        for (int titleY = 0; titleY < height; titleY ++){
            for (int titleX = 0; titleX < width; titleX ++){
                int mapData = data.get(titleY*width + titleX);
                switch (mapData){
                    case 4:
                        Brick brick = new Brick();
                        brick.position.set(titleX*19, titleY*19);
                        GameObject.add(brick);
                        break;
                    case 3:
                        Tree tree = new Tree();
                        tree.position.set(titleX*19, titleY*19);
                        GameObject.add(tree);
                        break;
                    case 2:
                        Water water = new Water();
                        water.position.set(titleX*19, titleY*19);
                        GameObject.add(water);
                        break;
                    case 1:
                        Rock rock = new Rock();
                        rock.position.set(titleX*19, titleY*19);
                        GameObject.add(rock);
                        break;
                }
            }
        }
    }
}
