package cn.oza.logistic.ssm.service;



import cn.oza.logistic.ssm.pojo.Permission;
import cn.oza.logistic.ssm.pojo.PermissionExample;

import java.util.List;

public interface PermissionService {
    int deleteByPrimaryKey(Long permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
