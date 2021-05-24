package cn.jdl.ecologyy.gate.rpc.rpcProcessor;

import cn.jdl.ecologyy.gate.base.cache.RPCCache;
import cn.jdl.ecologyy.gate.rpc.annotation.RPCService;
import cn.jdl.ecologyy.gate.rpc.dataBridge.RequestData;
import cn.jdl.ecologyy.gate.rpc.dataBridge.ResponseData;
import cn.jdl.ecologyy.gate.server.RemoteServer;
import cn.jdl.ecologyy.gate.util.MixAll;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 
 * @Description: 
 * @author  yangcheng
 * @date:   2019年3月30日
 */
public class RPCProcessorImpl implements RPCProcessor {
	
	@Override
	public void exportService() throws Exception {
		List<String> result = MixAll.getClazzName("gate.rpc.rpcService",false);
		for (String className : result) {
			Class<?> clazz = Class.forName(className);
			if(clazz.isAnnotationPresent(RPCService.class)){
				RPCCache.putClass(clazz.getSimpleName(), clazz);
			}
		}
		new RemoteServer().start();
		System.out.println("发布rpc服务完毕........");
	}

	@Override
	public ResponseData executeService(RequestData requestData) {
		Class<?> clazz = RPCCache.getClass(requestData.getClassName()+"Impl");
		ResponseData responseData = null;
		try {
			Method method = clazz.getMethod(requestData.getMethodName(), requestData.getParamTyps());
			responseData = (ResponseData) method.invoke(clazz.newInstance(), requestData.getArgs());
			//请求响应代码一一对应
			responseData.setResponseNum(requestData.getRequestNum());
			return responseData;
		} catch (NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		responseData = new ResponseData();
		responseData.setResponseNum(requestData.getRequestNum());
		return null;
	}
	
	
	
	

}
