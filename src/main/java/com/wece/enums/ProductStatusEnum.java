package com.wece.enums;

import lombok.Getter;

/**
 * sell
 * com.wece.enums
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
