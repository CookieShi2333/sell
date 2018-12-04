package com.wece.repository;

import com.wece.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * sell
 * com.wece.repository
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);


}
