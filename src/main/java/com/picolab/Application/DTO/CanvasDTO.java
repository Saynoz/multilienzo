package com.picolab.Application.DTO;

import com.google.gson.annotations.Expose;
import com.picolab.Domain.Canvas;
import com.picolab.util.InvalidParamException;

public class CanvasDTO {

    @Expose
    private int id;
    @Expose
    private String url;

    public CanvasDTO(){}

    public CanvasDTO(Canvas canvas) throws InvalidParamException {
        if (canvas == null)
            throw new InvalidParamException();

        this.id = canvas.getId();
        this.url = canvas.getUrl();
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
