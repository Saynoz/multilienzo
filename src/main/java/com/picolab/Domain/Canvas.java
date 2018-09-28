package com.picolab.Domain;

import com.picolab.util.InvalidParamException;

public class Canvas {

    private Integer id;
    private String url;

    public Canvas(){}

    public Canvas(String url) throws InvalidParamException {
        if (url == null || url.equals(""))
            throw new InvalidParamException();

        this.url = url;
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
