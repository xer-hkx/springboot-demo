package com.resource.share.controller;


import com.resource.share.entity.Resource;
import com.resource.share.service.ResourceService;
import com.resource.share.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/list")
    private Result<List> list(){
        Result<List> result = new Result<>();
        List<Resource> list = resourceService.queryResource();
        result.setCode(200);
        result.setMsg("所有资源信息：");
        result.setData(list);
        return result;
    }

    @GetMapping("/delete")
    private Result delete(Integer id){
        Result result = new Result();
        resourceService.deleteResource(id);
        result.setMsg("删除成功");
        result.setCode(200);
        return result;
    }
}
