package com.xiaosky.bstar.webmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;

/**
 * Created by xiaob on 2017/1/12.
 */
@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages={"com.xiaosky.bstar"},
        excludeFilters={
                @ComponentScan.Filter(type=FilterType.CUSTOM, value=RootConfig.WebPackage.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
        })
@EnableScheduling
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com\\.xiaosky\\.bstar\\.controller"));
        }
    }
}
