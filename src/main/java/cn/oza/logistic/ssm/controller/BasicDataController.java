package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.ssm.pojo.BasicData;
import cn.oza.logistic.ssm.pojo.BasicDataExample;
import cn.oza.logistic.ssm.service.BasicDataService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basicData")
public class BasicDataController {
    @Autowired
    private BasicDataService basicDataService;

    @RequestMapping("/list")
    @RequiresPermissions("basicData:list")
    public String basicDataList() {
        return "basicData/list";
    }

    /**
     * 该方法返回 admin 集合的 JSON 字符串，使用 PageHelper 工具进行分页
     * @param keyWord 搜索关键字
     * @param pageNum 页数，默认为 1
     * @param pageSize 每个页面用户容量，默认为 10/页
     * @return
     */
    @ResponseBody
    @RequestMapping("/getBasicDatas")
    @RequiresPermissions("basicData:list")
    public PageInfo<BasicData> getBasicDatas(String keyWord,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

         BasicDataExample basicDataExample = new BasicDataExample();

        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //权限名条件
            BasicDataExample.Criteria criteriaName = basicDataExample.createCriteria();
            criteriaName.andBaseNameLike("%" + keyWord + "%");
        }

        List<BasicData> basicDatas = basicDataService.selectByExample(basicDataExample);
        //获得分页对象
        PageInfo<BasicData> pageInfo = new PageInfo<>(basicDatas);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("basicData:delete")
    public Map<String, String> delete(Long[] basicDataIds) {
        HashMap<String, String> map = new HashMap<>();
        if (basicDataIds.length == 1) {
            int res = basicDataService.deleteByPrimaryKey(basicDataIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！数据已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = basicDataIds.length;
        for(Long basicDataId : basicDataIds) {
            success += basicDataService.deleteByPrimaryKey(basicDataId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 数据中的 " + success + " 个数据");
        return map;
    }


    @RequestMapping("/add")
    @RequiresPermissions("basicData:insert")
    public String addAdmin(Model m) {
        BasicDataExample basicDataExample = new BasicDataExample();
        BasicDataExample.Criteria criteria = basicDataExample.createCriteria();
        criteria.andParentIdIsNull();
        List<BasicData> basicDatas = basicDataService.selectByExample(basicDataExample);
        m.addAttribute("basicDatas", basicDatas);
        return "basicData/add";
    }

    @ResponseBody
    @RequestMapping("/checkBasicData")
    @RequiresPermissions("basicData:list")
    public Boolean checkPermission(String name, String curName) {
        if (curName != null && name.equals(curName)) {
            return true;
        }
        BasicDataExample basicDataExample = new BasicDataExample();
        BasicDataExample.Criteria criteria = basicDataExample.createCriteria();
        criteria.andBaseNameEqualTo(name);
        if (basicDataService.selectByExample(basicDataExample).size() != 0) {
            return false;
        }
        return true;
    }

    @ResponseBody
    @RequestMapping("/insert")
    @RequiresPermissions("basicData:insert")
    public Boolean insert(BasicData basicData){
        int res = basicDataService.insert(basicData);
        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("basicData:update")
    public String edit(Model m, Long basicDataId) {
        m.addAttribute("myBasicData", basicDataService.selectByPrimaryKey(basicDataId));

        BasicDataExample basicDataExample = new BasicDataExample();
        BasicDataExample.Criteria criteria = basicDataExample.createCriteria();
        criteria.andParentIdIsNull();
        m.addAttribute("basicDatas", basicDataService.selectByExample(basicDataExample));
        return "basicData/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("basicData:update")
    public Boolean update(BasicData basicData) {
        int res = basicDataService.updateByPrimaryKey(basicData);
        if (res == 1) {
            return true;
        }
        return false;
    }
}
