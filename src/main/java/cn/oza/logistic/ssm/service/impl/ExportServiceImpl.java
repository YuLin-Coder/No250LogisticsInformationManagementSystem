package cn.oza.logistic.ssm.service.impl;

import cn.oza.logistic.ssm.mapper.ExportMapper;
import cn.oza.logistic.ssm.pojo.Export;
import cn.oza.logistic.ssm.pojo.ExportExample;
import cn.oza.logistic.ssm.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {
    @Autowired
    private ExportMapper exportMapper;
    @Override
    public int insert(Export record) {
        return exportMapper.insert(record);
    }

    @Override
    public int insertSelective(Export record) {
        return exportMapper.insertSelective(record);
    }

    @Override
    public List<Export> selectByExample(ExportExample example) {
        return exportMapper.selectByExample(example);
    }
}
