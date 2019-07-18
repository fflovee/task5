package com.jnshu.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class Memcached {

    @Autowired
    MemcachedClient memcachedClient;

//    private static Logger log = LogManager.getLogger(Memcached.class);

    public void setMemcachedClient(String key, Object value) {
        int expTime = 3600;
        try {
            memcachedClient.set(key, expTime, value);
        } catch (InterruptedException | MemcachedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public Object getObject(String s) {
        try {
//            memcachedClient.get(s);
            return memcachedClient.get(s);
        } catch (InterruptedException | MemcachedException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteMemcachedClient(String s) {
        try {
            memcachedClient.delete(s);
        } catch (InterruptedException | MemcachedException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}


