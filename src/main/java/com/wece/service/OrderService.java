package com.wece.service;

import com.wece.dto.OrderDTO;
import com.wece.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * sell
 * com.wece.service
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
public interface OrderService {

    /* 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /* 查询单个订单 */
   // OrderDTO findOne(String OrderId);

    OrderDTO findByOrderIdAndBuyerOpenid(String orderId, String buyerOpenid);

    /* 查询订单列表 */
    Page<OrderDTO> findList(String BuyerOpenid, Pageable pageable);

    /* 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /* 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /* 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
