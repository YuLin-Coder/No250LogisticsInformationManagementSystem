package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.PermissionMapper;
import cn.oza.logistic.ssm.pojo.Permission;
import cn.oza.logistic.ssm.pojo.PermissionExample;
import cn.oza.logistic.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int deleteByPrimaryKey(Long permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public int insert(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return insertSelective(record);
    }

    @Override
    public List<Permission> selectByExample(PermissionExample example) {
        return permissionMapper.selectByExample(example);
    }

    @Override
    public Permission selectByPrimaryKey(Long permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }
}
