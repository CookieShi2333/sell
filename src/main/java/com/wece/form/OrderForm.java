package com.wece.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * sell
 * com.wece.form
 * Created by liaowj on 2018/12/24.
 * Description:
 *         表单验证
 * @version 1.0
 */
@Data
public class OrderForm {

    /* 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /* 买家电话 */
    @NotEmpty(message = "电话必填")
    private String phone;

    /* 买家地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /* 买家微信openid */
    @NotEmpty(message = "openid必填")
    private String openid;

    /* 购物车 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
