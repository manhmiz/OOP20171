package maps;

import bases.GameObject;
import javafx.application.Platform;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    public void generate() {
        for (int titleY = 0; titleY < height; titleY ++){
            for (int titleX = 0; titleX < width; titleX ++){
                int mapData = data.get(titleY*width + titleX);
                if (mapData != 0){
                    Tree tree = new Tree();
                    tree.position.set(titleX*19,titleY*19);
                    GameObject.add(tree);
                }
            }
        }
    }
}
