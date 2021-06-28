package com.h3c.itrd.testmodule.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h3c.itrd.testmodule.entity.BAccount;
import com.h3c.itrd.testmodule.mapper.BAccountMapper;
import com.h3c.itrd.testmodule.service.IBAccountService;

/**
 * <p>
 * 账号信息 服务实现类
 * </p>
 *
 * @author h3c-it
 * @since 2021-04-28
 */
@Service
public class BAccountServiceImpl extends ServiceImpl<BAccountMapper, BAccount> implements IBAccountService {

}
