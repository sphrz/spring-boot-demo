package com.xkcoding.dynamic.datasource.launch;

import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;


/**
 * 启动参数拓展
 *
 * @author smallchil
 */
public class LauncherServiceImpl implements LauncherService {

    @Override
    public void launcher(SpringApplicationBuilder builder, String appName, String profile) {
        Properties props = System.getProperties();
    }

}
