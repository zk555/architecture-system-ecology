package cn.jdl.ecology.application.service;

/*

作为所有对外的门户，将网络协议和业务逻辑解耦。

鉴权、Session、限流、缓存、日志


规范：Interface层的HTTP和RPC接口，返回值为Result，捕捉所有异常
规范：Application层的所有接口返回值为DTO，不负责处理异常
规范：一个Interface层的类应该是“小而美”的，应该是面向“一个单一的业务”或“一类同样需求的业务”，需要尽量避免用同一个类承接不同类型业务的需求。
规范：CQE对象的校验应该前置，避免在ApplicationService里做参数的校验。可以通过JSR303/380和Spring Validation来实现
 */