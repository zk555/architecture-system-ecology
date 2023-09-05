package cn.jdl.ecology.application.service.impl;

/*

1. 业务流程串联， 不要存在if/else
2. 仅仅代表了中断条件，具体的业务逻辑处理并没有受影响
3. 不要有任何计算
4. AppService通常不做任何决策（Precondition除外），仅仅是把所有决策交给DomainService或Entity，把跟外部交互的交给Infrastructure接口
5. ApplicationService应该永远返回DTO而不是Entity
 */


/**
 *
 * 常见流程：
 * 1. 准备数据：包括从外部服务或持久化源取出相对应的Entity、VO以及外部服务返回的DTO。
 * 2. 执行操作：包括新对象的创建、赋值，以及调用领域对象的方法对其进行操作。需要注意的是这个时候通常都是纯内存操作，非持久化。
 * 3. 持久化：将操作结果持久化，或操作外部系统产生相应的影响，包括发消息等异步操作。
 */