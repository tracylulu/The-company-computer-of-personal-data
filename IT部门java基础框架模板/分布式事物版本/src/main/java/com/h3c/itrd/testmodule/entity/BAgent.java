package com.h3c.itrd.testmodule.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 代理服务信息
 * </p>
 *
 * @author h3c-it
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BAgent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 代理服务地址
     */
    private String address;

    /**
     * 代理版本
     */
    private String version;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 其他配置信息,存储其他配置信息，数据通过json存储
     */
    private String properties;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 创建人域账号
     */
    private String createUser;

    /**
     * 最后修改人域账号
     */
    private String modifyUser;


}
