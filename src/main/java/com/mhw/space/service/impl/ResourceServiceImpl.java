package com.mhw.space.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mhw.space.dao.resource.ResourceDao;
import com.mhw.space.model.ResourceEntity;
import com.mhw.space.service.IResourceService;
@Service
public class ResourceServiceImpl implements IResourceService{

	@Resource
	private ResourceDao resourceDao;
	
	@Override
	public List<ResourceEntity> selectResourceList(ResourceEntity resourceEntity) {
		return resourceDao.selectResourceList(resourceEntity);
	}

}
