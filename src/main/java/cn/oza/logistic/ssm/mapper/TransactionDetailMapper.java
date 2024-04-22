package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.TransactionDetail;
import cn.oza.logistic.ssm.pojo.TransactionDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long transactionDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    List<TransactionDetail> selectByExample(TransactionDetailExample example);

    TransactionDetail selectByPrimaryKey(Long transactionDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
}