package cn.jdl.ecology.juc.twoPhaseTermination.terminal;

/**
 * @Description:
 * @Author zhaokai108
 * @Date 2021/6/22 14:30
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class AbstractTerminationThread extends Thread implements Termination {

    // 线程共享停止的标志示例对象
    private TerminaltionToken terminaltionToken;


}
