package com.wece.repository;

import com.wece.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


/**
 * sell
 * com.wece.repository
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repo;


    @Test
    public void findOneTest(){
        ProductCategory productCategory = repo.findById(1).get();

        System.out.print(productCategory.toString());

    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱",3);
        ProductCategory result = repo.save(productCategory);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repo.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}