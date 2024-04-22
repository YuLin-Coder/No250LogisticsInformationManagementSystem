package cn.oza.logistic.ssm.service;


import cn.oza.logistic.ssm.pojo.Role;
import cn.oza.logistic.ssm.pojo.RoleExample;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
