package cn.oza.logistic.ssm.service;

import cn.oza.logistic.ssm.pojo.TransactionDetail;
import cn.oza.logistic.ssm.pojo.TransactionDetailExample;

import java.util.List;

public interface TransactionDetailService {
    int deleteByPrimaryKey(Long transactionDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    List<TransactionDetail> selectByExample(TransactionDetailExample example);

    TransactionDetail selectByPrimaryKey(Long transactionDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
}
