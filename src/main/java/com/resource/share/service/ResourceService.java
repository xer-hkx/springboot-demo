package com.resource.share.service;


import com.resource.share.entity.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> queryResource();
    Resource queryResourceById(int id);
    boolean insertResource(Resource resource);
    boolean deleteResource(int id);
    boolean updateResource(Resource resource);

}
