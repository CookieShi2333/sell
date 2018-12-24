package com.wece.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * sell
 * com.wece.dto
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
@Data
public class CartDTO {

    /* 商品ID */
    private String productId;

    /* 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
