package cn.jdl.ecology.thread.cpu;

/**
 * @Description: CPU 对应线程数量设置 CPU 密集型的程序 - 核心数 + 1 ，I/O 密集型的程序 - 核心数 * 2 成立嘛？
 * @Author zhaokai108
 * @Date 2021/6/28 16:45
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 *
 *  核心数12 * 利用率0.9 * (1 + 50(sleep时间)/50(循环50_000_000耗时)) ≈ 22
 */
public class CpuUtilizationTest {

    // 一个线程不停的执行指令，就可以跑满一个核心的利用率

    public static void main(String[] args) {

        test1();
        test2();


    }
    // CPU不需要执行I/O操作, 一直执行指令
    public static void test1(){
        //死循环 ,一个线程会占满一个CPU
        while (true){

        }
    }

    public static void test2(){
        //多开线程
        for (int j = 0 ;j<6;j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){

                    }
                }
            }).start();
        }
    }

    // 如果程序中有IO操作的时候，操作系统可以调度CPU可以同时执行更多的线程。
    public static void test3(){
        //多开线程
        for (int j = 0 ;j<6;j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        for (int i = 1;i< 10000;i++){
                            //循环一定次数后，sleep 50ms 模拟I/O等待、切换
                        }
                        try{
                            Thread.sleep(50);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
