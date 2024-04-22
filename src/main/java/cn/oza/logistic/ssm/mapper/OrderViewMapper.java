package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.OrderView;
import cn.oza.logistic.ssm.pojo.OrderViewExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderViewMapper {
    int insert(OrderView record);

    int insertSelective(OrderView record);

    List<OrderView> selectByExample(OrderViewExample example);
}