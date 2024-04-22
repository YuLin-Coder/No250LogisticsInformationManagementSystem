package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.OrderViewMapper;
import cn.oza.logistic.ssm.pojo.OrderView;
import cn.oza.logistic.ssm.pojo.OrderViewExample;
import cn.oza.logistic.ssm.service.OrderViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderViewServiceImpl implements OrderViewService {

    @Autowired
    private OrderViewMapper orderViewMapper;

    @Override
    public int insert(OrderView record) {
        return orderViewMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderView record) {
        return orderViewMapper.insertSelective(record);
    }

    @Override
    public List<OrderView> selectByExample(OrderViewExample example) {
        return orderViewMapper.selectByExample(example);
    }
}
