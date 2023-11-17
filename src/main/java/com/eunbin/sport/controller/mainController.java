package com.eunbin.sport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eunbin.sport.service.GalleryService;
import com.eunbin.sport.vo.ClassItems;
import com.eunbin.sport.vo.GalleryItems;
import com.eunbin.sport.vo.SculptureItems;

@RestController
public class mainController {

    @Autowired
    GalleryService galleryService;

    @GetMapping("/main")
    public String test(){
        return "test";
    }
    
    // 미술관 전시정보 조회
    @GetMapping("/findDisplay")
    public GalleryItems findDisplay(
        @RequestParam(value = "pageNo")int pageNo, 
        @RequestParam(value = "numOfRows")int numOfRows){

        return galleryService.findDisplay(pageNo, numOfRows);
    }


    // 미술관 교육정보 조회
    @GetMapping("/findClass")
    public ClassItems findClass(
        @RequestParam(value = "pageNo")int pageNo, 
        @RequestParam(value = "numOfRows")int numOfRows){

        return galleryService.findClass(pageNo, numOfRows);
    }


    // 조각작품 정보 조회
    @GetMapping("/findSculpture")
    public SculptureItems findSculpture(
        @RequestParam(value = "pageNo")int pageNo, 
        @RequestParam(value = "numOfRows")int numOfRows){

        return galleryService.findSculpture(pageNo, numOfRows);
    }
}
