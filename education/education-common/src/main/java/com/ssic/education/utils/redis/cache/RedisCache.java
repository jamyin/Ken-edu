package com.ssic.education.utils.redis.cache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache
  implements Cache
{
  protected static final Log logger = LogFactory.getLog(RedisCache.class);
  private RedisTemplate<String, Object> redisTemplate;
  private String name;

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public Object getNativeCache()
  {
    return this.redisTemplate;
  }

  public Cache.ValueWrapper get(Object key)
  {
    logger.info("get ---  param : key - " + key);
    final String keyf = (String)key;
    Object object = null;
    object = this.redisTemplate.execute(new RedisCallback()
    {
      public Object doInRedis(RedisConnection connection) throws DataAccessException
      {
        byte[] key = keyf.getBytes();
        byte[] value = connection.get(key);
        if (value == null) {
          return null;
        }
        return RedisCache.this.toObject(value);
      }
    });
    return object != null ? new SimpleValueWrapper(object) : null;
  }

  public void put(Object key, Object value)
  {
    if (value == null) {
      return;
    }
    logger.info("put ---  param : key - " + key + " value - " + value);
    final String keyf = (String)key;
    final Object valuef = value;
    long liveTime = 864000L;

    this.redisTemplate.execute(new RedisCallback()
    {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        byte[] keyb = keyf.getBytes();
        byte[] valueb = RedisCache.this.toByteArray(valuef);
        connection.set(keyb, valueb);

        connection.expire(keyb, 864000L);

        return Long.valueOf(1L);
      }
    });
  }

  public <T> T get(Object key, Class<T> type)
  {
    logger.info("get ---  param : key - " + key + " type - " + type.getName());

    return null;
  }

  public void evict(Object key)
  {
    logger.info("evict ---  param : key - " + key);
    final String keyf = (String)key;
    this.redisTemplate.execute(new RedisCallback()
    {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.del(new byte[][] { keyf.getBytes() });
      }
    });
  }

  public void clear()
  {
    logger.info("clear");
    this.redisTemplate.execute(new RedisCallback()
    {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        connection.flushDb();
        return "ok";
      }
    });
  }

  private byte[] toByteArray(Object obj)
  {
    byte[] bytes = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(obj);
      oos.flush();
      bytes = bos.toByteArray();
      oos.close();
      bos.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return bytes;
  }

  private Object toObject(byte[] bytes)
  {
    Object obj = null;
    try {
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      ObjectInputStream ois = new ObjectInputStream(bis);
      obj = ois.readObject();
      ois.close();
      bis.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    return obj;
  }

  public RedisTemplate<String, Object> getRedisTemplate()
  {
    return this.redisTemplate; } 
  public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) { this.redisTemplate = redisTemplate; }

}