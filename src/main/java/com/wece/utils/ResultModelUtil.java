package com.wece.utils;


import com.wece.model.ResultModel;

public class ResultModelUtil {


    public static ResultModel success(Object o) {

        ResultModel<Object> resultModel = new ResultModel<>();
        resultModel.setData(o);
        resultModel.setCode(0);
        resultModel.setMsg("success");
        return  resultModel;

    }


    public static ResultModel success() {
        return success(null);
    }


    public static ResultModel fail(Integer code, String msg) {

        ResultModel<Object> resultModel = new ResultModel<>();
        resultModel.setCode(code);
        resultModel.setMsg(msg);
        return  resultModel;
    }

}
