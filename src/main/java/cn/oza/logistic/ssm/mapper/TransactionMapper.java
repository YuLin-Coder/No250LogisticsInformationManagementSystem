package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.Transaction;
import cn.oza.logistic.ssm.pojo.TransactionExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionMapper {
    int deleteByPrimaryKey(Long transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    List<Transaction> selectByExample(TransactionExample example);

    Transaction selectByPrimaryKey(Long transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}