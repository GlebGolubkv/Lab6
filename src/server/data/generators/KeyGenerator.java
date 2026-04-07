package server.data.generators;


import common.dataclasses.MusicBand;
import server.data.ClassesManager;

import java.util.Collections;
import java.util.Hashtable;


public class KeyGenerator {

    public int generateNewKey() {


        Hashtable<Integer, MusicBand> Map =  ClassesManager.getInstance().getMap();

        return Collections.max(Map.keySet()) + 1;
    }


}
