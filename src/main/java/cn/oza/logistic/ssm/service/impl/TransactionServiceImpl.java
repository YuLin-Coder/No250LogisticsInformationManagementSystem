package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.TransactionMapper;
import cn.oza.logistic.ssm.pojo.Transaction;
import cn.oza.logistic.ssm.pojo.TransactionExample;
import cn.oza.logistic.ssm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;
    @Override
    public int deleteByPrimaryKey(Long transactionId) {
        return transactionMapper.deleteByPrimaryKey(transactionId);
    }

    @Override
    public int insert(Transaction record) {
        return transactionMapper.insert(record);
    }

    @Override
    public int insertSelective(Transaction record) {
        return transactionMapper.insertSelective(record);
    }

    @Override
    public List<Transaction> selectByExample(TransactionExample example) {
        return transactionMapper.selectByExample(example);
    }

    @Override
    public Transaction selectByPrimaryKey(Long transactionId) {
        return transactionMapper.selectByPrimaryKey(transactionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Transaction record) {
        return transactionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Transaction record) {
        return transactionMapper.updateByPrimaryKey(record);
    }
}
