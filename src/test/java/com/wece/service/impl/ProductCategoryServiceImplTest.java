package com.wece.service.impl;

import com.wece.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findById() throws Exception {
        ProductCategory result = productCategoryService.findById(1);
        Assert.assertEquals(new Integer(1),result.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result =productCategoryService.findAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryIn() throws Exception {
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 3, 4));
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory result = productCategoryService.save(new ProductCategory("男生最爱", 6));
        Assert.assertNotNull(result);

    }

}