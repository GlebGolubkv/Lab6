package server.commands.clientcommands;

import server.commands.Command;
import server.data.ClassesManager;

import common.dataclasses.MusicBand;
import common.Response;
import common.dataclasses.Colors;
import server.postgres.CommandsDAO;


public class RemoveKey extends Command {
    @Override
    public Response execute(int client_id) {
        throw new IllegalArgumentException("Not supported");

    }

    @Override
    public Response execute(String value1,int client_id) {
        int key = checkInteger(value1);
        ClassesManager cm = ClassesManager.getInstance();
        if (CommandsDAO.removeMusicBand(key)) {
            cm.removeMusicBandFromCollection(key);

            StringBuilder stringBuilder = new StringBuilder().append("Key " + Colors.GREEN + key + Colors.RESET + " removed");

            return new Response(true, "RemoveKey successfully completed.", stringBuilder);
        } else {

            throw new IllegalArgumentException("Invalid key. Key: " + key);

        }


    }

    @Override
    public Response execute(String value1, MusicBand value2,int client_id) {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public Response execute(MusicBand value1,int client_id) {
        throw new IllegalArgumentException("Not supported");
    }

    @Override
    public String commandInfo() {
        return "удалить элемент из коллекции по его ключу";
    }

    private int checkInteger(String key) {
        int newKey;

        try {
            newKey = Integer.parseInt(key);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Must be an integer");
        }
        return newKey;
    }
}
