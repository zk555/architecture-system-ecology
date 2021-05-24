package cn.jdl.ecologyy.gate.codec;

import cn.jdl.ecologyy.gate.rpc.dataBridge.ResponseData;
import cn.jdl.ecologyy.gate.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器 ，转换成响应结果
 */
public class RpcEncoder extends MessageToByteEncoder<ResponseData> {

	@Override
	protected void encode(ChannelHandlerContext ctx, ResponseData msg, ByteBuf out) throws Exception {
		byte[] data = SerializationUtil.serialize(msg);
		out.writeShort(data.length);
		out.writeBytes(data);
	}

}
