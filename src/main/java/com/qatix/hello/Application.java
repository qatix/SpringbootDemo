package com.qatix.hello;

import com.qatix.hello.storage.StorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class Application {

	private final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Executor asyncExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();
		return executor;
	}
	//上传开启
//	@Bean
//	CommandLineRunner init(StorageService storageService){
//		logger.info("initial storage properties...");
////		System.out.println("initial storage properties...");
//		return (args) -> {
////			storageService.deleteAll();
//			storageService.init();
//		};
//	}
}

/*
1.打包成一个war包并部署到Tomcat下面，需要继承SpringBootServletInitializer
2.并将pom.xml文件中的packaging改为war
3.增加依赖设置
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-tomcat</artifactId>
<scope>provided</scope>
</dependency>
*/
//public class HelloApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(HelloApplication.class);
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(HelloApplication.class, args);
//	}
//}