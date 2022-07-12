package com.sourav.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CacheLoaderTest {
    int callCount = 0;

    @Test
    public void givenAMap_whenAddingValues_thenCanTreatThemAsCache() {
        Map<String, String> cache = new HashMap<>();
        cache.put("prem", "valueForPrem");
        cache.put("sourav", "valueForSourav");


    }


    @Test
    public void givenCacheLoader_whenGettingItemTwice_shouldOnlyCallOnce() throws ExecutionException {

        final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .build(new com.google.common.cache.CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return slowMethod(s);
                    }
                });
        String value = loadingCache.get("key");
        value = loadingCache.get("key");

        assertEquals(callCount, 1);
        assertEquals(value, "key");
    }

    @Test
    public void givenCacheLoader_whenRefreshingItem_shouldCallAgain() throws ExecutionException {
        final LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .build(new com.google.common.cache.CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return slowMethod(s);
                    }
                });
        String value = loadingCache.get("key");
        loadingCache.refresh("key");

        assertEquals(callCount, 2);
        assertEquals(value, "key");
    }

    @Test
    public void whenCacheReachesMaxSize_thenEvict() throws ExecutionException {
        final com.google.common.cache.CacheLoader<String, String> loader = new com.google.common.cache.CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return slowMethod(key);
            }
        };
        final LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).build(loader);
        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("thirsd");
        cache.getUnchecked("fourth");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("fourth", cache.getIfPresent("fourth"));
        assertEquals(callCount, 4);

    }


    private String slowMethod(final String s) {
        callCount++;
        return s;
    }
}
