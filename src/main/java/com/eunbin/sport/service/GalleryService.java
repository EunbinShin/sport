package com.eunbin.sport.service;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import com.eunbin.sport.vo.ClassItem;
import com.eunbin.sport.vo.ClassItems;
import com.eunbin.sport.vo.GalleryItem;
import com.eunbin.sport.vo.GalleryItems;
import com.eunbin.sport.vo.SculptureItems;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class GalleryService {

    String ApiKey = "XyJfo/A0MQHOntHGIE3dxaJZyxQLx4g%2B/NQKLAxQ9VoRw6anY1%2BglathdfvSVSPJi8hnTKzXzSfJvlZVk6kn7g==";

    public GalleryItems findDisplay(int pageNo, int numOfRows){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://apis.data.go.kr/B551014/SRVC_OD_API_RESERVE_TOUR");
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                                .uriBuilderFactory(factory)
                                .build();
                        
        String response = webClient.get()
                                    .uri(uriBuilder ->
                                            uriBuilder.path("/todz_api_display_i")
                                                .queryParam("serviceKey", ApiKey)
                                                .queryParam("pageNo", pageNo)
                                                .queryParam("numOfRows", numOfRows)
                                                .queryParam("resultType", "json")
                                                .build())
                                    .retrieve()
                                    .bodyToMono(String.class)
                                    .block();

        GalleryItems result = new GalleryItems(new ArrayList<>());

        try {
            ObjectMapper mapper = new ObjectMapper();
            GalleryItems items = mapper.readValue(response, GalleryItems.class);

            for(GalleryItem item : items.getGalleryItems()) {
                if(!item.getDspy_state_nm().equals("종료"))
                    result.getGalleryItems().add(item);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
               
        

        return result;
                                       
    }


    public ClassItems findClass(int pageNo, int numOfRows){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://apis.data.go.kr/B551014/SRVC_OD_API_EDCN_CLASS");
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                                .uriBuilderFactory(factory)
                                .build();
                        
        String response = webClient.get()
                                    .uri(uriBuilder ->
                                            uriBuilder.path("/TODZ_API_EDCN_CLASS_NEW_I")
                                                .queryParam("serviceKey", ApiKey)
                                                .queryParam("pageNo", pageNo)
                                                .queryParam("numOfRows", numOfRows)
                                                .queryParam("resultType", "json")
                                                .build())
                                    .retrieve()
                                    .bodyToMono(String.class)
                                    .block();

        
        ClassItems result = new ClassItems(new ArrayList<>());

        try {
            ObjectMapper mapper = new ObjectMapper();
            ClassItems items = mapper.readValue(response, ClassItems.class);

            for(ClassItem item : items.getClassItems()) {
                result.getClassItems().add(item);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
               
        return result;
                                       
    }

    public SculptureItems findSculpture(int pageNo, int numOfRows){
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://apis.data.go.kr/B551014/SRVC_OD_API_SOMA_WORK_INFO");
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                                .uriBuilderFactory(factory)
                                .build();
                        
        String response = webClient.get()
                                    .uri(uriBuilder ->
                                            uriBuilder.path("/todz_api_soma_work_info_i")
                                                .queryParam("serviceKey", ApiKey)
                                                .queryParam("pageNo", pageNo)
                                                .queryParam("numOfRows", numOfRows)
                                                .queryParam("resultType", "json")
                                                .build())
                                    .retrieve()
                                    .bodyToMono(String.class)
                                    .block();

        SculptureItems result = new SculptureItems(new ArrayList<>());

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(response, SculptureItems.class);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
                                       
    }


}