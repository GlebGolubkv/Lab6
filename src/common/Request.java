package common;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.dataclasses.CommandType;
import common.dataclasses.MusicBand;

public class Request {
    private CommandType commandType;
    private String argument;
    private MusicBand musicBand;
    private int clientId;

    public Request() {
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public Request(CommandType commandType, String argument, MusicBand musicBand, int clientId) {
        this.commandType = commandType;
        this.argument = argument;
        this.musicBand = musicBand;
        this.clientId = clientId;
    }



    public String toJson() throws JsonProcessingException {
        return JsonDataMapper.getInstance().getMapper().writeValueAsString(this);
    }


    public static Request fromJson(String json) throws JsonProcessingException {
        return JsonDataMapper.getInstance().getMapper().readValue(json, Request.class);

    }

    public CommandType getCommandType() {
        return commandType;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }

    public String getArgument() {
        return argument;
    }

    public int getClientId() {
        return clientId;
    }
}