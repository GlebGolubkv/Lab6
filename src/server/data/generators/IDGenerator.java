package server.data.generators;


import common.dataclasses.MusicBand;
import server.data.ClassesManager;

public class IDGenerator {

    public int generateNewID() {

        return ClassesManager.getInstance().getMap().values().stream()
                .map(e -> e.getId())
                .max((a, b) -> (a - b)).orElse(0) + 1;

    }

    public MusicBand validateId(MusicBand musicBand) {

        if (musicBand != null && musicBand.getId() == 0) {
            musicBand.setId(new IDGenerator().generateNewID());
        }

        return musicBand;
    }

}
