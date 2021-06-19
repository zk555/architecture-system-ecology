package cn.jdl.ecology.juc.alarm;

/**
 * @Description:  与报警服务器建立连接的线程
 * @Author zhaokai108
 * @Date 2021/6/15 20:45
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class ConnectingTask implements Runnable {

//    Blocker blocker;
    @Override
    public void run() {
        //走socketChannel的方式和告警服务器建立一个连接
        try {
            Thread.sleep(10*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ararm connected");
        onConnected();
    }

    //建立连接
    private void onConnected() {

        try{
//            blocker.signaAfter()
        }catch (Exception e) {

        }
    }

}
