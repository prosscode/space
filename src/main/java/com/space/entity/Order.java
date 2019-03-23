package com.space.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @describe: 订单
 * @author: 彭爽pross
 * @date: 2019/03/16
 */
@Data
public class Order {

    //订单自增id
    private Integer orderId;
    //商户ID
    private Integer shopId;
    //订单号
    private  String orderNo;
    //订单名称
    private String orderName;
    //订单价格
    private Double orderPrice;
    //订单服务员ID
    private Integer orderWaiterId;
    //订单用户名称
    private String orderUser;
    //订单桌位 台号
    private String orderSeat;
    //订单用户手机号
    private String orderUserPhone;
    //订单佣金
    private Double orderCommission;
    //订单类型
    private Integer orderType;
    //订单创建时间
    private Date orderDate;
    //订单状态，0-待付款  1-待服务 2-已服务 3-已完成 4-已关闭  105-退款中  106-退款成功 107-退款失败
    private Integer orderStatus;
    //拼吧订单参与人 暂定逗号分隔 “张三,李四”
    private  String joinUser;
    //签单人用户ID
    private  Integer signerId;
    //订单支付类型
    //1.人民币
    //2.微信
    //3.支护宝
    //4.刷卡
    //5.挂账 等同于签单操作
    private  Integer payMethod;
    //流水更新时间
    private Date  modifyDate;
    //到店开始时间
    private Date orderReachStartDate;
    //到店结束时间
    private Date orderReachEndDate;

    //返回订单商品
    private List<OrderProduct> orderProductList;

 /*   结果返回字段 不用于数据库字段*/
    // 签单人名称
    public String signer;
    //服务员名称
    public  String orderWaiterName;
    //订单状态
    public  String OrderStatusStr;


}
