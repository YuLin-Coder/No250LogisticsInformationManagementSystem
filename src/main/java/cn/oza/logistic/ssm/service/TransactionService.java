package cn.oza.logistic.ssm.service;

import cn.oza.logistic.ssm.pojo.Transaction;
import cn.oza.logistic.ssm.pojo.TransactionExample;

import java.util.List;

public interface TransactionService {
    int deleteByPrimaryKey(Long transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> selectByExample(TransactionExample example);

    Transaction selectByPrimaryKey(Long transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}
