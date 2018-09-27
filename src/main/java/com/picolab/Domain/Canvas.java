package com.picolab.Domain;

import com.picolab.util.InvalidParamException;

public class Canvas {

    private Integer id;
    private String url;
    private static int COUNTER = 1;

    public Canvas(){}

    public Canvas(String url) throws InvalidParamException {
        if (url == null || url.equals(""))
            throw new InvalidParamException();

        this.url = url;
        this.id = COUNTER;
        ++COUNTER;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
