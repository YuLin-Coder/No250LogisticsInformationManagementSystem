package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.TransactionDetailMapper;
import cn.oza.logistic.ssm.pojo.TransactionDetail;
import cn.oza.logistic.ssm.pojo.TransactionDetailExample;
import cn.oza.logistic.ssm.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long transactionDetailId) {
        return transactionDetailMapper.deleteByPrimaryKey(transactionDetailId);
    }

    @Override
    public int insert(TransactionDetail record) {
        return transactionDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(TransactionDetail record) {
        return 0;
    }

    @Override
    public List<TransactionDetail> selectByExample(TransactionDetailExample example) {
        return transactionDetailMapper.selectByExample(example);
    }

    @Override
    public TransactionDetail selectByPrimaryKey(Long transactionDetailId) {
        return transactionDetailMapper.selectByPrimaryKey(transactionDetailId);
    }

    @Override
    public int updateByPrimaryKeySelective(TransactionDetail record) {
        return transactionDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TransactionDetail record) {
        return transactionDetailMapper.updateByPrimaryKey(record);
    }
}
