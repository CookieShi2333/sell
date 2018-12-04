package com.wece.service;

import com.wece.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * sell
 * com.wece.service
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
public interface ProductInfoService {

    ProductInfo findById(String productId);


    /**
     * 查询所有上架的商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存



}
