package com.h3c.itrd.testmodule.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.itrd.common.consts.StatusCodeEnum;
import com.h3c.itrd.common.entity.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 代理服务信息 前端控制器
 * </p>
 *
 * @author h3c-it
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/test")
@Api(value="测试" ,tags= {"测试"})
public class BAgentController {

	@PostMapping("/testInterface")
	@ResponseBody
	@ApiOperation(value = "接口1")
	public Result mothed1() {
		return new Result(true, StatusCodeEnum.SEARCH_SUCCESS,"Hello World");
	}
}
