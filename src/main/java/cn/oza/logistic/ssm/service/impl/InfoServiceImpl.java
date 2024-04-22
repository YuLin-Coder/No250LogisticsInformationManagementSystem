package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.InfoMapper;
import cn.oza.logistic.ssm.pojo.Info;
import cn.oza.logistic.ssm.pojo.InfoExample;
import cn.oza.logistic.ssm.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public int deleteByPrimaryKey(Long orderId) {
        return infoMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(Info record) {
        return infoMapper.insert(record);
    }

    @Override
    public int insertSelective(Info record) {
        return infoMapper.insertSelective(record);
    }

    @Override
    public List<Info> selectByExample(InfoExample example) {
        return infoMapper.selectByExample(example);
    }

    @Override
    public Info selectByPrimaryKey(Long orderId) {
        return infoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(Info record) {
        return infoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Info record) {
        return infoMapper.updateByPrimaryKey(record);
    }
}
