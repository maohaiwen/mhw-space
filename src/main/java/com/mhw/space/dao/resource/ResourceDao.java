package com.mhw.space.dao.resource;

import java.util.List;

import com.mhw.space.model.resource.ResourceEntity;

public interface ResourceDao {

	List<ResourceEntity> selectResourceList(ResourceEntity resourceEntity);
}
