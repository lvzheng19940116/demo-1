package ad.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;




public final class RedisUtil {
    
    //Redis服务器IP
    private static String ADDR = Constends.RedisAddress;
    
    //Redis的端口号
    private static int PORT = Constends.RedisPORT;
    
    //访问密码
    private static String AUTH = Constends.RedisAUTH;
    
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setMaxIdle(MAX_IDLE);
            config.setTestOnBorrow(TEST_ON_BORROW);
            if(AUTH!=null && AUTH.length()>0){
            	jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            }else{
            	jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
    
    public static void makeFile(String keys,String values,int num){
    	if(num==0){
    		RedisUtil.getJedis().del(keys);
    	}else{
    		RedisUtil.getJedis().set(keys,values);
    	}
    }
    
    
    /*public static void main(String[] args){
    	//d:cd redis 
    	//redis-server.exe redis.windows.conf
    	Jedis jedis = RedisUtil.getJedis();
    	Map map = new HashMap();
    	map.put("name", "lisi");
    	map.put("age", "32");
    	map.put("addr", "北京会");
    	
    	String str = "{\"MenuID\":1,\"MenuCode\":2,\"MenuName\":3}";
    	jedis.set("role=5", str);
    	jedis.expire("role=5", 15);
    	//jedis.del("m_001");
    	
    	List li = jedis.hmget("m=18", new String[]{"MenuID","MenuCode","MenuName","PID","SiteID","Leaf","linkType","urlCode","orderNum"});
    	for(Object o:li){
    		System.out.println(o);
    	}
    	
    	String name = RedisUtil.getJedis().get("role=5");
    	System.out.println(name);
    	RedisUtil.returnResource(jedis);
    	
    }*/
}
