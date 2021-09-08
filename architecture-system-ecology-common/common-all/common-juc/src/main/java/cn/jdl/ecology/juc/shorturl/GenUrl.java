package cn.jdl.ecology.juc.shorturl;

/**
 * @Description: 生成端链接
 * @Author zhaokai108
 * @Date 2021/7/28 18:33
 * @Version 1.0
 * @Copyright: Copyright (c)2020 JDL.CN All Right Reserved
 */
public class GenUrl {

    private  static final String[] X36_ARRAY = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");

    public String getShortUrl(String url) {
//        long shortUrlSeed = jedis.incr("short_url_seed");
        long shortUrlSeed = 100000000000L;
        StringBuffer buffer = new StringBuffer();
        while(shortUrlSeed > 0) {
            buffer.append(X36_ARRAY[(int)(shortUrlSeed % 36)]);
            shortUrlSeed = shortUrlSeed / 36;
        }
        //获取到短链接
        String shortUrl = buffer.reverse().toString();
        return shortUrl;
    }

    public static void main(String[] args) {
        String shortUrl = new GenUrl().getShortUrl("https://pdai.tech/md/db/nosql-redis/db-redis-y-weibo.html");
        System.out.println(shortUrl);


    }
}
