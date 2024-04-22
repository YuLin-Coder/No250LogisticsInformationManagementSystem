package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.Info;
import cn.oza.logistic.ssm.pojo.InfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfoMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}