package cn.oza.logistic.ssm.service;


import cn.oza.logistic.ssm.pojo.Customer;
import cn.oza.logistic.ssm.pojo.CustomerExample;

import java.util.List;

public interface CustomerService {
    int deleteByPrimaryKey(Long customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}
