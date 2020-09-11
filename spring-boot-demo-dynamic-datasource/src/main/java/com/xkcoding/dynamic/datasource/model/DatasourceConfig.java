package com.xkcoding.dynamic.datasource.model;

import com.xkcoding.dynamic.datasource.utils.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 * 数据源配置表
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/9/4 10:58
 */
@Data
@Table(name = "datasource_config")
public class DatasourceConfig implements Serializable {
    /**
     * 主键
     */
//    @Id
//    @Column(name = "`id`")
//    @GeneratedValue(generator = "JDBC")
//    private Long id;
    @Id
    @Column(name = "id")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    /**
     * 数据库地址
     */
    @Column(name = "host")
    private String host;

    /**
     * 数据库端口
     */
    @Column(name = "port")
    private Integer port;

    /**
     * 数据库用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 数据库密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 数据库名称
     */
    @Column(name = "db_name")
    private String dbName;

    /**
     * 构造JDBC URL
     *
     * @return JDBC URL
     */
    public String buildJdbcUrl() {
//        return String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", this.host, this.port, this.database);
        return String.format("jdbc:sqlserver://%s:%s;SelectMethod=cursor;databasename=%s;username=%s;password=%s;sendStringParametersAsUnicode=false", this.host, this.port, this.dbName,this.username,this.password);
    }

}
