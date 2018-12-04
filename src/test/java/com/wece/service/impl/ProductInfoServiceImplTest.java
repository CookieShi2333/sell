package com.wece.service.impl;

import com.wece.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * sell
 * com.wece.service.impl
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findById() throws Exception {
        ProductInfo productInfo = productInfoService.findById("000001");
        Assert.assertEquals("000001",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> infoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,infoList.size());

    }

    @Test
    public void findAll() throws Exception {
        PageRequest qPageRequest = new PageRequest(0, 2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(qPageRequest);
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("000001");
        productInfo.setProductName("白粥");
        productInfo.setProductPrice(new BigDecimal(2));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("养生首选，好喝不贵！");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo productInfo1 = productInfoService.save(productInfo);

        Assert.assertNotNull(productInfo1);

    }

}