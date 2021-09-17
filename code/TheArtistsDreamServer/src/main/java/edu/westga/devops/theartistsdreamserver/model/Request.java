package edu.westga.devops.theartistsdreamserver.model;

public class Request {

    private String error;
    private Object data;

    public Request(String error, Object data) {
        this.error = error;
        this.data = data;
    }

    public Request(String error) {
        this(error, null);
    }

    public Request(Object data) {
        this(null, data);
    }

    public String getError() {
	return this.error;
    }

    public Object getData() {
	return this.data;
    }
}
