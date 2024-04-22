package cn.oza.logistic.ssm.service;

import cn.oza.logistic.ssm.pojo.ExportDetail;
import cn.oza.logistic.ssm.pojo.ExportDetailExample;

import java.util.List;

public interface ExportDetailService {
    int insert(ExportDetail record);

    int insertSelective(ExportDetail record);

    List<ExportDetail> selectByExample(ExportDetailExample example);
}
