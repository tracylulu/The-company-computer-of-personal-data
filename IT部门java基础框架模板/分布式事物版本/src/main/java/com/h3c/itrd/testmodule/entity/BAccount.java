package com.h3c.itrd.testmodule.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账号信息
 * </p>
 *
 * @author h3c-it
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 1:服务器、 2:device、3：板卡 4:service
     */
    private Integer accountType;

    /**
     * 对应设备表的ID主键
     */
    private String deviceId;

    /**
     * 设备编码
     */
    private String deviceNo;

    /**
     * 访问类型：串口、管理口、HTTP、MIB等;已知的类型有：Console、Management、Http、Netconf、Snmp，此处扩展的频率中等，建议数据库不做枚举，前端UI做枚举
     */
    private String accessType;

    /**
     * 访问协议
     */
    private String protocol;

    /**
     * 访问地址
     */
    private String channel;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

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
