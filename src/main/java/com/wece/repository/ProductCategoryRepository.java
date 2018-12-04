package com.wece.repository;

import com.wece.entity.ProductCategory;
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
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
