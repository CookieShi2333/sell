package com.wece;

import com.wece.enums.ResultEnum;

/**
 * sell
 * com.wece
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
public class SellException extends RuntimeException {


    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message ) {
        super(message);
        this.code = code;
    }

}
