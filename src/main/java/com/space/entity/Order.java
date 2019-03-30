package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String orderNo;
    //订单名称
    private String orderName;
    //订单价格 订单金额 最终结算金额（应收金额-应收金额*折扣-优惠劵金额）
    private Double orderPrice;
    //订单应收账
    private Double orderOriginalAmount;
    //订单实际收账
    private Double orderActualAmount;
    //订单找零
    private Double orderGiveAmount;
    //优惠券编号
    private String orderSecuritiesNo;
    //订单折扣
    private String orderDiscount;
    //优惠券金额
    private Double orderSecuritiesAmount;
    //桌位费用
    private Double orderSeatAmount;

    //订单服务员ID
    private Integer orderWaiterId;
    //订单用户名称
    private String orderUser;
    //订单人数
    private Integer  orderPeopleNum;
    //订单桌位 台号
    private String orderSeat;
    //订单用户手机号
    private String orderUserPhone;
    //订单佣金
    private Double orderCommission;
    //返佣状态 1-未返佣  2-已返佣  3-返佣失败
    private Integer   orderReturnStatus;

    //订单类型
    private Integer orderType;
    //订单创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date orderDate;
    //到店开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date orderReachStartDate;
    //到店结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date orderReachEndDate;
    //订单状态，0-待付款  1-待服务 2-已服务 3-已完成 4-已关闭  105-退款中  106-退款成功 107-退款失败
    private Integer orderStatus;
    //拼吧订单参与人 暂定逗号分隔 “张三,李四”
    private String joinUser;
    //拼吧费用方式比如 AA等之类
    private String   joinUserAmountMethod;
    //拼吧订单参与人 暂定逗号分隔 “张三,李四”
    private String joinUserPhone;
    //签单人用户ID
    private Integer signerId;
    //订单支付类型
    //1.人民币
    //2.微信
    //3.支护宝
    //4.刷卡
    //5.挂账 等同于签单操作
    private Integer payMethod;
    //支付流水号
    private String  paymentNumber;
    //付款时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date     paymentTime;
    //流水更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date modifyDate;

    /*   结果返回字段 不用于数据库字段*/
    //订单商品详情数据
    public List<ShopOrderProductDetail> orderProductDetails;
    // 签单人名称
    public String signer;
    //服务员名称
    public String orderWaiterName;
    //订单状态
    public String OrderStatusStr;

    private List<OrderProduct> orderProductList;


}
