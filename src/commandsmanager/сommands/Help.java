package commandsmanager.сommands;

import commandsmanager.Command;
import data.DataCommands;
import dataclasses.MusicBand;
import termenalmanager.Colors;

import java.util.stream.Stream;

public class Help extends Command {

    public Help() {
    }


    @Override
    public void execute() {

        System.out.println();
        System.out.println(Colors.GREEN + "Commands: " + Colors.RESET);
        DataCommands.getInstance().getNames().stream()
                .sorted((a, b) -> b.length() - a.length())
                .forEach(name -> System.out.println(Colors.WHITE + "Command: " + Colors.GREEN
                        + name +
                        " : " + Colors.RESET
                        + DataCommands.getInstance().getCommand(name).commandInfo()));
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
        return "вывести справку по доступным командам";
    }

}
