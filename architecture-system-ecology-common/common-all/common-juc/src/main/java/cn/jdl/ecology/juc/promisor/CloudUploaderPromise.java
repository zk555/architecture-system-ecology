package cn.jdl.ecology.juc.promisor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description: 模拟网盘传输接口
 * @Author zhaokai108
 * @Date 2021/6/30 15:09
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class CloudUploaderPromise {

    public static Future<Object> newCloudUploaderPromise(CloudConfig cloudConfig){
        FutureTask<Object> futureTask = new FutureTask<Object>(()->{
            DefaultCloudUploader defaultCloudUploader = new DefaultCloudUploader();
            System.out.println("开始创建云盘的连接");
            defaultCloudUploader.init(cloudConfig.getCloudAddress()
                    ,cloudConfig.getUserName()
                    ,cloudConfig.getPassWorld()
                    ,cloudConfig.getServerDir());
            return defaultCloudUploader;
        });

        new Thread(futureTask).start();
        return futureTask;
    }

    // 与云盘创建连接主流程
    public static void main(String[] args) {
        //step1 初始化本地与服务器端的ftp连接
        Future<Object> cloudUploaderFutureTask = CloudUploaderPromise.newCloudUploaderPromise(new CloudConfig());

        //step2 扫描本地文件
        StorageManager storageManager = StorageManager.getInstance();
        List<FileInfo> fileInfos =storageManager.scanLocalFile();
        System.out.println("扫描本地文件完成！！！");

        //获取初始化好的云盘client
        CloudUploader cloudUploader = null;
        try{
            System.out.println("同步阻塞等待连接完成。。。。");
            cloudUploader = (CloudUploader) cloudUploaderFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (cloudUploader == null){
            return;
        }


        syncFile(cloudUploader,fileInfos);
        System.out.println("上传完成");

        cloudUploader.disconnect();
        System.out.println("关闭连接完成");
    }

    //上传
    private static void syncFile(CloudUploader cloudUploader, List<FileInfo> fileInfos) {

    }
}
class StorageManager{

    private Boolean status ;

    public static StorageManager getInstance() {
        return null;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<FileInfo> scanLocalFile() {
        return null;
    }
}

class FileInfo{

    private Boolean status ;

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

class CloudUploader{

    private Boolean status ;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // 关闭连接
    public void disconnect() {
    }
}

class CloudConfig{

    private String userName ;

    private String passWorld;

    private String cloudAddress;

    private String serverDir;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public String getCloudAddress() {
        return cloudAddress;
    }

    public void setCloudAddress(String cloudAddress) {
        this.cloudAddress = cloudAddress;
    }

    public String getServerDir() {
        return serverDir;
    }

    public void setServerDir(String serverDir) {
        this.serverDir = serverDir;
    }
}

class DefaultCloudUploader{

    public void init(String cloudAddr,String userName,String passworld,String serverAdr){

    }
}