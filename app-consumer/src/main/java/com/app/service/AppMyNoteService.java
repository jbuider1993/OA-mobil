package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.hystrix.AppMyNoteServiceHystrix;

/**
 * 添加fallback属性（在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容）
 * @author 
 */
@FeignClient(name= "app-pro-note", fallback = AppMyNoteServiceHystrix.class)
public interface AppMyNoteService {

    @RequestMapping(value = "/myNote", method = RequestMethod.GET)
    public String queryNoteAllFile(@RequestHeader(value = "userToken") String userToken);
    
    @RequestMapping(value = "/myNoteDetail", method = RequestMethod.GET)
    public String queryNoteContent(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id);
    
    @RequestMapping(value = "/myNewNote", method = RequestMethod.GET)
    public String queryNewNote(@RequestParam(value = "userToken") String userToken);
    
    @RequestMapping(value = "/myNoteFolder", method = RequestMethod.POST)
    public String addNoteFolder(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id, @
    		RequestParam(value = "name") String name);
   
    @RequestMapping(value = "/myNote", method = RequestMethod.POST)
    public String addNoteContent(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "pid") String pid, 
    		@RequestParam(value = "name") String name, 
    		@RequestParam(value = "type") String type, 
    		@RequestParam(value = "desc") String desc, 
    		@RequestParam(value = "content") String content);

    @RequestMapping(value = "/myNoteFileName", method = RequestMethod.PUT)
    public String editNoteFileName(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id, 
    		@RequestParam(value = "name") String name, 
    		@RequestParam(value = "type") String type);

    @RequestMapping(value = "/myNote", method = RequestMethod.PUT)
    public String editNoteContent(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id, 
    		@RequestParam(value = "name") String name, 
    		@RequestParam(value = "desc") String desc, 
    		@RequestParam(value = "content") String content);
   
    @RequestMapping(value = "/myNote", method = RequestMethod.DELETE)
    public String deleteFileFolderById(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id, 
    		@RequestParam(value = "type") String type);

    @RequestMapping(value = "/myMoveToFile", method = RequestMethod.GET)
    public String queryMoveToFile(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "id") String id, 
    		@RequestParam(value = "type") String type);

    @RequestMapping(value = "/myMoveToFile", method = RequestMethod.POST)
    public String editNoteToMoveById(
    		@RequestHeader(value = "userToken") String userToken, 
    		@RequestParam(value = "moveid") String moveid, 
    		@RequestParam(value = "toid") String toid, 
    		@RequestParam(value = "type") String type);

}
