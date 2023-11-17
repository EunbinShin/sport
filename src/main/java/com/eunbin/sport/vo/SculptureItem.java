package com.eunbin.sport.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SculptureItem {
    
@JsonProperty("purchased_ymd")
String purchased_ymd;
  
  @JsonProperty("location_nm")
  String location_nm;
  
  @JsonProperty("artist_en_nm")
  String artist_en_nm;
  
  @JsonProperty("image_url")
  String image_url;
  
  @JsonProperty("title_en_nm")
  String title_en_nm;
  
  @JsonProperty("prdct_origin_nm")
  String prdct_origin_nm;
  
  @JsonProperty("title_ko_nm")
  String title_ko_nm;
  
  @JsonProperty("artist_ko_nm")
  String artist_ko_nm;

  @JsonProperty("nation_nm")
  String nation_nm;
  
  @JsonProperty("sclptr_sz")
  String sclptr_sz;

}
