package cn.jdl.ecologyy.gate.rpc.rpcProcessor;

import cn.jdl.ecologyy.gate.rpc.dataBridge.RequestData;
import cn.jdl.ecologyy.gate.rpc.dataBridge.ResponseData;

/**
 * RPC服务接口
 */
public interface RPCProcessor {
	/**
	 * 发布rpc服务
	 * @throws Exception
	 */
	void exportService() throws Exception ;
	
	/**
	 * 调用rpc服务
	 * @param requestData
	 * @return
	 */
	ResponseData executeService(RequestData requestData);
}
