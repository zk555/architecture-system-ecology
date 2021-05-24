package cn.jdl.ecologyy.gate.base.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * rpc服务缓存
 */
public class RPCCache {
	private static ConcurrentHashMap<String, Class<?>> rpcServices;
	
	private RPCCache(){
		throw new AssertionError();
	}

	static{
		rpcServices = new ConcurrentHashMap<String, Class<?>>();
	}
	
	public static Class<?> getClass(String className){
		return rpcServices.get(className);
	}
	
	public static void putClass(String className , Class<?> clazz){
		rpcServices.put(className, clazz);
	}
	
}
