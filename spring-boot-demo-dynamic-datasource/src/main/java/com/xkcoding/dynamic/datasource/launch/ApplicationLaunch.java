package com.xkcoding.dynamic.datasource.launch;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.*;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApplicationLaunch {

    public static ConfigurableApplicationContext run(String appName, Class source, String... args){
        SpringApplicationBuilder builder = createSpringApplicationBuilder(appName, source, args);
        return builder.run(args);
    }
    public static SpringApplicationBuilder createSpringApplicationBuilder(String appName, Class source, String... args) {
        Assert.hasText(appName, "[appName]服务名不能为空");
        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new SimpleCommandLinePropertySource(args));
        propertySources.addLast(new MapPropertySource("systemProperties", environment.getSystemProperties()));
        propertySources.addLast(new SystemEnvironmentPropertySource("systemEnvironment", environment.getSystemEnvironment()));
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> profiles = Arrays.asList(activeProfiles);
        List<String> presetProfiles = new ArrayList(Arrays.asList("dev", "test", "prod"));
        presetProfiles.retainAll(profiles);
        List<String> activeProfileList = new ArrayList(profiles);
        Function<Object[], String> joinFun = StringUtils::arrayToCommaDelimitedString;
        SpringApplicationBuilder builder = new SpringApplicationBuilder(new Class[]{source});
        String profile;
        if (activeProfileList.isEmpty()) {
            profile = "dev";
            activeProfileList.add(profile);
            builder.profiles(new String[]{profile});
        } else {
            if (activeProfileList.size() != 1) {
                throw new RuntimeException("同时存在环境变量:[" + StringUtils.arrayToCommaDelimitedString(activeProfiles) + "]");
            }

            profile = (String)activeProfileList.get(0);
        }

        String startJarPath = ApplicationLaunch.class.getResource("/").getPath().split("!")[0];
        String activePros = (String)joinFun.apply(activeProfileList.toArray());
        System.out.println(String.format("系统启动中，读取到的环境变量:[%s]，jar地址:[%s]", activePros, startJarPath));
        Properties props = System.getProperties();
        props.setProperty("spring.application.name", appName);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("info.version", "2.7.0");
        props.setProperty("info.desc", appName);
        props.setProperty("app.env", profile);
        props.setProperty("app.name", appName);
        props.setProperty("app.is-local", String.valueOf(isLocalDev()));
        props.setProperty("app.dev-mode", profile.equals("prod") ? "false" : "true");
        props.setProperty("app.service.version", "2.7.0");
        props.setProperty("spring.main.allow-bean-definition-overriding", "true");
        // 加载自定义组件
//        List<LauncherService> launcherList = new ArrayList<>();
//        ServiceLoader.load(LauncherService.class).forEach(launcherList::add);
//        launcherList.stream().sorted(Comparator.comparing(LauncherService::getOrder)).collect(Collectors.toList())
//            .forEach(launcherService -> launcherService.launcher(builder, appName, profile));
        return builder;
    }

    public static boolean isLocalDev() {
        String osName = System.getProperty("os.name");
        return StringUtils.hasText(osName) && !"LINUX".equals(osName.toUpperCase());
    }
}
