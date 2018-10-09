package com.coviam.administration.dao;

import com.coviam.administration.model.UserRecord;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class UserDaoRedis {

    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;
    // the jedis connection pool..
    private static JedisPool pool = null;

    public UserDaoRedis() {
        pool = new JedisPool(redisHost, redisPort);
    }

    public void setValueInCache(String key, String value) {
        Jedis jedis = pool.getResource();
        jedis.set(key, value);
        jedis.close();
    }

    public String getValueFromCache(String key) {
        Jedis jedis = pool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    public boolean deleteValueInCache(String key) {
        Jedis jedis = pool.getResource();
        Long elementsImpacted = jedis.del(key);
        jedis.close();
        return (elementsImpacted > 0);
    }


    public List<UserRecord> findAll() {

        return null;
    }

    public void save(UserRecord userRecord) {
        
    }

    public void delete(Long id) {
    }

    public UserRecord findOne(Long id) {

        return null;
    }
}
