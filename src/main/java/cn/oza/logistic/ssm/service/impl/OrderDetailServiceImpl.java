package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.OrderDetailMapper;
import cn.oza.logistic.ssm.pojo.OrderDetail;
import cn.oza.logistic.ssm.pojo.OrderDetailExample;
import cn.oza.logistic.ssm.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long orderDetailId) {
        return orderDetailMapper.deleteByPrimaryKey(orderDetailId);
    }

    @Override
    public int insert(OrderDetail record) {
        return orderDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailMapper.insertSelective(record);
    }

    @Override
    public List<OrderDetail> selectByExample(OrderDetailExample example) {
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public OrderDetail selectByPrimaryKey(Long orderDetailId) {
        return orderDetailMapper.selectByPrimaryKey(orderDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKey(record);
    }
}
