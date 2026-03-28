package commandsmanager.сommands;

import commandsmanager.Command;
import data.ClassesManager;
import dataclasses.MusicBand;
import termenalmanager.BandsInputTerminal;
import termenalmanager.Colors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveLower extends Command {
    @Override
    public void execute() {

        MusicBand inputMusicBand = BandsInputTerminal.getInstance().inputBand(new Scanner(System.in));

        List<String> collect = ClassesManager.getInstance().getMap().keySet()
                .stream()
                .filter(e -> inputMusicBand.compareTo(ClassesManager.getInstance().getMap().get(e)) > 0)
                .map(e -> String.valueOf(e))
                .toList();

        for (String key : collect) {
            new RemoveKey().execute(key);
        }


    }

    @Override
    public void execute(String value1) {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public void execute(String value1, MusicBand value2) {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public void execute(MusicBand value1) {

        List<String> collect = ClassesManager.getInstance().getMap().keySet()
                .stream()
                .filter(e -> value1.compareTo(ClassesManager.getInstance().getMap().get(e)) > 0)
                .map(e -> String.valueOf(e))
                .toList();

        for (String key : collect) {
            new RemoveKey().execute(key);
        }
    }

    @Override
    public String commandInfo() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
