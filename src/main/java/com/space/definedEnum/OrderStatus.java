package com.space.definedEnum;
/*订单状态枚举*/
public enum OrderStatus {
    待付款("待付款", 0),
    待服务("待服务", 1),
    已服务("已服务", 2),
    已完成("已完成", 3),
    已关闭("已关闭", 4),
    退款中("退款中", 105),
    退款成功("退款成功", 106),
    退款失败("退款失败", 107);

    private String name;
    private int index;

    // 构造方法
    private OrderStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static int getIndex(String name) {
        for (OrderStatus item : OrderStatus.values()) {
            if (item.getName() == name) {
                return item.index;
            }
        }
        return 0;
    }

    // 普通方法
    public static String getName(int index) {
        for (OrderStatus item : OrderStatus.values()) {
            if (item.getIndex() == index) {
                return item.name;
            }
        }
        return "";
    }

    // get set 方法
    public String getName() {
        return name;
    }

    // get set 方法
    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }
}
