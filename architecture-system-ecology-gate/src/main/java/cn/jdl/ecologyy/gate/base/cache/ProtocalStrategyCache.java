package cn.jdl.ecologyy.gate.base.cache;


import cn.jdl.ecologyy.gate.concurrent.ThreadFactoryImpl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 规约相关缓存
 */
public class ProtocalStrategyCache {
	private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor(
			new ThreadFactoryImpl("persistent_ProtocalStrategy_", true));
	private ProtocalStrategyCache(){
		throw new AssertionError();
	}
	/**
	 * 网关规约规则缓存
	 */
	public static ConcurrentHashMap<String, String> protocalStrategyCache ;
	/**
	 * 网关规约服务缓存---用于规约服务控制-- key=pId
	 */
//	public static ConcurrentHashMap<String, Server4Terminal> protocalServerCache ;
	/**
	 * key = Pid
	 * value = 全类名
	 */
	public static ConcurrentHashMap<String, String> protocalStrategyClassUrlCache ;
	
	static{
		protocalStrategyCache = new ConcurrentHashMap<>();
//		protocalServerCache = new ConcurrentHashMap<>();
		protocalStrategyClassUrlCache = new ConcurrentHashMap<>();
	}
	
	/**
	 * 规约规则落地
	 */
	private static void persistentProtocalStrategy(){
		scheduledExecutor.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO 规约规则落地
				
			}
		}, 2, 3, TimeUnit.MINUTES);
	}
	
}
