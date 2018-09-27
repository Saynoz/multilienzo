package com.picolab.Persistance;

import com.picolab.Domain.Canvas;
import com.picolab.util.InvalidParamException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlankCanvasRepository {

    private static List<Canvas> canvasList = new ArrayList<>();

    public BlankCanvasRepository(){}

    public void save(Canvas canvas) throws InvalidParamException {
        if (canvas == null || canvasExistById(canvas.getId()))
            throw new InvalidParamException();
        canvasList.add(canvas);
    }

    public boolean canvasExistById(int canvasId) throws InvalidParamException {
        if (canvasId <= 0)
            throw new InvalidParamException();
        for (Canvas canvas : canvasList) {
            if (canvas.getId() == canvasId)
                return true;
        }
        return false;
    }

    public List<Canvas> getAllCanvas(){
        return canvasList;
    }
}
