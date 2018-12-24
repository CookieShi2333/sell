package com.wece.service.impl;

import com.wece.dto.OrderDTO;
import com.wece.entity.OrderDetail;
import com.wece.enums.OrderStatusEnum;
import com.wece.enums.PayStatusEnum;
import com.wece.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * sell
 * com.wece.service.impl
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderServiceImplTest {

    private final String OPENID = "111222";
    private final String ORDER_ID = "1545358952704906794";

    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerAddress("深圳福田");
        orderDTO.setBuyerPhone("1234455566");
        orderDTO.setBuyerOpenid(OPENID);

        ArrayList<OrderDetail> list = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("000001");
        orderDetail.setProductQuantity(2);
        list.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("000002");
        orderDetail2.setProductQuantity(5);
        list.add(orderDetail2);

        orderDTO.setOrderDetailList(list);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询订单] result={}",result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());

    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<OrderDTO> result = orderService.findList(OPENID, pageRequest);
        log.info("[查询订单列表] result={}",result);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    @Transactional
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

}