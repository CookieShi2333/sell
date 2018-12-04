package com.wece.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * sell
 * com.wece.model
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Data
public class ProductInfoModel {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}

