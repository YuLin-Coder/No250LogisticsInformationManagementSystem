package cn.oza.logistic.ssm.service;

import cn.oza.logistic.ssm.pojo.Info;
import cn.oza.logistic.ssm.pojo.InfoExample;

import java.util.List;

public interface InfoService {
    int deleteByPrimaryKey(Long orderId);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}
