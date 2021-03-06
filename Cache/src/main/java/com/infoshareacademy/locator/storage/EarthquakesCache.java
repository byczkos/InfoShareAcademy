package com.infoshareacademy.locator.storage;

import com.infoshareacademy.locator.model.Earthquake;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class EarthquakesCache {
    Map<String, List<Earthquake>> cache = new HashMap<>();
    private Cache<String, List> myCache;

    @Inject
    EarthquakesStorage storage;

    public EarthquakesCache() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("preConfigured",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, List.class,
                                ResourcePoolsBuilder.heap(100))
                                .build())
                .build(true);

               myCache = cacheManager.getCache("preConfigured", String.class, List.class);
    }

    public List<Earthquake> get(String year) {
        if(!myCache.containsKey(year)) {
            myCache.put(year, storage.getForYear(year));
        }
        return myCache.get(year);
    }
}
