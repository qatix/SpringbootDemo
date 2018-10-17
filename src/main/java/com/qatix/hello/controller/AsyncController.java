package com.qatix.hello.controller;

import com.qatix.hello.entity.GithubUser;
import com.qatix.hello.service.GithubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/async")
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private GithubLookupService githubLookupService;

    /**
     * async可用于做一些批量获取任务，用多线程的方式加快执行，并一次性获得全部结果
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @RequestMapping("/test")
    public String startAsyncTask() throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<GithubUser> page1 = githubLookupService.findUser("PivotalSoftware");
        CompletableFuture<GithubUser> page2 = githubLookupService.findUser("CloudFoundry");
        CompletableFuture<GithubUser> page3 = githubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());

        return "async task done";
    }
}

