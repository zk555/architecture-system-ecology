package cn.jdl.ecology.juc.sms;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 缓存常用数据，在数据库中加载
 * @Author zhaokai108
 * @Date 2021/6/5 13:27
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class SmsRouter {

    // 短信网关对象，通过volatile修饰包装其它线程可见
    private static volatile SmsRouter instance = new SmsRouter();

    // 获取网关对象
    public static SmsRouter getInstance() {
        return instance;
    }
    //更新短信网关
    public static void setInstance(SmsRouter instance) {
        SmsRouter.instance = instance;
    }

    // 短信服务商信息的map,key表示服务商上的优先级
    private final Map<Integer,SmsInfo> smsInfoMap;

    public SmsRouter() {
        this.smsInfoMap = this.loadSmsInfoRouteMapFromDb();
    }

    // 加载数据库的短信服务商
    private Map<Integer, SmsInfo> loadSmsInfoRouteMapFromDb() {
        Map<Integer,SmsInfo> routerMap = new HashMap<>();
        return routerMap;
    }

    //获取服务商列表的代码改造为防御性复制
    public Map<Integer, SmsInfo> getSmsInfoMap() {
        return Collections.unmodifiableMap(deepCopy(smsInfoMap));
    }

    private Map<Integer, SmsInfo> deepCopy(Map<Integer, SmsInfo> smsInfoMap) {
        Map<Integer,SmsInfo> result = new HashMap<>(smsInfoMap.size());
        for (Map.Entry<Integer,SmsInfo> entry :smsInfoMap.entrySet()){
//            result.put(entry.getKey(),new SmsInfo(entry.getValue()));
        }
        return result;
    }

    public void changeRouteInfo(){
        SmsRouter smsRouter = new SmsRouter();
        Map<Integer,SmsInfo> smsInfoMap = smsRouter.getSmsInfoMap();
        SmsInfo smsInfo = smsInfoMap.get(3);
        // 下面流程会存在中间状态
        smsInfo.setUrl("new http");
        smsInfo.setMaxSizeInBytes(183L);
    }

    // 变更网关
    public static void main(String[] args) {
//        updateSmsRouteInfoLists();

        SmsRouter.setInstance(new SmsRouter());
    }
}
