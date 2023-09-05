package cn.jdl.ecology.ext.facade;

/*

防腐层

1. 对于依赖的外部对象，我们抽取出所需要的字段，生成一个内部所需的VO或DTO类
2. 构建一个新的Facade，在Facade中封装调用链路，将外部类转化为内部类
3. 针对外部系统调用，同样的用Facade方法封装外部调用链路

 */