package cn.jdl.ecology.domain.service;


//领域服务

/**
 *
 * 1.一个Entity不应该直接参考另一个Entity或服务 player
 * 2.Double Dispatch是一个使用Domain Service经常会用到的方法，类似于调用反转。
 * 3. 行为可能会影响到Player、Monster和Weapon，所以属于跨实体的业务逻辑。在这种情况下需要通过一个第三方的领域服务（Domain Service）来完成。
 *
 *
 * 1. 单对象策略型: 实体应该通过方法入参的方式传入这种领域服务，然后通过Double Dispatch来反转调用领域服务的方法
 * 2. 跨对象事务型: 一个行为会直接修改多个实体时，不能再通过单一实体的方法作处理，而必须直接使用领域服务的方法来做操作 （void attack(））
 * 3. 通用组件型: Policy或者Strategy设计模式是一个通用的设计模式, 封装领域规则
 */