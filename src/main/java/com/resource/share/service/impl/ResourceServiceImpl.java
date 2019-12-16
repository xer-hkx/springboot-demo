package com.resource.share.service.impl;

import com.resource.share.dao.ResourceDao;
import com.resource.share.entity.Resource;
import com.resource.share.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> queryResource() {
        return resourceDao.queryResource();
    }

    @Override
    public Resource queryResourceById(int id) {
        return resourceDao.queryResourceById(id);
    }

    @Transactional
    @Override
    public boolean insertResource(Resource resource) {
        if(resource.getName() != null && !"".equals(resource.getName())){
            resource.setPublishTime(new Date());
            resource.setDownload(0);
            try{
                int effectedNum = resourceDao.insertResource(resource);
                if(effectedNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入失败：" + e.getMessage());
            }
        }else{
            throw new RuntimeException("名称不能为空！");
        }
    }

    @Override
    public boolean deleteResource(int id) {
        if (id > 0) {
            try {
                int effectedNum = resourceDao.deleteResource(id);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("资源删除失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("资源id不能为空！");
        }
    }

    @Override
    public boolean updateResource(Resource resource) {
        if (resource.getId() != null && resource.getId() > 0) {
            try {
                int effectedNum = resourceDao.updateResource(resource);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("资源信息更改失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更改失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("资源信息不能为空！");
        }
    }
}
