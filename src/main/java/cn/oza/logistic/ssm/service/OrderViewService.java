package cn.oza.logistic.ssm.service;


import cn.oza.logistic.ssm.pojo.OrderView;
import cn.oza.logistic.ssm.pojo.OrderViewExample;

import java.util.List;

public interface OrderViewService {
    int insert(OrderView record);

    int insertSelective(OrderView record);

    List<OrderView> selectByExample(OrderViewExample example);
}
