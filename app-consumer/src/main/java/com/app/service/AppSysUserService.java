package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.hystrix.AppSysUserServiceHystrix;

/**
 * 添加fallback属性（在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容）
 * @author 
 */
@FeignClient(name= "app-pro-user", fallback = AppSysUserServiceHystrix.class)
public interface AppSysUserService {

    @RequestMapping(value = "/appLogin", method = RequestMethod.POST)
    public String login(
    		@RequestParam(value = "name") String name, 
    		@RequestParam(value = "password") String password);

}
