package com.ssic.education.utils.redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.CollectionUtils;

public class WdRedisDao<T>
{
  protected static final Log logger = LogFactory.getLog(WdRedisDao.class);
  public static final long DEFAULT_TIME_OUT = 30L;
  private RedisTemplate<String, T> redisTemplate;
  private RedisKeyResolver<T> keyResolver = new RedisKeyResolver();

  public void set(T t)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(t.getClass());
    if (prefix == null) {
      return;
    }
    String key = this.keyResolver.paseKey(prefix, t);
    logger.info("put into redis --- key eq : " + key + " and value eq " + t);
    this.redisTemplate.opsForValue().set(key, t);
  }

  public void set(T t, long timeout)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(t.getClass());
    if (prefix == null) {
      return;
    }
    String key = this.keyResolver.paseKey(prefix, t);
    logger.info("put into redis --- key eq : " + key + " and value eq " + t);
    this.redisTemplate.opsForValue().set(key, t, timeout, TimeUnit.MINUTES);
  }

  public void setAsDefaultTimeOut(T t)
  {
    set(t, 30L);
  }

  public T get(String keyValue, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return null;
    }
    String key = this.keyResolver.paseKey(prefix, keyValue);
    logger.info("get from redis --- key eq : " + key);
    return this.redisTemplate.opsForValue().get(key);
  }

  public void setToList(T t)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(t.getClass());
    if (prefix == null) {
      return;
    }
    String key = this.keyResolver.paseKeyForList(prefix, t);
    logger.info("put into redis list --- key eq : " + key + " and value eq " + t);

    this.redisTemplate.opsForList().leftPush(key, t);
  }

  public void setToList(List<T> list) {
    if (CollectionUtils.isEmpty(list)) {
      return;
    }

    for (Iterator i$ = list.iterator(); i$.hasNext(); ) {
    	Object record = i$.next();
    }
     // setToList(record); }
  }

  public void setToList(String key, T t)
  {
    this.redisTemplate.opsForList().leftPush(key, t);
  }

  public T get(T dto, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return null;
    }
    String key = this.keyResolver.paseKey(prefix, dto);
    logger.info("get from redis --- key eq : " + key);

    return this.redisTemplate.opsForValue().get(key);
  }

  public List<T> getList(String keyValue, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return null;
    }
    String key = this.keyResolver.paseKeyForList(prefix, keyValue);
    logger.info("get all from redis list --- key eq : " + key);

    List list = new ArrayList();
    BoundListOperations opt = this.redisTemplate.boundListOps(key);
    long size = opt.size().longValue();
    for (int index = 0; index < size; index++) {
      Object t = opt.index(index);
      list.add(t);
    }
    return list;
  }

  public List<T> getList(T dto, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return null;
    }
    String key = this.keyResolver.paseKeyForList(prefix, dto);
    logger.info("get all from redis list --- key eq : " + key);

    List list = new ArrayList();
    BoundListOperations opt = this.redisTemplate.boundListOps(key);
    long size = opt.size().longValue();
    for (int index = 0; index < size; index++) {
      Object t = opt.index(index);
      list.add(t);
    }
    return list;
  }

  public T pop(String keyValue)
  {
    logger.info("pop a obj from redis list --- key eq : " + keyValue);
    return this.redisTemplate.opsForList().rightPop(keyValue);
  }

  public T bpop(String keyValue, long timeout)
  {
    logger.info("pop a obj from redis list --- key eq : " + keyValue + " timeout : " + timeout);

    return this.redisTemplate.opsForList().rightPop(keyValue, timeout, TimeUnit.MINUTES);
  }

  public void delete(T dto, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return;
    }
    String key = this.keyResolver.paseKey(prefix, dto);
    logger.info("delete redis --- key eq : " + key);
    this.redisTemplate.delete(key);
  }

  public void deleteList(T dto, Class<?> cls)
  {
    RedisKeyPrefix prefix = this.keyResolver.getRedisKeyPrefix(cls);
    if (prefix == null) {
      return;
    }
    String key = this.keyResolver.paseKeyForList(prefix, dto);
    logger.info("delete redis --- key eq : " + key);
    this.redisTemplate.delete(key);
  }

  public void delete(List<String> keys) {
    this.redisTemplate.delete(keys);
  }

  public void delete(String key) {
    this.redisTemplate.delete(key);
  }

  public Boolean hasKey(String key) {
  return this.redisTemplate.hasKey(key);
  }

  public RedisTemplate<String, T> getRedisTemplate()
  {
    return this.redisTemplate; } 
  public void setRedisTemplate(RedisTemplate<String, T> redisTemplate) { this.redisTemplate = redisTemplate; }

}
