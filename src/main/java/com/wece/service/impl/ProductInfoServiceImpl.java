package com.wece.service.impl;

import com.wece.SellException;
import com.wece.dto.CartDTO;
import com.wece.entity.ProductInfo;
import com.wece.enums.ProductStatusEnum;
import com.wece.enums.ResultEnum;
import com.wece.repository.ProductInfoRepository;
import com.wece.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * sell
 * com.wece.service.impl
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findById(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer i = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (i < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(i);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer i = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(i);
            repository.save(productInfo);

        }
    }
}
