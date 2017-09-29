package com.mhw.space.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhw.space.model.ResourceEntity;
import com.mhw.space.service.IResourceService;

@Controller
@RequestMapping(value="resource")
public class ResourceController {
	
	@Resource
	private IResourceService resourceService;

	@RequestMapping(value="selectResourceList")
	@ResponseBody
	public List<ResourceEntity> selectResourceList(ResourceEntity resourceEntity){
		return resourceService.selectResourceList(resourceEntity);
	}
}
