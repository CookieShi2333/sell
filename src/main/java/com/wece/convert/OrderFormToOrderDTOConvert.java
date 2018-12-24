package com.wece.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wece.SellException;
import com.wece.dto.OrderDTO;
import com.wece.entity.OrderDetail;
import com.wece.enums.ResultEnum;
import com.wece.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * sell
 * com.wece.convert
 * Created by liaowj on 2018/12/24.
 * Description:
 *          OrderForm 转化为 OrderDTO
 * @version 1.0
 */
@Slf4j
public class OrderFormToOrderDTOConvert {

    private OrderFormToOrderDTOConvert() {
        throw new IllegalAccessError();
    }

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;


    }
}
