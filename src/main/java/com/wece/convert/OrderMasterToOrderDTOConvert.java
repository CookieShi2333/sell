package com.wece.convert;

import com.wece.dto.OrderDTO;
import com.wece.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * sell
 * com.wece.convert
 * Created by liaowj on 2018/12/21.
 * Description:
 *
 * @version 1.0
 */
public class OrderMasterToOrderDTOConvert {

    private OrderMasterToOrderDTOConvert() {
        throw new IllegalAccessError();
    }

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        List<OrderDTO> orderDTOList = orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
        return orderDTOList;
    }
}
