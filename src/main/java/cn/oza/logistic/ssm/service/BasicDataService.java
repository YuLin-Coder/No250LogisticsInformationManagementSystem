package cn.oza.logistic.ssm.service;


import cn.oza.logistic.ssm.pojo.BasicData;
import cn.oza.logistic.ssm.pojo.BasicDataExample;

import java.util.List;

public interface BasicDataService {

    int deleteByPrimaryKey(Long basicDataId);

    int insert(BasicData record);

    int insertSelective(BasicData record);

    List<BasicData> selectByExample(BasicDataExample example);

    BasicData selectByPrimaryKey(Long basicDataId);

    int updateByPrimaryKeySelective(BasicData record);

    int updateByPrimaryKey(BasicData record);
}
