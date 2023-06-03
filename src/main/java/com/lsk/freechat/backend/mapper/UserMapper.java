package com.lsk.freechat.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsk.freechat.backend.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
