package com.space.definedEnum;

/*预定状态枚举*/
public enum PlanOrderStatus {
    正常("正常", 100), 已开台("已开台", 101),
    已下单("已下单", 102),
    已完成("已完成", 103),
    过期取消("过期取消", 201),
    撤销开台取消("撤销开台取消", 202),
    商家取消("商家取消", 203);

    private String name;
    private int index;

    // 构造方法
    private PlanOrderStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static int getIndex(String name) {
        for (PlanOrderStatus item : PlanOrderStatus.values()) {
            if (item.getName() == name) {
                return item.index;
            }
        }
        return 0;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

