package com.picolab.Application;

import com.picolab.Application.DTO.CanvasDTO;
import com.picolab.Domain.Canvas;
import com.picolab.Persistance.BlankCanvasRepository;
import com.picolab.Persistance.CanvasRepository;
import com.picolab.util.InvalidParamException;
import com.picolab.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class CanvasController {

    @Autowired
    CanvasRepository canvasRepository;

    @Autowired
    BlankCanvasRepository blankCanvasRepository;

    public void createPlaceHolder(String url) throws InvalidParamException{
        clearCanvas();
        for (int i = 1; i < 51; i++) {
            String url1 = (url + i + ".jpg");
            Canvas canvas = new Canvas(url1);
            canvasRepository.save(canvas);
            blankCanvasRepository.save(canvas);
        }
    }

    public List<CanvasDTO> getAllCanvas() throws InvalidParamException {
        List<CanvasDTO> canvasDTOList = new ArrayList<>();
        for (Canvas canvas: canvasRepository.getAllCanvas()) {
            CanvasDTO canvasDTO = new CanvasDTO(canvas);
            canvasDTOList.add(canvasDTO);
        }
        return canvasDTOList;
    }

    public synchronized CanvasDTO getRandomCanvas() throws NotFoundException, InvalidParamException {
        List<Canvas> blankCanvasList = blankCanvasRepository.getAllCanvas();
        if (blankCanvasList.size() <= 0)
            blankCanvasList.addAll(canvasRepository.getAllCanvas());
        int index = new Random().nextInt(blankCanvasList.size());
        Canvas canvas = blankCanvasList.get(index);
        CanvasDTO canvasDTO = new CanvasDTO(canvas);
        blankCanvasList.remove(index);
        return canvasDTO;
    }

    public synchronized CanvasDTO updateCanvas(CanvasDTO canvasToUpdate) throws InvalidParamException {
        if (canvasToUpdate == null || canvasToUpdate.getUrl().equals(""))
            throw new InvalidParamException();
        Canvas canvas = canvasRepository.getCanvasById(canvasToUpdate.getId());
        canvas.setUrl(canvasToUpdate.getUrl());
        return new CanvasDTO(canvas);
    }

    public void clearCanvas(){
        canvasRepository.getAllCanvas().clear();
        blankCanvasRepository.getAllCanvas().clear();
    }
}
