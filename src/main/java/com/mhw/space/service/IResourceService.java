package com.mhw.space.service;

import java.util.List;

import com.mhw.space.model.ResourceEntity;

public interface IResourceService {

	List<ResourceEntity> selectResourceList(ResourceEntity resourceEntity);
}
