package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.BasicData;
import cn.oza.logistic.ssm.pojo.BasicDataExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BasicDataMapper {
    int deleteByPrimaryKey(Long baseId);

    int insert(BasicData record);

    int insertSelective(BasicData record);

    List<BasicData> selectByExample(BasicDataExample example);

    BasicData selectByPrimaryKey(Long baseId);

    int updateByPrimaryKeySelective(BasicData record);

    int updateByPrimaryKey(BasicData record);
}