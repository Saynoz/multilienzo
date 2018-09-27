package com.picolab.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.picolab.Application.CanvasController;
import com.picolab.Application.DTO.CanvasDTO;
import com.picolab.util.InvalidParamException;
import com.picolab.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CanvasRestController {

    @Autowired
    private CanvasController canvasController;

    private String toJson(Object object){

        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }

    @PostMapping(value = "/canvas", produces = "application/json;charset=UTF-8")
    public void generatePlaceHolder() throws InvalidParamException {

        canvasController.createPlaceHolder();
    }

    @GetMapping(value = "/canvas", produces = "application/json;charset=UTF-8")
    public String listCanvas() throws InvalidParamException {

        List<CanvasDTO> canvas = canvasController.getAllCanvas();

        return toJson(canvas);

    }

    @GetMapping(value = "/canvas/user", produces = "application/json;charset=UTF-8")
    public String getRandomCanvas() throws NotFoundException, InvalidParamException {

        CanvasDTO canvasDTO = canvasController.getRandomCanvas();

        return toJson(canvasDTO);
    }

    @PutMapping(value = "/canvas/user", produces = "application/json;charset=UTF-8")
    public String pushUserCanvas(@RequestBody String jCanvas) throws InvalidParamException {

        CanvasDTO canvasToUpdate = new Gson().fromJson(jCanvas, CanvasDTO.class);

        CanvasDTO canvas = canvasController.updateCanvas(canvasToUpdate);

        return toJson(canvas);

    }
}
