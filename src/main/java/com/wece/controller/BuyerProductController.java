package com.wece.controller;

import com.wece.entity.ProductCategory;
import com.wece.entity.ProductInfo;
import com.wece.model.ProductInfoModel;
import com.wece.model.ProductModel;
import com.wece.model.ResultModel;
import com.wece.service.impl.ProductCategoryServiceImpl;
import com.wece.service.impl.ProductInfoServiceImpl;
import com.wece.utils.ResultModelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * sell
 * com.wece.controller
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;



    @GetMapping("/list")
    public ResultModel list() {

        //所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();


        //商品类目
        //java8   lambda
        List<Integer> CategoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(CategoryTypeList);

        //数据拼接
        List<ProductModel> productModelList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductModel productModel = new ProductModel();
            productModel.setCategoryName(productCategory.getCategoryName());
            productModel.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoModel> productInfoModelList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoModel productInfoModel = new ProductInfoModel();
                    BeanUtils.copyProperties(productInfo,productInfoModel);
                    productInfoModelList.add(productInfoModel);
                }
            }

            productModel.setProductInfoModelList(productInfoModelList);
            productModelList.add(productModel);
        }

        return ResultModelUtil.success(productModelList);

    }
}
