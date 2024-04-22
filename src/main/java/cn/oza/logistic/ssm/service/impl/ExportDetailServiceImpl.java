package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.ExportDetailMapper;
import cn.oza.logistic.ssm.mapper.ExportMapper;
import cn.oza.logistic.ssm.pojo.ExportDetail;
import cn.oza.logistic.ssm.pojo.ExportDetailExample;
import cn.oza.logistic.ssm.service.ExportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExportDetailServiceImpl implements ExportDetailService {
    @Autowired
    private ExportDetailMapper exportDetailMapper;
    @Override
    public int insert(ExportDetail record) {
        return exportDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(ExportDetail record) {
        return exportDetailMapper.insertSelective(record);
    }

    @Override
    public List<ExportDetail> selectByExample(ExportDetailExample example) {
        return exportDetailMapper.selectByExample(example);
    }
}
