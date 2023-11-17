package com.eunbin.sport.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassItem {
    
    @JsonProperty("clss_end_ymd")
    String clss_end_ymd;

    @JsonProperty("sim_txt_cn")
    String sim_txt_cn;
    
    @JsonProperty("let_txt_cn")
    String let_txt_cn;
    
    @JsonProperty("place_nm")
    String place_nm;
    
    @JsonProperty("clss_mbr_cd_nm")
    String clss_mbr_cd_nm;
    
    @JsonProperty("clss_st_ymd")
    String clss_st_ymd;
    
    @JsonProperty("rcv_c_cd_nm")
    String rcv_c_cd_nm;
    
    @JsonProperty("item_url")
    String item_url;
    
    @JsonProperty("clss_c_nm")
    String clss_c_nm;
    
    @JsonProperty("clss_nm")
    String clss_nm;
    
    @JsonProperty("clss_c_cd_nm")
    String clss_c_cd_nm;
}
