package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.BasicDataMapper;
import cn.oza.logistic.ssm.pojo.BasicData;
import cn.oza.logistic.ssm.pojo.BasicDataExample;
import cn.oza.logistic.ssm.service.BasicDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicDataServiceImpl implements BasicDataService {
    @Autowired
    private BasicDataMapper basicDataMapper;

    @Override
    public int deleteByPrimaryKey(Long basicDataId) {
        return basicDataMapper.deleteByPrimaryKey(basicDataId);
    }

    @Override
    public int insert(BasicData record) {
        return basicDataMapper.insert(record);
    }

    @Override
    public int insertSelective(BasicData record) {
        return basicDataMapper.insertSelective(record);
    }

    @Override
    public List<BasicData> selectByExample(BasicDataExample example) {
        return basicDataMapper.selectByExample(example);
    }

    @Override
    public BasicData selectByPrimaryKey(Long basicDataId) {
        return basicDataMapper.selectByPrimaryKey(basicDataId);
    }

    @Override
    public int updateByPrimaryKeySelective(BasicData record) {
        return basicDataMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BasicData record) {
        return basicDataMapper.updateByPrimaryKey(record);
    }
}
