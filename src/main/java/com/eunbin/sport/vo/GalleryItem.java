package com.eunbin.sport.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GalleryItem {
    @JsonProperty("dspy_state_nm")
    String dspy_state_nm;
    
    @JsonProperty("dspy_image_nm")
    String dspy_image_nm;
    
    @JsonProperty("dspy_endde_ymd")
    String dspy_endde_ymd;
    
    @JsonProperty("dspy_nm")
    String dspy_nm;
    
    @JsonProperty("pavln_charst_nm")
    String pavln_charst_nm;
    
    @JsonProperty("row_num")
    String row_num;
    
    @JsonProperty("viewng_charst_cn")
    String viewng_charst_cn;
    
    @JsonProperty("reg_mngr_no")
    String reg_mngr_no;
    
    @JsonProperty("writer_nm")
    String writer_nm;
    
    @JsonProperty("dspy_image_url")
    String dspy_image_url;
    
    @JsonProperty("place_nm")
    String place_nm;
    
    @JsonProperty("prdct_nm")
    String prdct_nm;
    
    @JsonProperty("mnnst_nm")
    String mnnst_nm;
    
    @JsonProperty("time_charst_cn")
    String time_charst_cn;
    
    @JsonProperty("dspy_eng_nm")
    String dspy_eng_nm;
    
    @JsonProperty("dspy_bgnde_ymd")
    String dspy_bgnde_ymd;
}
