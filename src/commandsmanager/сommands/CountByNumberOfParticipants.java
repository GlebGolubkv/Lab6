package commandsmanager.сommands;

import commandsmanager.Command;
import data.ClassesManager;
import dataclasses.MusicBand;
import termenalmanager.Colors;

public class CountByNumberOfParticipants extends Command {
    @Override
    public void execute() {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public void execute(String value1) {
        ClassesManager classesManager = ClassesManager.getInstance();
        int number_of_participants = checkInteger(value1);


        long result = classesManager.getMap().keySet().stream()
                //Превратили в список значений numberOfParticipants
                .map(e -> classesManager.getMap().get(e).getNumberOfParticipants())
                // Отфильтровали совпадающие
                .filter(e -> e == number_of_participants).count();



        System.out.println();
        System.out.println("The number participants of equal " + Colors.GREEN + number_of_participants + Colors.RESET +
                "s is " + Colors.GREEN + result + Colors.RESET);
        System.out.println();

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
        return "вывести количество элементов, значение поля numberOfParticipants которых равно заданному";
    }

    private int checkInteger(String key) {
        int newKey;
        // если не является числом
        try {
            newKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Must be an integer");
        }
        return newKey;
    }
}
