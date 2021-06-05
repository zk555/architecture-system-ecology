package cn.jdl.ecology.juc.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/5 12:15
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class CartLocationTracker {

    // 保存车对应的坐标
    private Map<String, Location> locationMap = new HashMap<>();

    /**
     * 功能：更新车辆位置信息
     *
     * @param carCode 1
     * @param x       2
     * @param y       3
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/5 12:18
     */
    public void updateLocation(String carCode, double x, double y) {
        Location location = locationMap.get(carCode);
        location.setXY(x, y);  //线程不安全 ，存在并发读的情况，导致获取信息不正确，如：x更新后，Y未更新，这时候有读请求
    }

    /**
     * 功能：更新车辆位置信息(不可变)
     *
     * @param carCode 1
     * @param x       2
     * @param y       3
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/5 12:18
     */
    public void updateLocationY(String carCode, Location location) {
        locationMap.put(carCode,location);
    }


    /**
     * 功能：获取车辆位置
     *
     * @param cartCode 1
     * @version 0.0.1
     * @author zhaokai108
     * @date 2021/6/5 12:19
     */
    public Location getLocation(String cartCode) {
        return locationMap.get(cartCode);
    }
}
