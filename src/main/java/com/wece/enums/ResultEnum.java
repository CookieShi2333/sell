package com.wece.enums;

import lombok.Getter;

/**
 * sell
 * com.wece.enums
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不足"),
    ORDER_MASTER_NOT_EXIST(12,"订单不存在"),
    ORDER_DETAIL_NOT_EXIST(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态错误"),
    ORDER_UPDATE_FAIL(15,"订单更新失败"),
    ORDER_PAY_STATUS_ERROR(16,"订单支付状态错误")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
