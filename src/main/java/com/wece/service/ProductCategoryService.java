package com.wece.service;

import com.wece.entity.ProductCategory;

import java.util.List;

/**
 * sell
 * com.wece.service
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
public interface ProductCategoryService {

    ProductCategory findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
