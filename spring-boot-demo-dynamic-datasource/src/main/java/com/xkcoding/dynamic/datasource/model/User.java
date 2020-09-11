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
 * 用户
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019/9/4 16:41
 */
@Data
@Table(name = "test_user")
public class User implements Serializable {
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
     * 姓名
     */
    @Column(name = "name")
    private String name;
}
