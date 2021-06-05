package cn.jdl.ecology.juc.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 汽车位置 -- 修改为不可变类
 * @Author zhaokai108
 * @Date 2021/6/5 12:12
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public final class FLocation {  //防止子类做破坏

    private final List<Integer> data = new ArrayList<>();

    private final double x;

    private final double y;

    public FLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    /**
     * 功能：防御性复制
     *
     * @param 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/5 12:38
     */
    public List<Integer> getData() {
        return Collections.unmodifiableList(new ArrayList<>(data));
    }

}
