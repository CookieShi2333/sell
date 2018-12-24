package com.wece.repository;

import com.wece.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository ;


    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("001");
        orderMaster.setBuyerName("zhangsan");
        orderMaster.setBuyerPhone("110");
        orderMaster.setBuyerAddress("广东深圳");
        orderMaster.setBuyerOpenid("open123");
        orderMaster.setOrderAmount(new BigDecimal(20));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {

    }

}