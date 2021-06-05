package cn.jdl.ecology.juc.cart;

/**
 * @Description: 汽车位置
 * @Author zhaokai108
 * @Date 2021/6/5 12:12
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Location {

    private double x;

    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }
    /*更新的位置*/
    public void setXY(double x, double y) {
        this.y = y;
        this.x = x;
    }
}
