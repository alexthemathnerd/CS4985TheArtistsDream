package edu.westga.devops.theartistsdreamserver.model;

import edu.westga.devops.theartistsdreamserver.TheArtistsDreamServer;
import edu.westga.devops.theartistsdreamserver.utils.UI;

public class Response {

    private UI.ServerCodes code;
    private Object data;

    public Response(UI.ServerCodes code, Object data) {
        if (code == null) {
            throw new IllegalArgumentException(UI.ErrorMessages.CODE_NULL);
        }
        this.code = code;
        this.data = data;
    }

    public Request execute() {
        TheArtistsDreamServer.LOGGER.info("Executing server action: " + this.code.name());
        return this.code.execute(this.data);
    }

    public UI.ServerCodes getCode() {
        return this.code;
    }

    public Object getData() {
        return this.data;
    }
}
