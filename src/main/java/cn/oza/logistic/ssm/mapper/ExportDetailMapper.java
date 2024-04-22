package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.ExportDetail;
import cn.oza.logistic.ssm.pojo.ExportDetailExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExportDetailMapper {
    int insert(ExportDetail record);

    int insertSelective(ExportDetail record);

    List<ExportDetail> selectByExample(ExportDetailExample example);
}