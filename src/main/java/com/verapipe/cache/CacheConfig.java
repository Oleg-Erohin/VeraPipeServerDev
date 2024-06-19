package com.verapipe.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(20, TimeUnit.MINUTES));
        cacheManager.setCacheNames(Arrays.asList("baseMaterialTypesCache"));
        cacheManager.setCacheNames(Arrays.asList("fillerMaterialTypesCache"));
        cacheManager.setCacheNames(Arrays.asList("jointDesignsCache"));
        cacheManager.setCacheNames(Arrays.asList("fusionProcessesCache"));
        cacheManager.setCacheNames(Arrays.asList("ndtTypeCache"));
        cacheManager.setCacheNames(Arrays.asList("standardCodeCache"));
        cacheManager.setCacheNames(Arrays.asList("processSpecificationProceduresCache"));
        cacheManager.setCacheNames(Arrays.asList("pipeWallThicknessCache"));


        return cacheManager;
    }
}
