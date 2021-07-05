package cn.jdl.ecology.juc.promisor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/29 17:24
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class Promisor {

   public static Future<Object> create(long startTime){
       //step1 定义任务
       FutureTask<Object> futureTask = new FutureTask<Object>(()->{
           System.out.println("step 1 : " + (System.currentTimeMillis() - startTime) + "ms");
           BoiWater boiWater = new BoiWater();
           Thread.sleep(15000);
           boiWater.setStatus(true);
           return boiWater;
       });

       //step2 Executor在这里执行
       new Thread(futureTask).start();
       return futureTask;
   }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
       long startTime = System.currentTimeMillis();
       
       //part1: 通过Promisor的create获取promise
        Future<Object> promise = Promisor.create(startTime);

        //part2: 主线程执行其它任务
        System.out.println("3 分钟 start" + (System.currentTimeMillis()-startTime) + "ms");

        TraAndCup traAndCup = new TraAndCup();
        Thread.sleep(3000);

        System.out.println("3 分钟 end" + (System.currentTimeMillis()-startTime) + "ms");

        //part3 获取结果
        if (!promise.isDone()){
            System.out.println("等待 子流程");
        }

        BoiWater boiWater = (BoiWater) promise.get();

        System.out.println("3 分钟 end" + (System.currentTimeMillis()-startTime) + "ms");
        System.out.println("end");
        System.out.println(" 总用时 end" + (System.currentTimeMillis()-startTime) + "ms");


    }
}

class BoiWater{

    private Boolean status ;

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

class TraAndCup{

    private Boolean status ;

    public void setStatus(Boolean status) {
        this.status = status;
    }
}