package cn.oza.logistic.ssm.service;


import cn.oza.logistic.ssm.pojo.CustomerView;
import cn.oza.logistic.ssm.pojo.CustomerViewExample;

import java.util.List;

public interface CustomerViewService {
    int insert(CustomerView record);

    int insertSelective(CustomerView record);

    List<CustomerView> selectByExample(CustomerViewExample example);
}
