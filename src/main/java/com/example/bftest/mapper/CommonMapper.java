package com.example.bftest.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author asd
 * @date 2018/12/13 20:36
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
