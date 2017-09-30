package com.mhw.space.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhw.space.model.resource.ResourceEntity;
import com.mhw.space.service.resource.IResourceService;
import com.mhw.space.util.common.CommonResp;

@Controller
@RequestMapping(value="resource")
public class ResourceController {
	
	@Resource
	private IResourceService resourceService;

	@RequestMapping(value="selectResourceList")
	@ResponseBody
	public CommonResp selectResourceList(ResourceEntity resourceEntity){
		List<ResourceEntity> list = resourceService.selectResourceList(resourceEntity);
		return new CommonResp(list);
	}
	
}
