package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.CustomerViewMapper;
import cn.oza.logistic.ssm.pojo.CustomerView;
import cn.oza.logistic.ssm.pojo.CustomerViewExample;
import cn.oza.logistic.ssm.service.CustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerViewServiceImpl implements CustomerViewService {

    @Autowired
    private CustomerViewMapper customerViewMapper;

    @Override
    public int insert(CustomerView record) {
        return customerViewMapper.insert(record);
    }

    @Override
    public int insertSelective(CustomerView record) {
        return customerViewMapper.insertSelective(record);
    }

    @Override
    public List<CustomerView> selectByExample(CustomerViewExample example) {
        return customerViewMapper.selectByExample(example);
    }
}
