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
        cacheManager.setCacheNames(Arrays.asList("baseMaterialCertificatesCache"));
        cacheManager.setCacheNames(Arrays.asList("baseMaterialTypesCache"));
        cacheManager.setCacheNames(Arrays.asList("fillerMaterialCertificatesCache"));
        cacheManager.setCacheNames(Arrays.asList("fillerMaterialTypesCache"));
        cacheManager.setCacheNames(Arrays.asList("fusionProcessesCache"));
        cacheManager.setCacheNames(Arrays.asList("isometricsCache"));
        cacheManager.setCacheNames(Arrays.asList("joinersCache"));
        cacheManager.setCacheNames(Arrays.asList("jointDesignsCache"));
        cacheManager.setCacheNames(Arrays.asList("jointsCache"));
        cacheManager.setCacheNames(Arrays.asList("ndtReportsCache"));
        cacheManager.setCacheNames(Arrays.asList("ndtTypesCache"));
        cacheManager.setCacheNames(Arrays.asList("pidsCache"));
        cacheManager.setCacheNames(Arrays.asList("pipeWallThicknessCache"));
        cacheManager.setCacheNames(Arrays.asList("postWeldHeatTreatmentsCache"));
        cacheManager.setCacheNames(Arrays.asList("preheatsCache"));
        cacheManager.setCacheNames(Arrays.asList("pressureTestPackagesCache"));
        cacheManager.setCacheNames(Arrays.asList("processSpecificationProceduresCache"));
        cacheManager.setCacheNames(Arrays.asList("standardCodeCache"));

        return cacheManager;
    }
}
