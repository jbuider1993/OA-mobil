package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.service.hystrix.AppCompanyChatServiceHystrix;

/**
 * 添加fallback属性（在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容）
 * @author 卫志强
 */
@FeignClient(name= "app-pro-sys", fallback = AppCompanyChatServiceHystrix.class)
public interface AppCompanyChatService {

    @RequestMapping(value = "/compantUserChan", method = RequestMethod.GET)
    public String querycompanyDepartment(@RequestHeader(value = "userToken") String userToken);

}
