package com.resource.share.dao;

import com.resource.share.entity.Resource;

import java.util.List;

public interface ResourceDao {
    List<Resource> queryResource();
    Resource queryResourceById(int id);
    int insertResource(Resource resource);
    int deleteResource(int id);
    int updateResource(Resource resource);

}
