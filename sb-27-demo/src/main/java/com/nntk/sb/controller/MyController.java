package com.nntk.sb.controller;

import com.nntk.sb.api.DefaultResultObserver;
import com.nntk.sb.api.my.MyBodyEntity;
import com.nntk.sb.api.my.UserInfo;
import com.nntk.sb.api.my.MyApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MyController {


    @Resource
    private MyApi myApi;


    @GetMapping("/test")
    public Object test() {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sex", "男");
        List<UserInfo> data = myApi.getList(1, 2, paramMap)
                .executeForResult();

        return data;
    }

    @GetMapping("/login1")
    public Object login1() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sex", "男");
        MyBodyEntity myBodyEntity = myApi.login1(paramMap).executeForResult();
        return myBodyEntity;
    }

    @GetMapping("/login2")
    public Object login2() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sex", "男");
        myApi.login2(paramMap).observe(new DefaultResultObserver() {
            @Override
            public void complete() {
                super.complete();
                log.info("=====my complete");
            }
        });
        return "success";
    }

    @GetMapping("/login3")
    public Object login3() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sex", "男");
        myApi.login3(paramMap);
        return "success";
    }

}