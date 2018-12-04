package com.wece.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sell
 * com.wece.entity
 * Created by liaowj on 2018/11/30.
 * Description:
 *
 * @version 1.0
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /* 名称 */
    private String productName;

    /* 单价 */
    private BigDecimal productPrice;

    /* 库存 */
    private Integer productStock;

    /* 描述 */
    private String productDescription;

    /* 小图 */
    private String productIcon;

    /* 状态 0正常 ，1下架*/
    private Integer productStatus;

    /* 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductInfo() {
    }
}
