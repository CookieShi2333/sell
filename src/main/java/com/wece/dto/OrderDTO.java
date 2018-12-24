package com.wece.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wece.entity.OrderDetail;
import com.wece.serializer.DateToLongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * sell
 * com.wece.dto
 * Created by liaowj on 2018/12/20.
 * Description:
 *
 * @version 1.0
 */
@Data
public class OrderDTO {

    @Id
    private String orderId;

    /* 买家名字 */
    private String buyerName;

    /* 买家电话 */
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAddress;

    /* 买家微信openid*/
    private String buyerOpenid;

    /* 订单总金额 */
    private BigDecimal orderAmount;

    /* 订单状态 默认0新下单 */
    private Integer orderStatus;

    /* 支付状态 默认0未支付*/
    private Integer payStatus;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    List<OrderDetail> OrderDetailList;
}
