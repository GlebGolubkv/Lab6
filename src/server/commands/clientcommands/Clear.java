package server.commands.clientcommands;


import server.commands.Command;
import server.data.ClassesManager;
import common.dataclasses.MusicBand;
import common.Response;
import common.dataclasses.Colors;
import server.postgres.CommandsDAO;

public class Clear extends Command {
    @Override
    public Response execute(int client_id) {
        if (CommandsDAO.clearMusicBands()){
            ClassesManager.getInstance().clearCollection();

            StringBuilder stringBuilder = new StringBuilder().append(Colors.GREEN + "Collection cleared" + Colors.RESET);

            return new Response(true, "Clear successfully completed.", stringBuilder);
        }  else {
            return new Response(false, "Clear failed");
        }


    }

    @Override
    public Response execute(String value1, int client_id) {
        throw new IllegalArgumentException("Not supported");
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
        return "очистить коллекцию";
    }
}
