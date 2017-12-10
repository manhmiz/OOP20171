package maps;

import bases.utils.Utils;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Map {
    private List<Layer> layers;
    public void generate(){
        if (layers.size() > 0 ){
            Layer layer = layers.get(0);
            layer.generate();
        }
    }
    public static Map load(String url){
        String mapContent = Utils.readTextFile(url);
        Gson gson = new Gson();
        return gson.fromJson(mapContent, Map.class);
    }

}
