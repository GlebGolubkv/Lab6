package commandsmanager.сommands;

import commandsmanager.Command;
import data.ClassesManager;
import dataclasses.MusicBand;
import termenalmanager.Colors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class PrintFieldDescendingLabel extends Command {
    @Override
    public void execute() {

        System.out.print("Labels: ");
        ClassesManager.getInstance().getMap().keySet().stream()
                .map(e -> ClassesManager.getInstance().getMap().get(e).getLabel().getBands())
                .sorted((a, b) -> b - a)
                .forEach(e -> System.out.print(e + " "));

        System.out.println();


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
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public String commandInfo() {
        return "вывести значения поля label всех элементов в порядке убывания";
    }
}
