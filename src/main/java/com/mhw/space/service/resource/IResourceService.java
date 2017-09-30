package com.mhw.space.service.resource;

import java.util.List;

import com.mhw.space.model.resource.ResourceEntity;

public interface IResourceService {

	List<ResourceEntity> selectResourceList(ResourceEntity resourceEntity);
}
