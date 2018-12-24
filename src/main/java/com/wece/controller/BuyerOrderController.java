package com.wece.controller;

import com.wece.SellException;
import com.wece.convert.OrderFormToOrderDTOConvert;
import com.wece.dto.OrderDTO;
import com.wece.enums.ResultEnum;
import com.wece.form.OrderForm;
import com.wece.model.ResultModel;
import com.wece.service.OrderService;
import com.wece.utils.ResultModelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * sell
 * com.wece.controller
 * Created by liaowj on 2018/12/24.
 * Description:
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /* 创建订单 */
    @PostMapping("/create")
    public ResultModel<Map<String, String>> create(@Valid OrderForm orderForm,
                                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数错误, orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),ResultEnum.PARAM_ERROR.getMessage());
        }

        OrderDTO orderDTO = OrderFormToOrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车为空, orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("openid", createResult.getBuyerOpenid());

        return ResultModelUtil.success(map);

    }


    /* 订单列表 */
    @GetMapping("/list")
    public ResultModel<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                            @RequestParam(value = "page",defaultValue = "0") Integer page,
                                            @RequestParam(value = "size",defaultValue = "10") Integer size) {

        if (StringUtils.isEmpty(openid)) {
            log.error("【订单列表】参数错误, openid={}",openid);
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        return ResultModelUtil.success(orderDTOPage.getContent());


    }


    /* 订单详细 */

    /* 取消订单 */
}
