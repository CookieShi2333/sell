package com.wece.model;

import lombok.Data;

/**
 * http请求的最外层对象
 * com.wece.model
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Data
public class ResultModel<T> {

    /* 错误码 */
    private Integer code;

    /* 提示信息 */
    private String msg;

    /* 具体内容*/
    private T data;
}
