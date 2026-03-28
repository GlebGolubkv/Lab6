package data;

import dataclasses.MusicBand;

import java.util.Hashtable;
import java.util.stream.Stream;


public class IDGenerator {

    public int generateNewID() {

        return ClassesManager.getInstance().getMap().values().stream()
                .map(e -> e.getId())
                .max((a, b) -> (a - b)).orElse(0) + 1;

    }
}
