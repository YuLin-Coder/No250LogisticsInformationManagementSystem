package cn.oza.logistic.ssm.service;

import cn.oza.logistic.ssm.pojo.Export;
import cn.oza.logistic.ssm.pojo.ExportExample;

import java.util.List;

public interface ExportService {
    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);
}
