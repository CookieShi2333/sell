package com.wece.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 * com.wece.model
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Data
public class ProductModel {

    /* 类目名称 */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoModel> productInfoModelList;


}
