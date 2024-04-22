package cn.oza.logistic.ssm.mapper;

import cn.oza.logistic.ssm.pojo.Export;
import cn.oza.logistic.ssm.pojo.ExportExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExportMapper {
    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);
}