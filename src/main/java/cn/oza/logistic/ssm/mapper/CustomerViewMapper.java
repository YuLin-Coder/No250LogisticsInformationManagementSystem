package cn.oza.logistic.ssm.mapper;


import cn.oza.logistic.ssm.pojo.CustomerView;
import cn.oza.logistic.ssm.pojo.CustomerViewExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerViewMapper {
    int insert(CustomerView record);

    int insertSelective(CustomerView record);

    List<CustomerView> selectByExample(CustomerViewExample example);
}