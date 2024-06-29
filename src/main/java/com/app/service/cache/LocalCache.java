package com.app.service.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LocalCache<T> {

	private LoadingCache<String, T> loadingCache;

	private static final long TIME_TO_LIVE = 60;
 
	public LocalCache() {
		log.info(" init load cache");
		this.loadingCache = CacheBuilder.newBuilder().expireAfterAccess(TIME_TO_LIVE, TimeUnit.SECONDS)
				.build(new CacheLoader<String, T>() {
					@Override
					public T load(final String s) throws Exception {
						return null;
					}
				});
	}

	public void invalidate(String key) {
		this.loadingCache.invalidate(key);
	}

	/**
	 * 
	 * set cache
	 * */
	public void set(String key, T object) {
		this.loadingCache.put(key, object);
	}

	public T get(String key) {
		log.info(" load from cache");
		return this.loadingCache.getIfPresent(key);
	}

}
