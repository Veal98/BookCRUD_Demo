package com.smallbeef.springboottest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 使用Entity将该类与数据库表绑定，根据类名和表名经行绑定（默认类名小写就是表名）;
 *
 * Data是lombok插件的方法，自动帮我们生成各种setter和getter方法
 */
@Entity
@Data
public class Book {
    // 和数据库表中的id绑定，表示这是主键
    @Id
    // 设置主键Id自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Integer price;
}
