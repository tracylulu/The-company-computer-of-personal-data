package com.h3c.itrd.testmodule.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h3c.itrd.testmodule.entity.BAgent;
import com.h3c.itrd.testmodule.mapper.BAgentMapper;
import com.h3c.itrd.testmodule.service.IBAgentService;

/**
 * <p>
 * 代理服务信息 服务实现类
 * </p>
 *
 * @author h3c-it
 * @since 2021-04-28
 */
@Service
public class BAgentServiceImpl extends ServiceImpl<BAgentMapper, BAgent> implements IBAgentService {

}
