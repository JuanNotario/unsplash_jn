package com.controller;

import com.interfaces.UnsplashService;
import com.service.odto.ListCollectionDataOdto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class UnsplashController {

    private UnsplashService unsplashService;

    @ResponseBody
    @RequestMapping(value = {"/collections/all", "/collections/{filter}"}, method=RequestMethod.GET, produces = "application/json")
    public ListCollectionDataOdto getCollectionUnsplash(@PathVariable(required = false) String filter) {
        return unsplashService.getCollectionMovie(filter);
    }
}
